package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductDao implements ProductDao{

    private List<Product> products;

    public SimpleProductDao() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 1200.00));
        products.add(new Product(2, "Smartphone", "Electronics", 800.00));
        products.add(new Product(3, "Desk Chair", "Furniture", 150.00));

    }
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    public void deleteProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
    }

    public void updateProduct(int productId, String name, String category, double price) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setName(name);
                product.setCategory(category);
                product.setPrice(price);
                break;
            }
        }
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
