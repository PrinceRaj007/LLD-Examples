package com.example.cabbooking.strategy;

import com.example.cabbooking.models.Location;

public interface CabPricingStrategy {
	public double getFare(Location source, Location destination);
}
