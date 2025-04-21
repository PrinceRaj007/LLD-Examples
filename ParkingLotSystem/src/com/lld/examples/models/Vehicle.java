package com.lld.examples.models;

public abstract class Vehicle {
	String regNumber;

	public Vehicle(String regNumber) {
		super();
		this.regNumber = regNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	abstract public VehicleType getType();

	@Override
	public String toString() {
		return "Vehicle [regNumber=" + regNumber + ", Type=" + getType() + "]";
	}
	
}
