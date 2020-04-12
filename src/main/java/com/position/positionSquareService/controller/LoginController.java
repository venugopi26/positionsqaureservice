/**
 * 
 */
package com.position.positionSquareService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.dto.UserDto;
import com.position.positionSquareService.model.Client;
import com.position.positionSquareService.model.User;
import com.position.positionSquareService.service.RegisterService;
import com.position.positionSquareService.service.UserService;

/**
 * @author anush
 *
 */
@RestController
@RequestMapping("/loginservice")
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	RegisterService registerService;
	
	 
	@PostMapping("/register")
	  public  ResponseEntity<Client> register(@Valid @RequestBody Client client) {
	    return registerService.registerClient(client);
	  }

	 @PostMapping("/login")
	  public ResponseEntity<User> login(@Valid @RequestBody UserDto user) {
	    return userService.login(user);
	  }

	 
}
