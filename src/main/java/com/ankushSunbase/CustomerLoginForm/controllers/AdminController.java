package com.ankushSunbase.CustomerLoginForm.controllers;

import com.ankushSunbase.CustomerLoginForm.model.Admin;
import com.ankushSunbase.CustomerLoginForm.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp")
    public ResponseEntity<String> UserAuthentication (@RequestBody Admin admin) {
        return adminService.userAuthentication(admin);
    }

}
