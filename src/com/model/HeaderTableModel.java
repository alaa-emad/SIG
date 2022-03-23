package com.model;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HeaderTableModel extends DefaultTableModel {
    private String[] colsNames = {"No. ", "Date", "Customer Name", "Total"};
    private ArrayList<InvoiceHeader> invoices;
    public HeaderTableModel(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getColumnCount() {
        return colsNames.length;
    }

    public String getColumnName(int i) {
        return colsNames[i];
    }

    @Override
    public int getRowCount() {
        if (this.invoices == null){
            invoices = new ArrayList<>();
        }
        return invoices.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        InvoiceHeader inv = invoices.get(i);
        switch (i1){
            case 0: return inv.getNum();
            case 1: return inv.getCustomerName();
            case 2: return inv.getDate();
            case 3: return inv.getInvoiceTotal();
        }
        return null;
    }

}
