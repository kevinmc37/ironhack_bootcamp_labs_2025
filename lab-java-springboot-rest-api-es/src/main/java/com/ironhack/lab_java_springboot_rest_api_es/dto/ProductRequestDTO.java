package com.ironhack.lab_java_springboot_rest_api_es.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductRequestDTO {
    @NotBlank(message = "Name can't be blank, null or empty")
    @Size(min = 3, message = "Name has to be at least 3 characters long")
    private String name;

    @NotBlank(message = "Category can't be blank, null or empty")
    private String category;

    @Positive(message = "Price has to be greater than 0")
    private double price;

    @Positive(message = "Quantity has to be greater than 0")
    private int quantity;

    public ProductRequestDTO() {}

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

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
