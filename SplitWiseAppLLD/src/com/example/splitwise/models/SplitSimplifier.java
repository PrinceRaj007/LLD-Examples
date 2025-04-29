package com.example.splitwise.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitSimplifier {
	
	public void simplifyBalance(Group group) {
		 Map<String, Double> balanceSheet = new HashMap();
		 for(Expense expense : group.getExpenses()) {
			 balanceSheet.put(expense.getPayer(), expense.getAmount() + balanceSheet.getOrDefault(expense.getPayer(), 0.0));
			 for(Map.Entry<String, Double> entry : expense.getSplitShare().entrySet()) {
				 balanceSheet.put(entry.getKey(), balanceSheet.getOrDefault(entry.getKey(), 0.0) - entry.getValue());
			 }
			 System.out.println("Intermediate Balance Sheet: "+balanceSheet);
		 }
		 System.out.println();
		 System.out.println("Final Balance Sheet: "+balanceSheet);
		 System.out.println();
		 simplifyTransaction(balanceSheet);
	}
	private List<Transaction> simplifyTransaction(Map<String, Double> balanceSheet){
		PriorityQueue<Map.Entry<String, Double>> creditors = new PriorityQueue<>((a,b)->Double.compare(b.getValue(), a.getValue()));
		PriorityQueue<Map.Entry<String, Double>> debitors = new PriorityQueue<>((a,b)->Double.compare(a.getValue(), b.getValue()));
		for(Map.Entry<String, Double> entry : balanceSheet.entrySet()) {
			if(entry.getValue()<0) {
				debitors.add(entry);
			}else {
				creditors.add(entry);
			}
		}
		List<Transaction> transactions = new ArrayList<>();
		while(!creditors.isEmpty() && !debitors.isEmpty()) {
			Map.Entry<String, Double> creditor = creditors.poll();
			Map.Entry<String, Double> debitor = debitors.poll();
			Double amountPaid = Math.min(Math.abs(debitor.getValue()), creditor.getValue());
			Transaction transaction  = new Transaction(debitor.getKey(),creditor.getKey(),amountPaid);
			transactions.add(transaction);
			creditor.setValue(creditor.getValue()-amountPaid);
			debitor.setValue(debitor.getValue()+amountPaid);
			if (debitor.getValue() != 0) debitors.add(debitor);
            if (creditor.getValue() != 0) creditors.add(creditor);			
		}
		transactions.forEach(t->System.out.println(t));
		return transactions;
	}

}
