package com.lld.examples.models;

import com.lld.examples.factory.StrategyFactory;
import com.lld.examples.strategies.FeeStrategy;

public class ParkingSlot {
	int slotNumber;
	Vehicle parkedVehicle;
	VehicleType parkingType;
	long startTime;
	FeeStrategy feeStrategy;
	
	public ParkingSlot(int slotNumber, VehicleType type) {
		this.slotNumber = slotNumber;
		parkingType = type;
		feeStrategy = StrategyFactory.getFeeStrategy(type);
	}
	
	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}
	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public int getSlotNumber() {
		return slotNumber;
	}
	public VehicleType getParkingType() {
		return parkingType;
	}
	public boolean isFree() {
		return parkedVehicle == null;
	}
	public boolean park(Vehicle vehicle) {
		if(!isFree() || parkingType != vehicle.getType() ) {
			return false;
		}
		setParkedVehicle(vehicle);
		setStartTime(System.currentTimeMillis()); 
		System.out.println("PARKING "+vehicle+" Parked in Slot Number: "+slotNumber);
		return true;
	}
	public int unpark() {
		if(isFree()) {
			return -1;
		}
		long totalTime = System.currentTimeMillis() - getStartTime();
		int totalHours = Math.max(1, (int)totalTime/(1000*60*60));
		System.out.println("UNPARKING "+getParkedVehicle()+" Unparked from Slot Number: "+slotNumber);
		int fee = feeStrategy.calculateParkingFee(totalHours);
		System.out.println("Total Parking fee for "+totalHours+" hours is :"+fee);
		parkedVehicle = null;
		startTime=0;
		return fee;
	}
}
