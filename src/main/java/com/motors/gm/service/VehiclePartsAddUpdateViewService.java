package com.motors.gm.service;

import com.motors.gm.model.VehicleParts;

public interface VehiclePartsAddUpdateViewService {

	void saveVehicleParts(VehicleParts vehicleParts);

	public void updateVehicleParts(VehicleParts vehicleParts, String regNumber);
	
	public String deleteVehicleParts(String regNumber);
}