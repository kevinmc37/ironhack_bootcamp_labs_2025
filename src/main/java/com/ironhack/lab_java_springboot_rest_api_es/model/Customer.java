package com.ironhack.lab_java_springboot_rest_api_es.model;

public class Customer {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String address;

    public Customer(Long id, String name, int age, String email, String address) {
        setId(id);
        setName(name);
        setAge(age);
        setEmail(email);
        setAddress(address);
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
        if (!name.isBlank()) { this.name = name; }
        else { this.name = id + "invalid.name";}
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) { this.age = age; }
        else { this.age = 0; }
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        boolean validEmail = true;
        if (!email.isBlank() && email.contains("@") && email.contains(".") && email.length() > 5) {
            String[] emailParts = email.split("@", 2);
            if (emailParts[0].contains("..") || emailParts[0].charAt(0) == '.'
                    || emailParts[0].charAt(emailParts[0].length() - 1) == '.' || emailParts[0].length() < 3) {
                validEmail = false;
            }
            if (emailParts[1].contains("@") || emailParts[1].contains("..") || emailParts[1].charAt(0) == '.'
                    || emailParts[1].charAt(emailParts[1].length() - 1) == '.' || emailParts[1].length() < 4) {
                validEmail = false;
            }
        }
        else { validEmail = false; }
        if (validEmail) { this.email = email; }
        else { this.email = id + "@invalid.email";}
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        if (!address.isBlank()) { this.address = address; }
        else { this.address = id + "invalid.address";}
    }
}
