package com.example.splitwise.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

	@Override
	public Map<String, Double> calculateSplit(String payer, List<String> users, double amount, Map<String, Double> share) {

		Map<String, Double> splitShare = new HashMap<>();
		double splitAmount = amount/users.size();
		for(String user: users) {
			splitShare.put(user, splitAmount);
		}
		return splitShare;
	}
}
