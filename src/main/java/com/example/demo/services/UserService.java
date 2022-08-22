package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IUserDao;
import com.example.demo.entities.User;



@Service
public class UserService implements UserDetailsService, IUsuarioService{

	private Logger log =LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null ){ 
			log.error("Error en el login: no existe el usuario.");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario.");
		}
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(r -> new SimpleGrantedAuthority(r.getRolName()))
				.peek(authority -> log.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	public List<User>findAll(){
		return (List<User>)userDao.findAll();
	}
	
	
}
