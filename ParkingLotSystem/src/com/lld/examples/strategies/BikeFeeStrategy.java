package com.lld.examples.strategies;

public class BikeFeeStrategy implements FeeStrategy{

	@Override
	public int calculateParkingFee(int hours) {
		return 10*hours;
	}
}
