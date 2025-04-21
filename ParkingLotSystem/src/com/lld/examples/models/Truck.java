package com.lld.examples.models;

public class Truck extends Vehicle {

	public Truck(String regNumber) {
		super(regNumber);
	}
	public VehicleType getType(){
		return VehicleType.TRUCK;
	}
}
