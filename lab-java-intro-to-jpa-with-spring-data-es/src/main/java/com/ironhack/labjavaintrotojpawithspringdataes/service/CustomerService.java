package com.ironhack.labjavaintrotojpawithspringdataes.service;

import com.ironhack.labjavaintrotojpawithspringdataes.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpawithspringdataes.model.Customer;
import com.ironhack.labjavaintrotojpawithspringdataes.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerByStatus(CustomerStatus status) {
        return customerRepository.findByStatus(status);
    }

    public List<Customer> getCustomerByMileageGreaterThan(int mileage) {
        return customerRepository.findByMileageGreaterThan(mileage);
    }
}
