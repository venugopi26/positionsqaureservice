package com.position.positionSquareService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.model.GoogleClicks;
import com.position.positionSquareService.service.ClickService;


@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class PositionSquareServiceApplicationTests {

	@Value("${test}")
	public String test;		
	
	@Autowired
	ClickService clickservice;
	
	@Test
	public void contextLoads() {
		System.out.println(test);		
	}
	
	/**
	 * Test storing clicks
	 */
	@Test
	public void postClick() {
		ResponseEntity<GoogleClicks> response = clickservice.addKeywords(click());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(), 200);
	}
	
	public GoogleClicks click() {
		GoogleClicks gc = new GoogleClicks();
		gc.setClickId("C1");
		gc.setKeywordId("K1");
		gc.setCampaignId("Ca1");
		return gc;
	}
	
}
