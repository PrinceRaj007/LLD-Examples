package com.lld.examples.models;

public class Bike extends Vehicle {

	public Bike(String regNumber) {
		super(regNumber);
	}
	public VehicleType getType(){
		return VehicleType.BIKE;
	}
}
