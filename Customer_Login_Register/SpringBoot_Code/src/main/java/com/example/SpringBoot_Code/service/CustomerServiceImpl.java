package com.example.SpringBoot_Code.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.SpringBoot_Code.bean.Customer;
import com.example.SpringBoot_Code.bean.CustomerDTO;
import com.example.SpringBoot_Code.bean.LoginDTO;
import com.example.SpringBoot_Code.config.LoginMesage;
import com.example.SpringBoot_Code.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private CustomerDAO customerDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
	SequnceGeneratorService ser;
    public LoginMesage registerCustomer(CustomerDTO customerDTO) {
        String username= customerDTO.getUsername();
        String mail = customerDTO.getEmail();
   	 if(checkUserExists(username, mail)){
   		 return new LoginMesage("User exists", false);
   	 }
   	 else if(checkUsernameExists(username)) {
   		 return new LoginMesage("Username already exists", false);
   	 }
   	 else if(checkEmailExists(mail)) {
   		 return new LoginMesage("Email already exists", false);
   	 }
   	 else {
   		 return new LoginMesage("Register Success", true);
   	 }
   }
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
    	customerDTO.setCustid(ser.getSequenceNumber(Customer.SEQUNCE_NAME));
        Customer customer = new Customer();
        		customer.setCustid(customerDTO.getCustid());
               customer.setFirstName(customerDTO.getFirstName());
               customer.setLastName(customerDTO.getLastName());
               customer.setEmail(customerDTO.getEmail());
                customer.setPhone(customerDTO.getPhone());
               customer.setUsername(customerDTO.getUsername());
               customer.setPassword(this.passwordEncoder.encode(customerDTO.getPassword()));
      
        customerDao.save(customer);
        return customer.getFirstName();
    }
    CustomerDTO customerDTO;
    @Override
    public LoginMesage  loginCustomer(LoginDTO loginDTO) {
        if(loginDTO!=null){
        Customer customer1 = customerDao.findByUsername(loginDTO.getUsername());
        if (customer1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = customer1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Customer> customer = customerDao.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (customer.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("Invalid Password", false);
            }
        }else {
            return new LoginMesage("Invalid Username", false);
        }
        }
        else {
        	return new LoginMesage("Login Failed", false);
        }
}
public Customer findByUsername(String username) {
    	
        return customerDao.findByUsername(username);
        
    }

    public Customer findByEmail(String email) {
    	
        return customerDao.findByEmail(email);
    }
 public boolean checkUserExists(String username, String email) {
    	
        return checkUsernameExists(username) && checkEmailExists(email);
        
    }

    public boolean checkUsernameExists(String username) {
    	
        return null != findByUsername(username);
        
    }

    public boolean checkEmailExists(String email) {
    	
        return null != findByEmail(email);
        

    }
}
