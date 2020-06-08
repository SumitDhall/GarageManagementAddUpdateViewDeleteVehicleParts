
package com.motors.gm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.motors.gm.model.VehicleParts;
import com.motors.gm.repository.VehiclePartsAddUpdateViewDeleteRepository;

@Service
public class VehiclePartsAddUpdateViewDeleteServiceImpl implements VehiclePartsAddUpdateViewDeleteService {

	@Autowired
	VehiclePartsAddUpdateViewDeleteRepository vehiclePartsAddUpdateViewDeleteRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveVehicleParts(VehicleParts vehicleParts) {
		vehiclePartsAddUpdateViewDeleteRepository.saveVehicleParts(vehicleParts);
		System.out.println("Vehicle Repository to save new vehicle Parts");
	}

	@Override
	public void updateVehicleParts(VehicleParts vehicleParts, String regNumber) {

		vehiclePartsAddUpdateViewDeleteRepository.updateVehicleParts(vehicleParts, regNumber);
		System.out.println("Vehicle Repository to update vehicle parts ");
	}

	public String deleteVehicleParts(String regNumber) {
		System.out.println("Vehicle Repository to delete vehicle parts");
		return vehiclePartsAddUpdateViewDeleteRepository.deleteVehicle(regNumber);
	}

}
