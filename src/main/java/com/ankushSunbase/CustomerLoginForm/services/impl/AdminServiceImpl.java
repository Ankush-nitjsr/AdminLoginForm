package com.ankushSunbase.CustomerLoginForm.services.impl;

import com.ankushSunbase.CustomerLoginForm.model.Admin;
import com.ankushSunbase.CustomerLoginForm.repository.AdminRepository;
import com.ankushSunbase.CustomerLoginForm.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public ResponseEntity<String> userAuthentication (Admin admin) {
        adminRepository.save(admin);
        return new ResponseEntity<>("Authentication done successfully", HttpStatus.OK);
    }
}
