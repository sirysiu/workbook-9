package com.pluralsight.rest;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Product() {
    }

    public Product(double price, String category, String name, int productId) {
        this.price = price;
        this.category = category;
        this.name = name;
        this.productId = productId;
    }
}
