package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;
import com.example.demo.entities.User;



@Repository
public interface ICustomerDao  extends CrudRepository<Customer, Long>{
	
	List<Customer> findByUser(User user);
}
