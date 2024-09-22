package com.javas.javas.parking.Design;

public class VehicleFactory {
	public static Vehicle createVehicle(String licensePlate, VehicleType type) {
		switch (type) {
		case CAR:
			return new Car(licensePlate);
		case BIKE:
			return new Bike(licensePlate);
		case BUS:
			return new Bus(licensePlate);
		default:
			throw new IllegalArgumentException("Invalid vehicle type");
		}
	}
}
