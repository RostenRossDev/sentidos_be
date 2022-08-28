package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.RestaurantTable;


@Repository
public interface ITable extends CrudRepository<RestaurantTable, Long>{

	public RestaurantTable findByNumber(Integer number);
}
