package com.product.model;

public class Product {
    private int code;
    private String name;
    private  double price;
    private  String brand;

    public Product(int code, String name, double price, String brand) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
