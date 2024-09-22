package com.javas.javas.parking.Design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public abstract class Vehicle {

	private String licencePlate;
	private VehicleType vehicleType;
}
