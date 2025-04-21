package com.lld.examples.strategies;

import com.lld.examples.models.ParkingLot;
import com.lld.examples.models.ParkingSlot;
import com.lld.examples.models.VehicleType;

public interface ParkingStrategy {
	public ParkingSlot getNextFreeSlot(VehicleType type, ParkingLot parkingLot);
}
