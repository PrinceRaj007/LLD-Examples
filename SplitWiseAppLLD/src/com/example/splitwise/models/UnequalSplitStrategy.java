package com.example.splitwise.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnequalSplitStrategy implements SplitStrategy {

	@Override
	public Map<String, Double> calculateSplit(String payer, List<String> users, double amount, Map<String, Double> share) {
		return new HashMap<>(share);
	}
}
