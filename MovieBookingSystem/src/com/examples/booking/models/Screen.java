package com.examples.booking.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	String id;
	String name;
	List<Seat> seats = new ArrayList<>();
	public Screen(String id, String name, List<Seat> seats) {
		super();
		this.id = id;
		this.name = name;
		this.seats = seats;
	}
	public Screen(String id, String name, int size) {
		super();
		this.id = id;
		this.name = name;
		for(int i=0;i<size;i++) {
			seats.add(new Seat(i+1, SeatStatus.AVAILABLE));
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Screen [name=" + name + "]";
	}
	
	
}
