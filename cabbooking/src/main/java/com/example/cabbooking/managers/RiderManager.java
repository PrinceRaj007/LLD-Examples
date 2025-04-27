package com.example.cabbooking.managers;

import java.util.HashMap;

import com.example.cabbooking.exceptions.RiderAlreadyExistsException;
import com.example.cabbooking.exceptions.RiderNotFoundException;
import com.example.cabbooking.models.Rider;

public class RiderManager {
	
	HashMap<String, Rider> riders = new HashMap<>();

	public void registerRider(Rider rider) {
		if (!riders.containsKey(rider.getId())) {
			throw new RiderAlreadyExistsException("Rider NOT FOUND !!");
		}
		riders.put(rider.getId(), rider);
	}

	public Rider getRider(String id) {
		if (!riders.containsKey(id)) {
			throw new RiderNotFoundException("Rider NOT FOUND !!");
		}
		return riders.get(id);
	}
}
