package com.pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    private int productId;
    private String name;
    private String category;

    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private double price;

    public Product(){}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString to print meaningful details about the product
    @Override
    public String toString() {
        return String.format("Product ID: %d, Name: %s, Category: %s, Price: %.2f", productId, name, category, price);
    }
}
