package com.example.cabbooking.exceptions;

public class CabNotFoundException extends RuntimeException {
	public CabNotFoundException(String msg){
		super(msg);
	}
}
