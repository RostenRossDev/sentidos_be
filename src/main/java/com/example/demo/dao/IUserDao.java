package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;


@Repository
public interface IUserDao extends CrudRepository<User, Long>{

	public User findByUsername(String username); 
	
	public Optional<User> findById(Long id); 
	
	
}
