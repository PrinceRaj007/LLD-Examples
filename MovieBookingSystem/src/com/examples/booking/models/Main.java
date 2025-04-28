package com.examples.booking.models;

import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Screen screen1 = new Screen("1", "Screen1", 10);
		Show show1 = new Show("1", new Movie("1", "Avengers"), new Date(), screen1);
		BookingManager bookingmanager1 = new BookingManager();
		UserSession session1 = new UserSession(new User("Prince Raj"), show1, 5, bookingmanager1);
		session1.getAvailableSeats();
		session1.selectSeats(Arrays.asList(1,2));
		session1.makePayment();
		session1.getAvailableSeats();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserSession session2 = new UserSession(new User("Rakesh"), show1, 5, bookingmanager1);
		session2.getAvailableSeats();
	}

}
