package com.example.splitwise.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy {

	@Override
	public Map<String, Double> calculateSplit(String payer, List<String> users, double amount, Map<String, Double> share) {

		Map<String, Double> splitShare = new HashMap<>();
		for(String user: users) {
			double splitAmount = (amount/100) * share.get(user);
			splitShare.put(user, splitAmount);
		}
		return splitShare;
	}
}
