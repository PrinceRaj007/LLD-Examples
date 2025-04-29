package com.example.splitwise.models;

import java.util.List;

public class Group {
	String id;
	String name;
	List<String> users;
	List<Expense> expenses;
	
	public Group(String id, String name, List<String> users, List<Expense> expenses) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.expenses = expenses;
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
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	public List<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
}
