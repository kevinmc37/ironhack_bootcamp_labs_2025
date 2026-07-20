package com.ironhack.labjavaintrotojpawithspringdataes.repository;

import com.ironhack.labjavaintrotojpawithspringdataes.model.Customer;
import com.ironhack.labjavaintrotojpawithspringdataes.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByStatus(CustomerStatus status);
    List<Customer> findByMileageGreaterThan(int mileage);
}
