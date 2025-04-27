package com.example.cabbooking.managers;

import java.util.HashMap;
import java.util.Map;

import com.example.cabbooking.exceptions.CabAlreadyExistsException;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.models.Cab;
import com.example.cabbooking.models.Location;

public class CabManager {
	Map<String, Cab> cabs = new HashMap<>();
	
	public void registerCab(Cab cab) {
		if(cabs.containsKey(cab.getId())) {
			throw new CabAlreadyExistsException("Cab Already Exists !!");
		}
		cabs.put(cab.getId(), cab);
	}
	public Cab getCab(String id) {
		if(!cabs.containsKey(id)) {
			throw new CabNotFoundException("Cab doesn't exists !!");
		}
		return cabs.get(id);
	}
	public void updateCabLocation(String id,Location location) {
		if(!cabs.containsKey(id)) {
			throw new CabNotFoundException("Cab doesn't exists !!");
		}
		cabs.get(id).setCurrLocation(location);
	}
	public void updateCabAvailablity(String id,boolean isAvailable) {
		if(!cabs.containsKey(id)) {
			throw new CabNotFoundException("Cab doesn't exists !!");
		}
		cabs.get(id).setAvailable(isAvailable);
	}
	public Map<String, Cab> getCabs() {
		return cabs;
	}
	
}
