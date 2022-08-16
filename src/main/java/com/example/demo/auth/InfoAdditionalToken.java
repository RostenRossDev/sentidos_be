package com.example.demo.auth;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.services.IUsuarioService;


@Component
public class InfoAdditionalToken implements TokenEnhancer{

	@Autowired
	private IUsuarioService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		User user = userService.findByUsername(authentication.getName());
		HashMap<String, Object> info = new HashMap<>();
		info.put("username", user.getUsername());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
