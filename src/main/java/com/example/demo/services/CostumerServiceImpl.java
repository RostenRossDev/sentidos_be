package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICustomerDao;
import com.example.demo.entities.Customer;


@Service
public class CostumerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	public List<Customer> findAll(){
		return (List<Customer>) customerDao.findAll();
	}
}
