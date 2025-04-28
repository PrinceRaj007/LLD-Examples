package com.examples.booking.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserSession {
	ScheduledExecutorService timeoutScheduler = Executors.newSingleThreadScheduledExecutor();
	User user;
	Show show;
	long timeoutDuration; // In seconds
	BookingManager bookingManager;
	List<Seat> selectedSeats = new ArrayList<>();

	public UserSession(User user, Show show, long timeoutDuration, BookingManager bookingManager) {
		this.user = user;
		this.show = show;
		this.timeoutDuration = timeoutDuration;
		this.bookingManager = bookingManager;
		timeoutScheduler.schedule(this::timeout, timeoutDuration, TimeUnit.SECONDS);
	}

	public void selectSeats(List<Integer> seatNumbers) {
		bookingManager.selectSeats(show, seatNumbers, user, selectedSeats);
	}

	public void makePayment() {
		bookingManager.processPayment(user, show, selectedSeats, this);
	}

	public void getAvailableSeats() {
		System.out.println(bookingManager.getAvailableSeats(show));
	}

	public synchronized void closeSession() {
		bookingManager.releaseSeats(selectedSeats);
		timeoutScheduler.shutdown();
		System.out.println("\t"+user.getName() + " Session CLOSED !!");
	}

	private synchronized void timeout() {
		System.out.println("\t"+user.getName() + " Session Timed OUT !!");
		closeSession();
	}
}
