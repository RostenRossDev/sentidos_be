package com.example.demo.wrapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;

public class UserWrapper {
	public static BCryptPasswordEncoder passwordEncoder = SpringSecurityConfig.passwordEncoder();

	public static User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode( userDto.getPassword()));
		user.setEnabled(Boolean.TRUE);
		return user;
	}
	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEnabled(user.getEnabled());
		return userDto;
	}
}
