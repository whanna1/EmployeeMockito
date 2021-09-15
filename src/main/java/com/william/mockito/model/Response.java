package com.william.mockito.model;

import javax.persistence.Entity;
import javax.persistence.Id;



public class Response {

	
	private String message;
	private boolean status;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(String string1, boolean true1) {
		// TODO Auto-generated constructor stub
		message = string1;
		status  = true1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
