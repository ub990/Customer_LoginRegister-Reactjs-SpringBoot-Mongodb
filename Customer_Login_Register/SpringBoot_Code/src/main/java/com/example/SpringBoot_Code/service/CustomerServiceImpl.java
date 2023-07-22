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
        String msg = "";
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
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Username not exits", false);
        }
        }
        else {
        	return new LoginMesage("Login Failed", false);
        }
}
}
