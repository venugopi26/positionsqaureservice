/**
 * 
 */
package com.position.positionSquareService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.position.positionSquareService.dto.ResponseStatus;

/**
 * @author venu
 *
 */

@RestController
public class DefaultController {

	@GetMapping("/health")
	public ResponseStatus addTaskDependencies() {
		ResponseStatus rs = new ResponseStatus();
		return rs;		
	}
}
