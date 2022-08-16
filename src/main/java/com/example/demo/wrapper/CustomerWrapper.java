package com.example.demo.wrapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.Customer;

public class CustomerWrapper {
	
	public static Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setLastname(customerDto.getLastname());
		return customer;
	}
	public static CustomerDto entityToDto(Customer customer) {
		CustomerDto custoemrDto = new CustomerDto();
		custoemrDto.setName(customer.getName());
		custoemrDto.setLastname(customer.getLastname());
		custoemrDto.setUsername(customer.getUser().getUsername());
		return custoemrDto;
	}
}
