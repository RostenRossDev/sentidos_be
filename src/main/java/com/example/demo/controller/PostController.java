package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.services.CostumerServiceImpl;
import com.example.demo.services.PostServiceImpl;
import com.example.demo.services.UserService;
import com.example.demo.wrapper.CustomerWrapper;
import com.example.demo.wrapper.PostWraper;
import com.example.demo.wrapper.UserWrapper;


//@CrossOrigin({"https://cyan-doors-clap-190-183-177-173.loca.lt"})
@RestController
@RequestMapping("/api/v1/post/")
public class PostController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private CostumerServiceImpl costumerService;
	
	@Autowired
	private PostServiceImpl postService;
	
	@GetMapping(value= "",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<HashMap<String, Object>> allPost(){
		HashMap<String, Object> response = new HashMap<>();
		List<PostDto> postDtos =new ArrayList<PostDto>();
		postService.findAll().stream().forEach(post ->{
			postDtos.add(PostWraper.entityToDto(post));
		});;
		response.put("posts", postDtos);
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> savePost( Post post, User user){
		HashMap<String, Object> response = new HashMap<>();

		response.put("post", response);
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	@Secured({"ROLE_USER"})
	@GetMapping("tables")
	public ResponseEntity<HashMap<String, Object>> allTables(){
		HashMap<String, Object> response = new HashMap<>();
		List<PostDto> postDtos = new ArrayList<PostDto>();
		postService.findAll().stream().forEach(post -> {
			postDtos.add(PostWraper.entityToDto(post));
		});
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		userService.findAll().stream().forEach(post ->{
			userDtos.add(UserWrapper.entityToDto(post));
		});
		
		List<CustomerDto> custoemrDtos = new ArrayList<CustomerDto>();
		costumerService.findAll().stream().forEach(post -> {
			custoemrDtos.add(CustomerWrapper.entityToDto(post));
		});

		response.put("posts", postDtos);
		response.put("userDtos", userDtos);
		response.put("custoemrDtos", custoemrDtos);

		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
}
