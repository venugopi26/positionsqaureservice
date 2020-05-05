package com.position.positionSquareService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.dto.ResponseStatus;
import com.position.positionSquareService.model.GoogleClicks;
import com.position.positionSquareService.service.ClickService;

@RestController
@RequestMapping("/process")
public class CommandController {
	
	@Autowired
	ClickService clickService;
	
	@Autowired private Environment env;
		
	/**
	 * 
	 * @param googleClicks Save ClickId,KeywordId and CampaignId
	 * @return
	 */
	@PostMapping("/post-ads")
	public ResponseEntity<GoogleClicks> postGoogleAds(@Valid @RequestBody GoogleClicks googleClicks) {
		return clickService.addKeywords(googleClicks);
	}
	
	@GetMapping("/health")
	public ResponseStatus addTaskDependencies() {
		ResponseStatus rs = new ResponseStatus();
		String port = env.getProperty("server.port");
		rs.setResponse(port);
		return rs;		
	}
}
