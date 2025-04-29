package com.example.splitwise.models;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
	public Map<String, Double> calculateSplit(String payer, List<String> users, double amount, Map<String,Double> share);
}
