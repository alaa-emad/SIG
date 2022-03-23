package com.model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int num;
    private Date date;
    private String CustomerName;
    private double InvoiceTotal;
    ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int num, Date date, String CustomerName){
        this.num = num;
        this.date = date;
        this.CustomerName = CustomerName;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null)
            lines = new ArrayList<>();
        return lines;
    }

    public double getInvoiceTotal() {
        double InvoiceTotal = 0;
        for (InvoiceLine line: this.getLines()){
            InvoiceTotal += (line.getCount()*line.getPrice());
        }
        return InvoiceTotal;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        InvoiceTotal = invoiceTotal;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
