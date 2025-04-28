package com.examples.booking.models;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingManager {
	Lock lock = new ReentrantLock();
	PaymentManager paymentManager = new PaymentManager();
	int maxRetry = 3;

	public void selectSeats(Show show, List<Integer> seatNumbers, User user, List<Seat> selectedSeat) {
		try {
			lock.lock();
			List<Integer> availableSeatNumbers = show.getSeats().stream()
					.filter(s -> s.getStatus() == SeatStatus.AVAILABLE).map(s -> s.getSeatNumber()).toList();
			if (!availableSeatNumbers.containsAll(seatNumbers)) {
				throw new SeatNotAvailableException();
			}
			for (Seat seat : show.getSeats()) {
				if (seatNumbers.contains(seat.getSeatNumber())) {
					seat.setStatus(SeatStatus.TEMP_UNAVAILABLE);
					selectedSeat.add(seat);
				}
			}
		} finally {
			lock.unlock();
		}

	}

	public void processPayment(User user, Show show, List<Seat> selectedSeats, UserSession userSession) {
		Boolean paymentStatus = paymentManager.makePayment();
		if (paymentStatus) {
			System.out.println("Payment SUCCESSFULL !! Confirming Booking");
			finalizeBooking(user, show, selectedSeats, userSession);
		} else {
			System.out.println("Payment FAILED !! Retrying ... ");
			for (int i = 0; i < maxRetry; i++) {
				if (paymentManager.makePayment()) {
					System.out.println("Payment SUCCESSFULL in Retry " +(i+1) + " !! Confirming Booking");
					finalizeBooking(user, show, selectedSeats, userSession);
					return;
				} else {
					System.out.println("Payment FAILED !! Retrying ... " + (i + 1));
				}
			}
			releaseSeats(selectedSeats);
			userSession.closeSession();
		}
	}

	private void finalizeBooking(User user, Show show, List<Seat> selectedSeats, UserSession userSession) {
		try {
			lock.lock();
			for (Seat seat : selectedSeats) {
				seat.setStatus(SeatStatus.PERM_UNAVAILABLE);
			}
			System.out.println("Ticket BOOKED !!");
		} finally {
			lock.unlock();
		}
		Ticket ticket = new Ticket(user, selectedSeats, show);
		ticket.printTicket();
		userSession.closeSession();
	}

	public void releaseSeats(List<Seat> selectedSeats) {
		try {
			lock.lock();
			for (Seat seat : selectedSeats) {
				if (seat.getStatus() == SeatStatus.TEMP_UNAVAILABLE) {
					seat.setStatus(SeatStatus.AVAILABLE);
				}
			}
		} finally {
			lock.unlock();
		}
	}

	public List<Seat> getAvailableSeats(Show show) {
		return show.getSeats().stream().filter(s -> s.getStatus() == SeatStatus.AVAILABLE).toList();
	}
}
