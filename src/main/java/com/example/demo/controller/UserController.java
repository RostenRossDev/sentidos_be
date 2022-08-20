package com.example.demo.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.wrapper.UserWrapper;

//@CrossOrigin({"https://cyan-doors-clap-190-183-177-173.loca.lt"})
@RestController
@RequestMapping("/api/v1/user/")
 public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;	
	
	//@PostMapping(value= "", produces = {MediaType.APPLICATION_JSON_VALUE})
	@PostMapping(value="", consumes = {"application/json"})
	public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody UserDto userDto){	
		
		HashMap<String, Object> response = new HashMap<>();
		User user = userService.findByUsername(userDto.getUsername());
		
		if(user != null) {
			response.put("error", "No puedes usar ese username");
			return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
		}
		
		
		User newUser = UserWrapper.dtoToEntity(userDto);	
		Customer customer = new Customer();		
		customer.setName(userDto.getName());
		customer.setLastname(userDto.getLastname());
		customer.setUser(newUser);
		newUser.setCustomer(customer);	
		
		if( userService.save(newUser) == null) {
			response.put("error", "Error al crear usuario, intente nuevamente mas tarde");
			return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("user", userDto);
		response.put("message", "Usuario creado con eixto");
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("")
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public ResponseEntity<HashMap<String, Object>> getUserData(){	
		HashMap<String, Object> response = new HashMap<>();
		response.put("name", "Nestor");
		response.put("lastname", "Costantini");
		response.put("email", "costantini.nestor.m@gmail.com");
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
}
