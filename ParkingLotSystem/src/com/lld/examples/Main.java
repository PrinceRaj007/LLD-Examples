package com.lld.examples;

import java.util.HashMap;
import java.util.Map;

import com.lld.examples.models.Bike;
import com.lld.examples.models.Car;
import com.lld.examples.models.ParkingLot;
import com.lld.examples.models.VehicleType;
import com.lld.examples.strategies.SimpleParkingStrategy;


public class Main {

	public static void main(String[] args) {
		Map<VehicleType,Integer> parkingLotConfig = new HashMap<>();
		parkingLotConfig.put(VehicleType.BIKE, 4);
		parkingLotConfig.put(VehicleType.CAR, 4);
		parkingLotConfig.put(VehicleType.TRUCK, 4);
		
		ParkingLot parkingLot = new ParkingLot(parkingLotConfig, new SimpleParkingStrategy());
		
		parkingLot.park(new Car("RT-01-3M-0023"));
		parkingLot.park(new Car("ET-01-3M-0024"));
		parkingLot.park(new Car("BT-01-3M-0025"));
		parkingLot.park(new Car("CT-01-3M-0027"));
		parkingLot.unpark(new Car("CT-01-3M-0027"));
		
		parkingLot.getTotalAvailableParking();
		
		parkingLot.park(new Bike("BR-12-J1-5632"));
		parkingLot.park(new Bike("BL-12-J1-5638"));
		parkingLot.park(new Bike("BJ-12-J1-5636"));
		parkingLot.park(new Bike("BO-12-J1-5637"));

		parkingLot.getTotalAvailableParking();
		
		parkingLot.unpark(new Bike("BR-12-J1-5632"));
		parkingLot.getTotalAvailableParking();
	}  

}
