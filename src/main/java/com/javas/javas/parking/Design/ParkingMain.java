package com.javas.javas.parking.Design;

public class ParkingMain {

	public static void main(String arg[]) {
		ParkingLot parkingLot = ParkingLot.getInstance(10); // Singleton instance

		Vehicle car = VehicleFactory.createVehicle("CAR123", VehicleType.CAR);
		Vehicle bike = VehicleFactory.createVehicle("BIKE456", VehicleType.BIKE);
		Vehicle bus = VehicleFactory.createVehicle("BUS789", VehicleType.BUS);

		System.out.println(parkingLot.parkVehicle(car));
		System.out.println(parkingLot.parkVehicle(bike));
		System.out.println(parkingLot.parkVehicle(bus));

		try {
			Thread.sleep(36000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(parkingLot.exitVehicle(car.getLicencePlate()));
		System.out.println(parkingLot.exitVehicle(bike.getLicencePlate()));
		System.out.println(parkingLot.exitVehicle(bus.getLicencePlate()));
	}

}