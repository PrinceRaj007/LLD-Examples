package com.example.cabbooking.exceptions;

public class TripNotFoundException extends RuntimeException {
	public TripNotFoundException(String msg){
		super(msg);
	}
}
