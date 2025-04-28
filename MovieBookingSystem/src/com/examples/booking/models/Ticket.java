package com.examples.booking.models;

import java.util.List;

public class Ticket {
	User user;
	List<Seat> seats;
	Show show;

	public Ticket(User user, List<Seat> seats, Show show) {
		super();
		this.user = user;
		this.seats = seats;
		this.show = show;
	}

	public void printTicket() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		List<Integer> bookedSeats = seats.stream().map(s -> s.getSeatNumber()).toList();
		return "Ticket [user = " + user.getName() + ", seats = " + bookedSeats + ", show = " + show + "]";
	}

}
