package com.example.cabbooking.models;

public class Cab {
	String id;
	String driver;
	Location currLocation;
	Trip currTrip;
	boolean isAvailable;
	public Cab(String id, String driver, Location currLocation) {
		this.id = id;
		this.driver = driver;
		this.currLocation = currLocation;
		isAvailable = true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Location getCurrLocation() {
		return currLocation;
	}
	public void setCurrLocation(Location currLocation) {
		this.currLocation = currLocation;
	}
	public Trip getCurrTrip() {
		return currTrip;
	}
	public void setCurrTrip(Trip currTrip) {
		this.currTrip = currTrip;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
