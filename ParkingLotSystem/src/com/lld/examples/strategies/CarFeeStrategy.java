package com.lld.examples.strategies;

public class CarFeeStrategy implements FeeStrategy{

	@Override
	public int calculateParkingFee(int hours) {
		return 20*hours;
	}
}
