package com.pluralsight.NorthwindTradersSpringBoot;


import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private SimpleProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(NorthwindApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Store Management =====");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Update Product");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (option) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    updateProduct(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // List all products
    private void listProducts() {
        List<Product> products = productDao.getAllProduct();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\n===== Product List =====");
            products.forEach(System.out::println);
        }
    }

    // Add a product
    private void addProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, category, price);
        productDao.addProduct(product);
        System.out.println("Product added successfully!");
    }

    // Delete a product by ID
    private void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        productDao.deleteProduct(productId);
        System.out.println("Product deleted successfully!");
    }

    // Update a product
    private void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();

        productDao.updateProduct(productId, name, category, price);
        System.out.println("Product updated successfully!");
    }

    // Search products by name
    private void searchProduct(Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();
        List<Product> foundProducts = productDao.searchByName(name);
        if (foundProducts.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("\n===== Search Results =====");
            foundProducts.forEach(System.out::println);
        }
    }
}
