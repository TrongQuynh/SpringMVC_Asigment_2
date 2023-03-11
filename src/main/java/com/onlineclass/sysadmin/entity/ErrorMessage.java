package com.onlineclass.sysadmin.entity;

public class ErrorMessage {
	private int statusCode;
	private String message;
	private int errorCode;
	
	public ErrorMessage(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public ErrorMessage(int statusCode,int errorCode) {
		this.statusCode = statusCode;
		this.statusCode = statusCode;
	}
	
	public ErrorMessage(int statusCode,int errorCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}



	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}



	public String getMessage() {
		return message;
	}



	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
}
