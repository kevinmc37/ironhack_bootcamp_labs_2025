package com.ironhack.labjavaintrotojpawithspringdataes.controller;

import com.ironhack.labjavaintrotojpawithspringdataes.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpawithspringdataes.model.Customer;
import com.ironhack.labjavaintrotojpawithspringdataes.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/status")
    public List<Customer> getCustomerByStatus(@RequestParam CustomerStatus status) {
        return customerService.getCustomerByStatus(status);
    }

    @GetMapping("/mileage")
    public List<Customer> getCustomerByMileageGreaterThan(@RequestParam int mileage) {
        return customerService.getCustomerByMileageGreaterThan(mileage);
    }
}
