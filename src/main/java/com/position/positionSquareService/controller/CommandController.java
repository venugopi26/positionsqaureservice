package com.position.positionSquareService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
		
	/**
	 * 
	 * @param googleClicks Save ClickId,KeywordId and CampaignId
	 * @return
	 */
	@PostMapping("/post-ads")
	public ResponseEntity<GoogleClicks> postGoogleAds(@Valid @RequestBody GoogleClicks googleClicks) {
		return clickService.addKeywords(googleClicks);
	}
	
	@PostMapping("/health")
	public ResponseStatus addTaskDependencies() {
		ResponseStatus rs = new ResponseStatus();
		return rs;		
	}
}
