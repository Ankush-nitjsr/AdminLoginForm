package com.ankushSunbase.CustomerLoginForm.services.impl;

import com.ankushSunbase.CustomerLoginForm.model.Customer;
import com.ankushSunbase.CustomerLoginForm.repository.CustomerRepository;
import com.ankushSunbase.CustomerLoginForm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ResponseEntity<String> create(Customer customer){
        if (customer.getFirst_name() == null || customer.getLast_name() == null) {
            return new ResponseEntity<>("First Name or Last Name is missing", HttpStatus.BAD_REQUEST);
        } else {
            Customer customer1 = customerRepository.save(customer);
            return new ResponseEntity<>("Successfully Created with UUID: " + customer.getUuid(),HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> listOfCustomers = customerRepository.findAll();
        return new ResponseEntity<>(listOfCustomers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(UUID uuid) {
        try {
            Optional<Customer> customer = customerRepository.findById(uuid);
            if (customer.isPresent()) {
                customerRepository.deleteById(uuid);
                return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("UUID not found", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> update(UUID uuid, Customer newCustomer) {
        try {
            Optional<Customer> exitingCustomer = customerRepository.findById(uuid);
            if (exitingCustomer.isPresent()){
                Customer customer = exitingCustomer.get();
                customer.setFirst_name(newCustomer.getFirst_name());
                customer.setLast_name(newCustomer.getLast_name());
                customer.setAddress(newCustomer.getAddress());
                customer.setCity(newCustomer.getCity());
                customer.setState(newCustomer.getState());
                customer.setEmail(newCustomer.getEmail());
                customer.setPhone(newCustomer.getPhone());
                customer.setStreet(newCustomer.getStreet());
                customerRepository.save(customer);
                return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Body is Empty", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("UUID not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
