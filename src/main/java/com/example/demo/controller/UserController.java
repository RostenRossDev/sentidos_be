package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.services.CostumerServiceImpl;
import com.example.demo.services.UserService;
import com.example.demo.wrapper.UserWrapper;


//@CrossOrigin({"https://cyan-doors-clap-190-183-177-173.loca.lt"})
@RestController
@RequestMapping("/api/v1/user/")
 public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;	
	
	@Autowired
	private CostumerServiceImpl customerService;
	
	@Autowired
	private CostumerServiceImpl costumerService;
	

	private Object getPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) { 
			return auth.getPrincipal();
		
		}
		return null;
	}
	
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
	public ResponseEntity<HashMap<String, Object>> getUserData(@RequestParam("username") String username){	
		HashMap<String, Object> response = new HashMap<>();
		User user = userService.findByUsername(username);
		Customer customer = customerService.findByUser(user);
		response.put("name", customer.getName());
		response.put("lastname", customer.getLastname());
		response.put("email", customer.getEmail());
		response.put("photo", customer.getPotho());
		log.info(customer.getEmail());
		log.info(customer.getPotho());
		log.info(customer.getLastname());
		log.info(customer.getName());
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/uploads")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file , @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap();
		User userDetails = null;
		
		Customer customer=costumerService.findById(id);
		if(!file.isEmpty()) {
			String fileName =UUID.randomUUID().toString() +"_"+ file.getOriginalFilename().replace(" ", "");
			Path pathFile = Paths.get("uploads").resolve(fileName).toAbsolutePath();
			
			try {
				Files.copy(file.getInputStream(), pathFile);
			} catch (Exception e) {
				// TODO: handle exception
				return  new ResponseEntity<HashMap<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String lastPhotoName = customer.getPotho();
			if(lastPhotoName != null && lastPhotoName.length()>0) {
				
				Path lastPhotoPath = Paths.get("uploads").resolve(lastPhotoName).toAbsolutePath();
				File lastPhotoFile = lastPhotoPath.toFile();
				
				if(lastPhotoFile.exists() && lastPhotoFile.canRead()) lastPhotoFile.delete();
			}
			
			customer.setPotho(fileName);
			customerService.save(customer);
			
			response.put("customer", customer);
			response.put("message", "Se subio la imagen correctamente");
			response.put("name", fileName);
		}
		
		return  new ResponseEntity<HashMap<String,Object>>(HttpStatus.OK);
	}
	
	
	@GetMapping("/uploads/img/{name:.+}")
	public ResponseEntity<Resource> getPhoto(@PathVariable String name){
		Path pathFile = Paths.get("uploads").resolve(name).toAbsolutePath();
		Resource resousrce=null;
		
		try {
			resousrce =new UrlResource(pathFile.toUri());

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!resousrce.exists() && !resousrce.isReadable()) {
			throw new RuntimeException("No se pudo cargar la foto: "+name);
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resousrce.getFilename()+"\"" );
		
		return new ResponseEntity<Resource>(resousrce, header,HttpStatus.OK);
	}
}
