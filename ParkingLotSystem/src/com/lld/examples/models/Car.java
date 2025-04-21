package com.lld.examples.models;

public class Car extends Vehicle {

	public Car(String regNumber) {
		super(regNumber);
	}
	public VehicleType getType(){
		return VehicleType.CAR;
	}
}
