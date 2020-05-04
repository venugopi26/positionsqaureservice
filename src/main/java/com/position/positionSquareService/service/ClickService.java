package com.position.positionSquareService.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.model.GoogleClicks;
import com.position.positionSquareService.repository.ClickRepository;

@Service
public class ClickService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClickService.class);
	
	@Autowired
	ClickRepository clickRepository;
	
	/**
	 * 
	 * @param googleClicks
	 * @return
	 */
	@Transactional
	public ResponseEntity<GoogleClicks> addKeywords(@Valid GoogleClicks googleClicks) {
		ResponseEntity<GoogleClicks> response = new ResponseEntity<GoogleClicks>();
		response.setStatusCode(500);
		try {			
			if (null != googleClicks) {				
				clickRepository.save(googleClicks);
				response.setResponse(googleClicks);
				response.setStatusCode(200);
			} else {
				response.setErrorResponse("Error while Insert.");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			response.setErrorResponse("Error while Insert.");
		}
		return response;
	}
}
