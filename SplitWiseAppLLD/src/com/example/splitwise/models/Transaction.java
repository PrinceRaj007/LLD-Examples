package com.example.splitwise.models;

public class Transaction {
	String from; // person who will send money
	String to; // person who will receive money
	Double amount;
	public Transaction(String from, String to, Double amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "\tTransaction : \"" + from + "\" pays to \"" + to + "\" , amount = " + amount + "";
	}
	
	
}
