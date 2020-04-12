package com.position.positionSquareService.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.model.Client;
import com.position.positionSquareService.model.User;
import com.position.positionSquareService.repository.ClientRepository;
import com.position.positionSquareService.utils.GenerateEncryptionPassword;
import com.position.positionSquareService.utils.Util;

@Service
public class RegisterService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Value("${keyGen.key}")
	private String genKey ;
	
	@Transactional
	public ResponseEntity<Client> registerClient(@Valid Client client) {
		ResponseEntity<Client> response = new ResponseEntity<>();
		response.setStatusCode(500);
		//create bare minimal validations 
		String val = Util.validations(client); 
		if(val !=null) {
			response.setErrorResponse(val);
		}else if(client.getUsers() ==null || client.getUsers().size()==0) {
			response.setErrorResponse("Atleast one user is required for client registration");
		}
		else {
			try {
				Client clientRec =  clientRepository.getClientBypan(client.getPan());
				if(null== clientRec) {
					// lets create the Client because client does not exists 
					Set<User> newUsers = new HashSet<User>();
					for(User user : client.getUsers()) {
						String valli = Util.validations(user); 
						if(valli !=null) {
							response.setErrorResponse(valli);
							return  response;
						}else {
							String pas = GenerateEncryptionPassword.genPass(genKey, user.getPassword());
							user.setPassword(pas);
						}
						newUsers.add(user);
					}
					client.setUsers(newUsers);
					clientRepository.save(client);
					response.setResponse(client);
					response.setStatusCode(200);
				}else {
					response.setErrorResponse("Already exists");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setErrorResponse("Error in registering client !! please try again ");
			}
		}
		return response;
	}

}
