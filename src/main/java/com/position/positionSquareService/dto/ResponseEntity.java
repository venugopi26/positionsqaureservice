/**
 * 
 */
package com.position.positionSquareService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author venu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEntity<T>  {

	private int statusCode = -1;
	private T response;
	private String errorResponse;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public String getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
	
}

