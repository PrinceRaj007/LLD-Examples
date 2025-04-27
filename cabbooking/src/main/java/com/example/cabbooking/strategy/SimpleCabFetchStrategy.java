package com.example.cabbooking.strategy;

import java.util.List;

import com.example.cabbooking.models.Cab;
import com.example.cabbooking.models.Location;

public class SimpleCabFetchStrategy implements CabFetchStrategy {

	@Override
	public List<Cab> fetchEligibleCabs(List<Cab> cabs, Location source, final double MAX_ALLOWED_DISTANCE) {
		return cabs.stream()
		.filter(cab->cab.isAvailable())
		.filter(cab->cab.getCurrTrip()==null)
		.filter(cab->cab.getCurrLocation().caculateDistance(source)<=MAX_ALLOWED_DISTANCE)
		.toList();
	}
}
