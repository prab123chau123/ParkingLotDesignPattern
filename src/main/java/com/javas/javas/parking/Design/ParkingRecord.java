package com.javas.javas.parking.Design;

import java.time.LocalDateTime;

public class ParkingRecord {

	public ParkingSlot parkingSlot;
	public Vehicle vehicle;
	private FareCalc fareCalc;
	private LocalDateTime entryTime;
	private LocalDateTime exisDateTime;

	public ParkingRecord(ParkingSlot parkingSlot, Vehicle vehicle) {
		this.parkingSlot = parkingSlot;
		this.vehicle = vehicle;
		this.entryTime = LocalDateTime.now();
		this.fareCalc = getFareCalc(vehicle.getVehicleType());
	}

	private FareCalc getFareCalc(VehicleType vehicleType) {
		switch (vehicleType) {
		case CAR:
			return new CarFare();
		case BIKE:
			return new BikeFare();
		case BUS:
			return new BusFare();
		default:
			throw new IllegalArgumentException("Invalid Vehicle Type");
		}
	}

	public void exit() {
		this.exisDateTime = LocalDateTime.now();
	}

	public double calculateFare() {
		long duration = java.time.Duration.between(exisDateTime, entryTime).toHours();
		return this.fareCalc.calculateFare(duration);
	}

}
