package com.ankushSunbase.CustomerLoginForm.controllers;

import com.ankushSunbase.CustomerLoginForm.model.Admin;
import com.ankushSunbase.CustomerLoginForm.model.Customer;
import com.ankushSunbase.CustomerLoginForm.services.AdminService;
import com.ankushSunbase.CustomerLoginForm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/create")
    public ResponseEntity<String> create (@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping("/get_customer_list")
    public ResponseEntity<List<Customer>> get_customer_list (){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID uuid) {
        return customerService.delete(uuid);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestParam UUID uuid, @RequestBody Customer customer){
        return customerService.update(uuid, customer);
    }
}
