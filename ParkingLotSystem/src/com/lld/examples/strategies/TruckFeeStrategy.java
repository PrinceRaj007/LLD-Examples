package com.lld.examples.strategies;

public class TruckFeeStrategy implements FeeStrategy{

	@Override
	public int calculateParkingFee(int hours) {
		return 30*hours;
	}
}
