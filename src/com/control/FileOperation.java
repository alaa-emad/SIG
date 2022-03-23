package com.control;

import com.model.*;
import com.view.CreateNewInvoice;
import com.view.InvoiceGeneratorUI;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileOperation {
    InvoiceGeneratorUI view;
    private ArrayList<InvoiceHeader> invoices;
    private ArrayList<newItem> itemsLine;
    private InvoiceHeader newInvoice;
    private InvoiceLine newLine;
    private SimpleDateFormat df;
    private HeaderTableModel headerModel;
    private LinesTableModel lineModel;
    private CreateNewInvoice createNewInvoice;
    private String customer ;
    private String invDateStr;
    private String itemName;
    private String itemCountStr;
    private String itemPriceStr;
    private Date invoiceDate;
    private int num;

    public FileOperation(InvoiceGeneratorUI view){
        this.view = view;
        invoices = new ArrayList<>();
        itemsLine = new ArrayList<>();

        df = new SimpleDateFormat("dd-mm-yy");
    }

    public void loadFile() throws Exception {
        JOptionPane.showMessageDialog(view, "Please select Invoice file", "Invoice Header", JOptionPane.WARNING_MESSAGE);
        JFileChooser fo = new JFileChooser();
        int option = fo.showOpenDialog(view);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fo.getSelectedFile();
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] headerSegments = line.split(",");
                String invNumStr = headerSegments[0];
                String invDateStr = headerSegments[1];
                String cusName = headerSegments[2];
                int invNum = Integer.parseInt(invNumStr);
                Date invDate = df.parse(invDateStr);
                InvoiceHeader header = new InvoiceHeader(invNum, invDate, cusName);
                invoices.add(header);
            }
            br.close();
            fr.close();

            JOptionPane.showMessageDialog(view, "Please select Invoice lines file", "Invoice lines", JOptionPane.WARNING_MESSAGE);
            option = fo.showOpenDialog(view);
            if (option == JFileChooser.APPROVE_OPTION) {
                selectedFile = fo.getSelectedFile();
                fr = new FileReader(selectedFile);
                br = new BufferedReader(fr);
                line = null;
                while ((line = br.readLine()) != null) {
                    String[] lineSegments = line.split(",");
                    String invNumStr = lineSegments[0];
                    String item = lineSegments[1];
                    String priceStr = lineSegments[2];
                    String countStr = lineSegments[3];
                    int invNum = Integer.parseInt(invNumStr);
                    double price = Double.parseDouble(priceStr);
                    int count = Integer.parseInt(countStr);
                    InvoiceHeader header = findByNum(invNum);
                    InvoiceLine invLine = new InvoiceLine(item, price, count, header);
                    header.getLines().add(invLine);
                }
                br.close();
                fr.close();
                headerModel = new HeaderTableModel(invoices);
                view.InvoiceTable.setModel(headerModel);

            }
            TestReadingFile();
        }
    }
    public void saveFile () throws IOException {
        JOptionPane.showMessageDialog(view, "Save invoice header file ", "Invoice Header", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Choose File Save");
        int userSelection = fs.showSaveDialog(view);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fs.getSelectedFile();
            FileWriter fw = new FileWriter(fileToSave + ".csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < view.InvoiceTable.getRowCount(); i++) {
                for (int j = 0; j < view.InvoiceTable.getColumnCount(); j++) {

                    bw.write(view.InvoiceTable.getValueAt(i, j).toString() + ",");
                }
                bw.newLine();
            }
            JOptionPane.showMessageDialog(view, "Saved Successfully ", "Save Message", JOptionPane.INFORMATION_MESSAGE);
            bw.close();
            fw.close();

            JOptionPane.showMessageDialog(view, "Save invoice line file ", "Invoice Line", JOptionPane.INFORMATION_MESSAGE);
            fs = new JFileChooser();
            fs.setDialogTitle("Choose File Save");
            userSelection = fs.showSaveDialog(view);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                fileToSave = fs.getSelectedFile();
                fw = new FileWriter(fileToSave + ".csv");
                bw = new BufferedWriter(fw);
                for (InvoiceHeader inv: invoices) {
                    for (InvoiceLine item: inv.getLines()) {
                        bw.write(inv.getNum()+ "," +item.getProduct()+ "," +item.getPrice()+ "," + item.getCount());
                        bw.newLine();
                    }

                }
                JOptionPane.showMessageDialog(view, "Saved Successfully ", "Save Message", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();

            }
        }
    }
    private InvoiceHeader findByNum(int num){
        for (InvoiceHeader header: invoices){
            if (header.getNum() == num){
                return header;
            }
        }
        return null;
    }

    public void createInvoiceFn(){
        createNewInvoice = new CreateNewInvoice(view);
        createNewInvoice.setTitle("Create New Invoice");
        createNewInvoice.setLocationRelativeTo(null);
        createNewInvoice.setVisible(true);
    }
    public void deleteInvoiceFn () throws Exception {
        view.InvoiceTable.setModel(headerModel);
        int row = view.InvoiceTable.getSelectedRow();
        invoices.remove(row);
        headerModel.fireTableDataChanged();

    }
    public void createInvoiceOk(){
        customer = createNewInvoice.getCustomerName().getText();
        invDateStr = createNewInvoice.getInvoiceDate().getText();
        invoiceDate = new Date();
        try {
            invoiceDate = df.parse(invDateStr);
        } catch(ParseException ex){
            JOptionPane.showMessageDialog(view,"Wrong Data Format","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        saveNewItem();
        createNewInvoice.setVisible(false);
        num = getLastNum() + 1 ;

        newInvoice = new InvoiceHeader(num, invoiceDate,customer);
        invoices.add(newInvoice);
        for(newItem i:  itemsLine){
            newLine = new InvoiceLine(i.getItem(), i.getPrice(), i.getCount(), newInvoice);
            newInvoice.getLines().add(newLine);
        }

        headerModel.fireTableDataChanged();
    }
    public void addNewItem(){

        saveNewItem();
        createNewInvoice.countDialouge.setText("");
        createNewInvoice.itemNameDialouge.setText("");
        createNewInvoice.itemPriceDialouge.setText("");
    }

    public void saveNewItem(){
        itemName = createNewInvoice.getItemName().getText();
        itemCountStr = createNewInvoice.getItemCount().getText();
        itemPriceStr= createNewInvoice.getItemPrice().getText();

        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice= Double.parseDouble(itemPriceStr);

        newItem nItem = new newItem(itemName, itemPrice, itemCount);
        itemsLine.add(nItem);
    }
    public void createInvoiceCancel(){createNewInvoice.setVisible(false); }
    private int getLastNum(){
        int num= 0;
        for (InvoiceHeader header : invoices) {
            if (header.getNum() > num)
            {
                num = header.getNum();
            }

        }
        return num;
    }
    public ArrayList<InvoiceHeader> getInvoices() {
        return this.invoices;
    }

    public void TestReadingFile(){
        for (InvoiceHeader invoice: invoices){
            System.out.println(invoice.getNum());
            System.out.println("{");
            System.out.println(invoice.getDate()+"," + invoice.getCustomerName());
            for (InvoiceLine line: invoice.getLines()){
                System.out.println(line.getProduct()+","+line.getPrice()+","+line.getCount());
            }
            System.out.println("}");
            System.out.println(" ");
        }
    }
}
