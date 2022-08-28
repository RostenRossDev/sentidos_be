package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITable;
import com.example.demo.entities.RestaurantTable;


@Service
public class TableServiceImpl {
	
	@Autowired
	private ITable tableDao;
	
	public RestaurantTable findByNumber(Integer number) {
		return tableDao.findByNumber(number);
	}	

}
