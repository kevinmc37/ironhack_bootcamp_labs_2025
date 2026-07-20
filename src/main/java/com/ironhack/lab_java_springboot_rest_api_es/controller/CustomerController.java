package com.ironhack.lab_java_springboot_rest_api_es.controller;

import com.ironhack.lab_java_springboot_rest_api_es.dto.CustomerRequestDTO;
import com.ironhack.lab_java_springboot_rest_api_es.dto.CustomerResponseDTO;
import com.ironhack.lab_java_springboot_rest_api_es.model.Customer;

import com.ironhack.lab_java_springboot_rest_api_es.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ironhack.lab_java_springboot_rest_api_es.controller.ProductController.validateAPIKey;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping()
    public List<Customer> getAllCustomers(@RequestHeader("API-Key") String apiKey) {
        validateAPIKey(apiKey);
        return customerService.getAllCustomers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@RequestHeader("API-Key") String apiKey, @PathVariable String email) {
        validateAPIKey(apiKey);
        Customer customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestHeader("API-Key") String apiKey, @RequestBody @Valid CustomerRequestDTO customer) {
        validateAPIKey(apiKey);
        CustomerResponseDTO responseDTO = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteCustomer(@RequestHeader("API-Key") String apiKey, @PathVariable String email) {
        validateAPIKey(apiKey);
        customerService.deleteCustomer(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{email}")
    public Customer updateCustomer(@RequestHeader("API-Key") String apiKey, @PathVariable String email, @RequestBody @Valid CustomerRequestDTO customer) {
        validateAPIKey(apiKey);
        return customerService.updateCustomer(email, customer);
    }
}
