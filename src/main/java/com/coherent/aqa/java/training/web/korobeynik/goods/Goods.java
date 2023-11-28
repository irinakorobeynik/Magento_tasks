package com.coherent.aqa.java.training.web.korobeynik.goods;

public class Goods {
    private String name;
    private double price;
    private int size;
    private String colour;
    private static double total;

    public String getName() {
        return name;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
        this.total+=price;
    }

    public Goods(String name) {
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public static double getTotal(){
        return total;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
