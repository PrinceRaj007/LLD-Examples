package com.example.cabbooking.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.TripNotFoundException;
import com.example.cabbooking.models.Cab;
import com.example.cabbooking.models.Location;
import com.example.cabbooking.models.Rider;
import com.example.cabbooking.models.Status;
import com.example.cabbooking.models.Trip;
import com.example.cabbooking.strategy.CabFetchStrategy;
import com.example.cabbooking.strategy.CabPricingStrategy;

public class TripManager {
	
	Map<String, List<Trip>> trips = new HashMap<>();
	final double MAX_ALLOWED_DISTANCE = 10.0;
	CabManager cabManager;
	CabFetchStrategy cabFetchStrategy;
	CabPricingStrategy pricingStrategy;

	public void createTrip(Rider rider, Location source, Location destination) {
		List<Cab> closeByCabs = cabFetchStrategy.fetchEligibleCabs(cabManager.getCabs().values().stream().toList(),
				source, MAX_ALLOWED_DISTANCE);
		if (closeByCabs == null || closeByCabs.isEmpty()) {
			throw new CabNotFoundException(" No Cab FOUND !! ");
		}
		Cab selectedCab = closeByCabs.get(0);
		double price = pricingStrategy.getFare(source, destination);
		Trip trip = new Trip(selectedCab, rider, source, destination, Status.IN_PROGRESS, price);
		selectedCab.setCurrTrip(trip);
		trips.getOrDefault(rider.getId(), new ArrayList<>()).add(trip);
	}
	public void endTrip(Cab cab) {
		if(cab.getCurrTrip()==null) {
			throw new TripNotFoundException("Trip Not Found !!");
		}
		cab.setCurrTrip(null);
	}

}
