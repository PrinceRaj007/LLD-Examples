package com.example.cabbooking.strategy;

import com.example.cabbooking.models.Location;

public class SimpleCabPrcingStrategy implements CabPricingStrategy{

	public static final Double PER_KM_RATE = 10.0;
	
	@Override
	public double getFare(Location source, Location destination) {
		return PER_KM_RATE * source.caculateDistance(destination);
	}

}
