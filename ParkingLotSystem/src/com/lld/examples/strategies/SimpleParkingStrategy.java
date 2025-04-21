package com.lld.examples.strategies;

import java.util.List;

import com.lld.examples.exception.ParkingSlotUnavailableException;
import com.lld.examples.models.ParkingLot;
import com.lld.examples.models.ParkingSlot;
import com.lld.examples.models.VehicleType;


public class SimpleParkingStrategy implements ParkingStrategy{

	@Override
	public ParkingSlot getNextFreeSlot(VehicleType type, ParkingLot parkingLot) {
		List<ParkingSlot> freeSlots = parkingLot.getSlots().stream().filter(s->s.isFree()&&s.getParkingType()==type).toList();
		if(freeSlots.isEmpty()) {
			throw new ParkingSlotUnavailableException(" Free Slots NOT FOUND !!");
		}
		return freeSlots.get(0);
	}

}
