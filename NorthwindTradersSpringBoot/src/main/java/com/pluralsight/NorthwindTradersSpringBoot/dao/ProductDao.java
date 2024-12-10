package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);
    List<Product> getAllProduct();


    void deleteProduct(int productId);

    void updateProduct(int productId, String name, String category, double price);

    List<Product> searchByName(String name);
}
