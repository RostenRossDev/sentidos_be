package com.example.demo.services;

import com.example.demo.entities.User;

public interface IUsuarioService {
	public User findByUsername(String username);
	
	public User save(User user);
}
