/**
 * 
 */
package com.position.positionSquareService.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.dto.UserDto;
import com.position.positionSquareService.model.Client;
import com.position.positionSquareService.model.User;
import com.position.positionSquareService.repository.ClientRepository;
import com.position.positionSquareService.repository.UserRepository;
import com.position.positionSquareService.utils.GenerateEncryptionPassword;
import com.position.positionSquareService.utils.Util;

/**
 * @author anush
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Value("${keyGen.key}")
	private String genKey ;

	
	
	@Transactional
	public ResponseEntity<User> createUser(@Valid User user , int clientId) {
		ResponseEntity<User> response = new ResponseEntity<>();
		response.setStatusCode(500);
		//create bare minimal validations 
		String val = Util.validations(user); 
		if(val !=null) {
			response.setErrorResponse(val);
		}
		else {
			try {
//				User userRec =  userRepository.getuserByEmailId(user.getEmailId());
				User userRec =  userRepository.getuserByMobileNumber(user.getMobileNumber());
				if(null== userRec) {
					// lets create the user because user does not exists 
					//generate the encrypt pass with key 
					String pas = GenerateEncryptionPassword.genPass(genKey, user.getPassword());
					user.setPassword(pas);
					user.setClientId(clientId);
					userRepository.save(user);
					response.setResponse(user);
					response.setStatusCode(200);
				}else {
					response.setErrorResponse("Already exists please login");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setErrorResponse("Error in registering user !! please try again ");
			}
		}
		return response;
	}


	@Transactional
	public ResponseEntity<User> login(@Valid UserDto user) {
		ResponseEntity<User> response = new ResponseEntity<>();
		response.setStatusCode(500);
		//create bare minimal validations 
		String val = Util.loginValidations(user); 
		if(val !=null) {
			response.setErrorResponse(val);
		}
		else {
			try {
				User userRec =  userRepository.validateUser(user.getMobileNumber(),GenerateEncryptionPassword.genPass(genKey, user.getPassword()));
				if(null!=userRec) {
					// dont send back the password 
					userRec.setPassword(null);
					response.setResponse(userRec);
					response.setStatusCode(200);
				}else {
					response.setErrorResponse("User does not exits / Password not correct");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setErrorResponse("Error in login!! please try again ");
			}
		}
		return response;
	}

}
