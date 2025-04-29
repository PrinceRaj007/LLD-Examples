package com.example.splitwise.models;

import java.util.List;
import java.util.Map;

public class Expense {
	double amount;
	String payer; // who Paid the bill
	SplitStrategy splitStrategy;
	Map<String, Double> splitShare;
	List<String> users;
	public Expense(double amount, String payer,  List<String> users, Map<String,Double > customShare, SplitStrategy splitStrategy) {
		super();
		this.amount = amount;
		this.payer = payer;
		this.splitStrategy = splitStrategy;
		this.users = users;
		this.splitShare = splitStrategy.calculateSplit(payer, users, amount, customShare);
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public Map<String, Double> getSplitShare() {
		return splitShare;
	}
	public void setSplitShare(Map<String, Double> splitShare) {
		this.splitShare = splitShare;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
}
