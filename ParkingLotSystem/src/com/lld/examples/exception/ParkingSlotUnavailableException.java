package com.lld.examples.exception;

public class ParkingSlotUnavailableException  extends RuntimeException {
	public ParkingSlotUnavailableException(String msg){
		super(msg);
	}
}
