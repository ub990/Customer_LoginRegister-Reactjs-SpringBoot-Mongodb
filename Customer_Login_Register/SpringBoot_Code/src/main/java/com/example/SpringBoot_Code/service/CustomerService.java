package com.example.SpringBoot_Code.service;


import com.example.SpringBoot_Code.bean.CustomerDTO;
import com.example.SpringBoot_Code.bean.LoginDTO;
import com.example.SpringBoot_Code.config.LoginMesage;


public interface CustomerService {
	
	    String addCustomer(CustomerDTO customerDTO);
	    LoginMesage registerCustomer(CustomerDTO customerDTO);
	    LoginMesage loginCustomer(LoginDTO loginDTO);
	
	    boolean checkUserExists(String username, String email);

	    boolean checkUsernameExists(String username);

	    boolean checkEmailExists(String email);

}

