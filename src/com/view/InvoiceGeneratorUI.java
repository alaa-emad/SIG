package com.view;

import com.control.FileOperation;
import com.model.HeaderTableModel;
import com.model.InvoiceHeader;
import com.model.InvoiceLine;
import com.model.LinesTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceGeneratorUI extends JFrame implements ActionListener, ListSelectionListener {
    public InvoiceGeneratorUI() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        InvoiceTable.getSelectionModel().addListSelectionListener(this);
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceItemsTable = new javax.swing.JTable();

        SaveBtn = new javax.swing.JButton();
        SaveBtn.setActionCommand("SaveChanges");
        SaveBtn.addActionListener(this);

        CancelBtn = new javax.swing.JButton();
        CancelBtn.setActionCommand("Cancel");
        CancelBtn.addActionListener(this);

        CreateNewBtn = new javax.swing.JButton();
        CreateNewBtn.setActionCommand("CreateNew");
        CreateNewBtn.addActionListener(this);

        DeleteBtn = new javax.swing.JButton();
        DeleteBtn.setActionCommand("DeleteInvoice");
        DeleteBtn.addActionListener(this);

        InvoiceNameTextField = new javax.swing.JTextField();
        InvoiceDateTextField = new javax.swing.JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        InvoiceNumberValue = new JLabel();
        InvoiceValueTotal = new JLabel();
        MenuBar = new JMenuBar();
        FileMenu = new JMenu();
        LoadMenuItem = new JMenuItem();
        LoadMenuItem.setActionCommand("Load");
        LoadMenuItem.addActionListener(this);
        SaveMenuItem = new JMenuItem();
        SaveMenuItem.setActionCommand("Save");
        SaveMenuItem.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Invoice Table"));

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "No.", "Date", "Customer", "Total"
                }
        ));
        jScrollPane1.setViewportView(InvoiceTable);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder("Invoice Items"));

        InvoiceItemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "No.", "Item Name", "Item Price", "Count", "Item Total"
                }
        ));
        jScrollPane2.setViewportView(InvoiceItemsTable);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addContainerGap())
        );

        SaveBtn.setText("Save");
        CancelBtn.setText("Cancel");
        CreateNewBtn.setText("Create New");
        DeleteBtn.setText("Delete");
        InvoiceNameTextField.setText("Name");
        InvoiceDateTextField.setText("Date");
        jLabel1.setText("Invoice Name");
        jLabel2.setText("Invoice Date");
        jLabel3.setText("Invoice Number");
        jLabel4.setText("Invoice Total");
        InvoiceNumberValue.setText("Invoice Number");
        InvoiceValueTotal.setText("Total");
        FileMenu.setText("File");
        LoadMenuItem.setText("Load File");
        FileMenu.add(LoadMenuItem);
        SaveMenuItem.setText("Save File");
        FileMenu.add(SaveMenuItem);
        MenuBar.add(FileMenu);
        setJMenuBar(MenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(InvoiceValueTotal)
                                                        .addComponent(InvoiceDateTextField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(InvoiceNameTextField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(InvoiceNumberValue))
                                                .addGap(97, 97, 97))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(CreateNewBtn, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(DeleteBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(CancelBtn, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(InvoiceNumberValue)
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(InvoiceNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(InvoiceDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(InvoiceValueTotal))
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CreateNewBtn)
                                        .addComponent(CancelBtn)
                                        .addComponent(SaveBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DeleteBtn))
                                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGeneratorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    public JButton CancelBtn;
    public JButton CreateNewBtn;
    public JButton DeleteBtn;
    public JMenu FileMenu;
    public JTextField InvoiceDateTextField;
    public JTable InvoiceItemsTable;
    public JTextField InvoiceNameTextField;
    public JLabel InvoiceNumberValue;
    public JTable InvoiceTable;
    public JLabel InvoiceValueTotal;
    public JMenuItem LoadMenuItem;
    public JMenuBar MenuBar;
    public JButton SaveBtn;
    public JMenuItem SaveMenuItem;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JPanel jPanel1;
    public JPanel jPanel2;
    public JScrollPane jScrollPane1;
    public JScrollPane jScrollPane2;

    private FileOperation control = new FileOperation(this);


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Load")){
            try{ control.loadFile(); }
            catch (Exception ex) {ex.printStackTrace();}

        } else if (actionEvent.getActionCommand().equals("Save")){
            try{ control.saveFile(); }
            catch (IOException e){e.printStackTrace();}
        }
        else if(actionEvent.getActionCommand()=="CreateNew") { control.createInvoiceFn(); }
        else if(actionEvent.getActionCommand()=="DeleteInvoice") {
            try { control.deleteInvoiceFn(); }
            catch (Exception file){
                JOptionPane.showMessageDialog(this,"Please select an invoice to delete","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(actionEvent.getActionCommand()=="SaveChanges") {
            try { control.saveFile(); }
            catch (IOException ex) { ex.printStackTrace(); }
        }
        else if(actionEvent.getActionCommand()=="Cancel") {
            try {/*control.deleteInvoiceFn ();*/}
            catch (Exception item) {JOptionPane.showMessageDialog(this,"Please select an item to delete","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (actionEvent.getActionCommand()=="addNewItem"){control.addNewItem();}
        else if(actionEvent.getActionCommand()=="createOK") {control.createInvoiceOk();}
        else if(actionEvent.getActionCommand()=="CancelNewInvoice") {control.createInvoiceCancel();}
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

        int rowIndex = InvoiceTable.getSelectedRow();
        if (rowIndex != -1){
            InvoiceHeader detailsData = control.getInvoices().get(rowIndex);
            InvoiceNumberValue.setText(Integer.toString(detailsData.getNum()));
            InvoiceDateTextField.setText(String.valueOf(detailsData.getDate()));
            InvoiceNameTextField.setText(detailsData.getCustomerName());
            InvoiceValueTotal.setText(String.valueOf(detailsData.getInvoiceTotal()));
            LinesTableModel linesModel = new LinesTableModel(detailsData.getLines());
            InvoiceItemsTable.setModel(linesModel);
        }

    }
}
