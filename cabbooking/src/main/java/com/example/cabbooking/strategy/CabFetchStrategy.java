package com.example.cabbooking.strategy;

import java.util.List;

import com.example.cabbooking.models.Cab;
import com.example.cabbooking.models.Location;

public interface CabFetchStrategy {
	public List<Cab> fetchEligibleCabs(List<Cab> cabs, Location source, final double MAX_ALLOWED_DISTANCE);
}
