package com.model;

public class newItem {
    private String item;
    private double price;
    private int count;

    public newItem (String item,double price, int count){
        this.item = item;
        this.price = price;
        this.count = count;
    }
    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
