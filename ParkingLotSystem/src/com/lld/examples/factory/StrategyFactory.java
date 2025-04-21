package com.lld.examples.factory;

import com.lld.examples.models.VehicleType;
import com.lld.examples.strategies.BikeFeeStrategy;
import com.lld.examples.strategies.CarFeeStrategy;
import com.lld.examples.strategies.FeeStrategy;
import com.lld.examples.strategies.TruckFeeStrategy;

public class StrategyFactory {
	public static FeeStrategy getFeeStrategy(VehicleType type) {
		if(type == VehicleType.BIKE) {
			return new BikeFeeStrategy();
		}
		else if(type == VehicleType.CAR) {
			return new CarFeeStrategy();
		}
		else {
			return new TruckFeeStrategy();
		}
	}
}
