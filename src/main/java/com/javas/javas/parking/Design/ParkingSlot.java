package com.javas.javas.parking.Design;

public class ParkingSlot {

	private int slotNumber;
	private VehicleType vehicleType;
	private boolean isOccupied;

	public ParkingSlot(int slotNumber, VehicleType vehicleType) {
		super();
		this.slotNumber = slotNumber;
		this.vehicleType = vehicleType;
		this.isOccupied = false;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public void occupy() {
		this.isOccupied = true;
	}

	public void vaccate() {
		this.isOccupied = false;
	}

}
