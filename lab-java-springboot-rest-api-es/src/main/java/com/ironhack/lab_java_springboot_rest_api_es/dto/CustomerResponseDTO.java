package com.ironhack.lab_java_springboot_rest_api_es.dto;

public class CustomerResponseDTO {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String address;

    public CustomerResponseDTO() {}

    public CustomerResponseDTO(Long id, String name, int age, String email, String address) {
        setId(id);
        setName(name);
        setAge(age);
        setEmail(email);
        setAddress(address);
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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
