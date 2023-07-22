package com.example.SpringBoot_Code.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringBoot_Code.bean.Customer;

public interface CustomerDAO extends MongoRepository<Customer,Integer>{
	Optional<Customer> findOneByUsernameAndPassword(String username, String password);
    Customer findByUsername(String username);

}
