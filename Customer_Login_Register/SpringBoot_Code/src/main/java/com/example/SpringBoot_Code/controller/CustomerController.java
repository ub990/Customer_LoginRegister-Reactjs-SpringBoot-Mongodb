package com.example.SpringBoot_Code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Code.bean.CustomerDTO;
import com.example.SpringBoot_Code.bean.LoginDTO;
import com.example.SpringBoot_Code.config.LoginMesage;
import com.example.SpringBoot_Code.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        String id = customerService.addCustomer(customerDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO)
    {
    
        LoginMesage loginResponse = customerService.loginCustomer(loginDTO);
        return ResponseEntity.ok(loginResponse);
    	
    }
}
