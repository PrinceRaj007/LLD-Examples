package com.example.cabbooking.models;

public class Trip {
	
	Cab cab;
	Rider rider;
	Location source;
	Location destination;
	Status status;
	double price;
	
	public Trip(Cab cab, Rider rider, Location source, Location destination, Status status, double price) {
		this.cab = cab;
		this.rider = rider;
		this.source = source;
		this.destination = destination;
		this.status = status;
		this.price = price;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Location getSource() {
		return source;
	}
	public void setSource(Location source) {
		this.source = source;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
