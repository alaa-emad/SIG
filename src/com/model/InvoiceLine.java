package com.model;

import java.util.ArrayList;

public class InvoiceLine {
    private String product;
    private double price;
    private int count;
    double LineTotal;
    InvoiceHeader invoice;

    public InvoiceLine(String product, double price, int count, InvoiceHeader invoice) {
        this.product = product;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLineTotal() {
        double LineTotal = this.getCount() * this.getPrice();
        return LineTotal;
    }

    public void setLineTotal(double lineTotal) {
        LineTotal = lineTotal;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }
}

