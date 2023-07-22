package com.example.SpringBoot_Code.service;

import com.example.SpringBoot_Code.bean.CustomerDTO;
import com.example.SpringBoot_Code.bean.LoginDTO;
import com.example.SpringBoot_Code.config.LoginMesage;


public interface CustomerService {
	
	    String addCustomer(CustomerDTO customerDTO);
	    LoginMesage loginCustomer(LoginDTO loginDTO);
	

}

