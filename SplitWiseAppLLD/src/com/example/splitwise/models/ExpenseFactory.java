package com.example.splitwise.models;

import java.util.List;
import java.util.Map;

public class ExpenseFactory {
    public static Expense createExpense( double amount, String payer, List<String> participants,  Map<String, Double> customShares, SplitType splitType) {
        SplitStrategy strategy;
        switch (splitType) {
            case EQUAL: strategy = new EqualSplitStrategy(); break;
            case UNEQUAL: strategy = new UnequalSplitStrategy(); break;
            case PERCENTAGE: strategy = new PercentageSplitStrategy(); break;
            default: throw new IllegalArgumentException("Invalid split type");
        }
        return new Expense(amount, payer, participants, customShares, strategy);
    }
}
