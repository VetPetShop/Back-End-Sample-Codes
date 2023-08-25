package com.app.custom_excceptions;


public class UserAlreadyExitsException extends RuntimeException {
	public UserAlreadyExitsException(String mesg) {
		super(mesg);
	}
	
}
