package com.examples.booking.models;

public class Seat {
	int seatNumber;
	SeatStatus status;
	public Seat(int seatNumber, SeatStatus status) {
		super();
		this.seatNumber = seatNumber;
		this.status = status;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + ", status=" + status + "]";
	}
	
}
