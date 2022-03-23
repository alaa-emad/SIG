package com.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LinesTableModel extends AbstractTableModel {
    private String[] colsNames = {"Item Name", "Price", "Count", "Item Total"};
    private ArrayList<InvoiceLine> invoiceLinesList;
    public LinesTableModel(ArrayList<InvoiceLine> invoiceLinesList) {
        this.invoiceLinesList = invoiceLinesList;
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
        return invoiceLinesList.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        InvoiceLine inv = invoiceLinesList.get(i);
        switch (i1){
            case 0: return inv.getProduct();
            case 1: return inv.getPrice();
            case 2: return inv.getCount();
            case 3: return  inv.getLineTotal();
        }
        return null;
    }
}
