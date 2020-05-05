package com.position.positionSquareService.dto;

public class ResponseStatus {
	
	private int statusCode = 200;
	
	private String response = "success";

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
