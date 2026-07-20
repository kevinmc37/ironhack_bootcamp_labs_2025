package com.ironhack.lab_java_springboot_rest_api_es.model;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(Long id, String name, String category, double price, int quantity) {
        setId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
        setQuantity(quantity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int MIN_NAME_LENGTH = 3;
        if (!name.isBlank() && name.length() > MIN_NAME_LENGTH) { this.name = name; }
        else { this.name = "Placeholder"; }
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) { this.price = price; }
        else if (price < 0) { this.price = -price; }
        else { this.price = 0.99; }
    }

    public String getCategory() {
        if (!category.isBlank()) { return category; }
        else { return "category"; }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = Math.max(quantity, 0); }
}
