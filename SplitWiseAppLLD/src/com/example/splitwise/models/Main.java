package com.example.splitwise.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<String> users = new ArrayList<>(); 
		users.add("ram");
		users.add("shyam");
		users.add("ghanshyam");
		users.add("mukesh");
		
		Map<String,Double> shares1 = Map.of("ram", 50.0, "shyam", 25.0, "ghanshyam", 100.0, "mukesh", 125.0);
		Map<String,Double> shares2 = Map.of("ram", 50.0, "shyam", 25.0, "ghanshyam", 10.0, "mukesh", 15.0);
		Expense expense1 = ExpenseFactory.createExpense(100, "ram", users, new HashMap<>(), SplitType.EQUAL);
		Expense expense2 = ExpenseFactory.createExpense(300, "ram", users, shares1, SplitType.UNEQUAL);
		Expense expense3 = ExpenseFactory.createExpense(400, "shyam", users, new HashMap<>(), SplitType.EQUAL);
		Expense expense4 = ExpenseFactory.createExpense(600, "ram", users, shares2, SplitType.PERCENTAGE);
		List<Expense> expenses = new ArrayList<>();
		expenses.add(expense1);
		expenses.add(expense2);
		expenses.add(expense3);
		expenses.add(expense4);
		
		Group group1 = new Group("123", "TravelExpenses", users, expenses);
		SplitSimplifier simplifier =  new SplitSimplifier();
		simplifier.simplifyBalance(group1);
	}

}
