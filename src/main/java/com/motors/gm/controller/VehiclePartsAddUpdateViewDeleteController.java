package com.motors.gm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motors.gm.model.VehicleParts;
import com.motors.gm.service.VehiclePartsAddUpdateViewDeleteService;

@RestController
@RequestMapping(path = "/auvdAsset")
public class VehiclePartsAddUpdateViewDeleteController {

	private static final Logger LOGGER = LogManager
			.getLogger(VehiclePartsAddUpdateViewDeleteController.class.getName());

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	VehiclePartsAddUpdateViewDeleteService vehiclePartsAddUpdateViewDeleteService;

	// Annotation Based Validation: used @Valid annotation to validate if the
	// request body has met all the validations put on the VehicleParts class
	@PostMapping(path = "/addVehicleParts", produces = "application/json")
	public String save(@Valid @RequestBody VehicleParts vehicleParts) {
		LOGGER.info("Garage Management Add Vehicle Parts Service");
		vehiclePartsAddUpdateViewDeleteService.saveVehicleParts(vehicleParts);
		return "Save Parts Success";
	}

	// Annotation Based Validation: used @Valid annotation to validate if the
		// request body has met all the validations put on the VehicleParts class
	@PutMapping(path = "/updateVehicleParts/{regNumber}/{partType}", produces = "application/json")
	public String update(@RequestBody VehicleParts vehicleParts, @PathVariable @NotEmpty @NotBlank String regNumber, @PathVariable @NotEmpty @NotBlank String partType) {
		LOGGER.info("Garage Management Update Vehicle Parts Service");
		vehiclePartsAddUpdateViewDeleteService.updateVehicleParts(vehicleParts, regNumber);
		return "Update Success";
	}

	// Annotation Based Validation: used @Valid annotation to validate if the
		// request body has met all the validations put on the VehicleParts class
	@DeleteMapping(path = "/deleteVehicleParts/{regNumber}/{partType}", produces = "application/json")
	public String deleteVehicle(@PathVariable @NotEmpty @NotBlank String regNumber, @PathVariable @NotEmpty @NotBlank String partType) {
		LOGGER.info("Garage Management Delete Vehicle Model Service");
		return vehiclePartsAddUpdateViewDeleteService.deleteVehicleParts(regNumber);
	}
	/*// findAllVehicle Parts method will call service findAllVehicle Parts method to findAll
		// existing vehicle Parts in DB
		@GetMapping(path = "/findAllVehicleParts", produces = "application/json")
		public List<VehicleParts> findAllVehiclePartsDetails() {
			LOGGER.info("Garage Management View All Vehicle Parts Service");
			LOGGER.debug("Below are the all available cars: \n " + vehicleModelAddUpdateViewService.findAllVehicle());
			return vehiclePartsAddUpdateViewDeleteService.findAllVehicle();
		}

		// findVehicleByRegNumber method will call service findVehicleByRegNumber
		//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
		// method to findVehicleByRegNumber in DB
		@GetMapping(path = "/findVehicleByRegNumber/{regNumber}", produces = "application/json")
		public List<VehicleModel> findByRegNumberVehicleDetails(@PathVariable @NotBlank @NotEmpty String regNumber) {
			LOGGER.info("Garage Management View Vehicle Model with Registration Number, Vehicle Model Service");
//			LOGGER.debug("Below are the all available cars: \n "
//					+ vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber));
			return vehiclePartsAddUpdateViewDeleteService.findVehicleByRegNumber(regNumber);
		}

		// findVehicleByFeatures method will call service findVehicleByFeatures
		// method to findVehicleByFeatures provided by user in DB
		@GetMapping(path = "/findVehiclePartsByType", produces = "application/json")
		public List<VehicleModel> findVehicleByFeaturesVehicleDetails(@RequestBody VehicleModel vehicleModel) {
			LOGGER.info("Garage Management View Vehicle Model with different features, Vehicle Model Service");
//			LOGGER.debug("Below are the all available cars: \n "
//					+ vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel));
			return vehiclePartsAddUpdateViewDeleteService.findVehicleByFeaturesVehicleDetails(vehicleModel);
		}
	}*/

}
