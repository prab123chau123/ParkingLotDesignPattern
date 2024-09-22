package com.javas.javas.parking.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

	private static ParkingLot parkingLot;
	private List<ParkingSlot> parkingSlots;
	private HashMap<String, ParkingRecord> records;

	private ParkingLot(int numberOfSlots) {
		this.parkingSlots = new ArrayList<ParkingSlot>();
		this.records = new HashMap<String, ParkingRecord>();
		for (int i = 0; i < numberOfSlots; i++) {
			if (i <= numberOfSlots / 2) {
				this.parkingSlots.add(new ParkingSlot(i, VehicleType.CAR));
			} else if (i <= numberOfSlots * 3 / 4) {
				this.parkingSlots.add(new ParkingSlot(i, VehicleType.BIKE));
			} else {
				this.parkingSlots.add(new ParkingSlot(i, VehicleType.BUS));
			}
		}

	}

	public static synchronized ParkingLot getInstance(int numberOfSlots) {
		if (parkingLot == null) {
			parkingLot = new ParkingLot(numberOfSlots);
		}
		return parkingLot;
	}

	public String parkVehicle(Vehicle vehicle) {
		for (ParkingSlot slot : parkingSlots) {
			if (!slot.isOccupied() && slot.getVehicleType() == vehicle.getVehicleType()) {
				slot.occupy();
				ParkingRecord record = new ParkingRecord(slot, vehicle);
				records.put(vehicle.getLicencePlate(), record);
				return "Vehicle parked in slot " + slot.getSlotNumber();
			}
		}
		return "No available slots for this vehicle type.";
	}

	public String exitVehicle(String licencePlate) {
		ParkingRecord record = this.records.get(licencePlate);
		if (record != null) {
			record.exit();
			double fare = record.calculateFare();
			record.parkingSlot.vaccate();
			records.remove(licencePlate);
			return "Vehicle Existed  fare : $" + fare;
		}
		return "No record found for this vehicle.";
	}
}
