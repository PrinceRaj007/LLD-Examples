package com.lld.examples.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lld.examples.strategies.ParkingStrategy;

public class ParkingLot {
	List<ParkingSlot> slots;
	ParkingStrategy parkingStrategy;
	
	public List<ParkingSlot> getSlots() {
		return slots;
	}
	public ParkingLot(Map<VehicleType, Integer> parkingLotConfig, ParkingStrategy parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
		this.slots = new ArrayList<>();
		int id = 0;
		for(Map.Entry<VehicleType, Integer> entry : parkingLotConfig.entrySet()) {
			for(int i=0;i<entry.getValue();i++) {
				slots.add(new ParkingSlot(id++, entry.getKey()));
			}
		}
	}
	
	public boolean park(Vehicle vehicle) {
		ParkingSlot slot = parkingStrategy.getNextFreeSlot(vehicle.getType(), this);
		return slot.park(vehicle);
	}
	public int unpark(Vehicle vehicle) {
		for(ParkingSlot slot: slots) {
			if(!slot.isFree() && slot.getParkedVehicle().getRegNumber().equals(vehicle.getRegNumber())) {
				return slot.unpark();
			}
		}
		return -1;
	}
	public void getTotalAvailableParking() {
		System.out.println();
		for(VehicleType type: VehicleType.values()) {
			long availableSlots  = slots.stream().filter(s->s.getParkingType()==type && s.isFree()).count();
			System.out.println("Available Slots for "+type+" is: "+availableSlots);
		}
		System.out.println();
	}
}
