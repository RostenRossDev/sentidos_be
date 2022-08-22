package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICustomerDao;
import com.example.demo.entities.Customer;
import com.example.demo.entities.User;


@Service
public class CostumerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	public List<Customer> findAll(){
		return (List<Customer>) customerDao.findAll();
	}
	
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(new Customer());
	}
	
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}
	
	public Customer findByUser(User user) {
		return customerDao.findByUser(user).get(0);
	}
}
