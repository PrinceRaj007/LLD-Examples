package com.example.cabbooking.models;

public class Location {
	double x;
	double y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	public double caculateDistance(Location location) {
		return Math.sqrt(Math.pow(x-location.getX(), 2)+Math.pow(y-location.getY(), 2));
	}
	
}
