package com.javas.javas.parking.Design;

public class BikeFare implements FareCalc {

	@Override
	public double calculateFare(long duration) {
		return duration * 0.4;
	}

}
