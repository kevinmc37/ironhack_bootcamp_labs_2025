package com.ironhack.lab_java_springboot_rest_api_es.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CustomerRequestDTO {
    @NotBlank(message = "Name can't be blank, null or empty")
    private String name;

    @Min(value = 18, message = "Age has to be greater than 18")
    private int age;

    @NotBlank(message = "Email can't be blank, null or empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address can't be blank, null or empty")
    private String address;

    public CustomerRequestDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
