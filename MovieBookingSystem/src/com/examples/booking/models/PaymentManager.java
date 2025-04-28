package com.examples.booking.models;

public class PaymentManager {
	public boolean makePayment() {
		return Math.random()*10<=7?true:false;
	}
}
