/**
 * 
 */
package com.position.positionSquareService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.mapper.RoleMapper;
import com.position.positionSquareService.mapper.UserMapper;

/**
 * @author anush
 *
 */
@RestController
@RequestMapping("/clientservice")
public class UserController {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleMapper roleMapper;
	
	
	@GetMapping("/users")
	 public  ResponseEntity<List<Map<Object, Object>>> getUsers(@RequestHeader(value="clientId") int clientId  ) {
		ResponseEntity<List<Map<Object, Object>>> response = new ResponseEntity<List<Map<Object, Object>>>();
		response.setResponse(userMapper.getUsers(clientId));
		response.setStatusCode(200);
		return response;
	  }
	
	@GetMapping("/getRoles")
	 public  ResponseEntity<List<Map<Object, Object>>> getRoles(@RequestHeader(value="clientId") int clientId  ) {
		ResponseEntity<List<Map<Object, Object>>> response = new ResponseEntity<List<Map<Object, Object>>>();
		response.setResponse(roleMapper.getRoleMaster());
		response.setStatusCode(200);
		return response;
	  }
	
	
	 
}
