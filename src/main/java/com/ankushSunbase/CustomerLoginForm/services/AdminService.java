package com.ankushSunbase.CustomerLoginForm.services;

import com.ankushSunbase.CustomerLoginForm.model.Admin;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<String> userAuthentication(Admin admin);
}
