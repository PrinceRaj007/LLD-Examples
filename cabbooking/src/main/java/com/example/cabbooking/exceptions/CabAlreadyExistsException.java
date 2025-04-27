package com.example.cabbooking.exceptions;

public class CabAlreadyExistsException extends RuntimeException {
	public CabAlreadyExistsException(String msg){
		super(msg);
	}
}
