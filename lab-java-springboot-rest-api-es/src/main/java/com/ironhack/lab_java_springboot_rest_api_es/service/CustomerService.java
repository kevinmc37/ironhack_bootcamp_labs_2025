package com.ironhack.lab_java_springboot_rest_api_es.service;

import com.ironhack.lab_java_springboot_rest_api_es.dto.CustomerRequestDTO;
import com.ironhack.lab_java_springboot_rest_api_es.dto.CustomerResponseDTO;
import com.ironhack.lab_java_springboot_rest_api_es.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public CustomerService() {
        customers.add(new Customer((long)customers.size(), "John Egels", 26, "jhonae@chat.es", "hollywood 26"));
        customers.add(new Customer((long)customers.size(), "  ", 38, "ajaaja@chat.es", "hollywood 38"));
        customers.add(new Customer((long)customers.size(), "Mary Cool", 17, "mary_19@chat.es", "hollywood 19"));
        customers.add(new Customer((long)customers.size(), "Frank Jess", 27, ".frank36@chat.es", "hollywood 36"));
        customers.add(new Customer((long)customers.size(), "Marko Epitasius", 40, "markoep@chat.es", "  "));
        customers.add(new Customer((long)customers.size(), "Steffano Glow", 19, "steffcheff@chat@es", "hollywood 2"));
        customers.add(new Customer((long)customers.size(), "Maritza Stark", 87, "maritz87@ya.hoo.com", "hollywood 87"));
    }
    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (email == null) { return null; }
            if (customer.getEmail().equals(email)) { return customer; }
        }
        return null;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer newCustomer = new Customer((long)customers.size(), customerRequestDTO.getName(),
                customerRequestDTO.getAge(), customerRequestDTO.getEmail(), customerRequestDTO.getAddress());
        customers.add(newCustomer);
        return new CustomerResponseDTO(newCustomer.getId(), newCustomer.getName(), newCustomer.getAge(),
                newCustomer.getEmail(), newCustomer.getAddress());
    }

    public void deleteCustomer(String email) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customerFromList = customers.get(i);
            if (customerFromList.getEmail().equals(email)) {
                customers.remove(i);
                break;
            }
        }
    }

    public Customer updateCustomer(String email, CustomerRequestDTO customerRequestDTO) {
        Customer customerFromList = getCustomerByEmail(email);
        if (customerFromList == null) { return null; }
        customerFromList.setName(customerRequestDTO.getName());
        customerFromList.setAge(customerRequestDTO.getAge());
        customerFromList.setEmail(customerRequestDTO.getEmail());
        customerFromList.setAddress(customerRequestDTO.getAddress());
        return customerFromList;
    }
}
