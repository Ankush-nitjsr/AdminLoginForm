package com.ankushSunbase.CustomerLoginForm.services;

import com.ankushSunbase.CustomerLoginForm.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    public ResponseEntity<String> create(Customer customer);

    public ResponseEntity<List<Customer>> getAllCustomers();

    public ResponseEntity<String> delete(UUID uuid);

    public ResponseEntity<String> update(UUID uuid, Customer customer);
}
