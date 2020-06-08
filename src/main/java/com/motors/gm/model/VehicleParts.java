package com.motors.gm.model;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vehicleParts")
public class VehicleParts {

	
	@Id
	@NotBlank
	@NotNull
	@NotEmpty(message="Please provide the Car Registration Number")
	private String regNumber;
		
	private ArrayList<String> engineParts;
	private ArrayList<String> bodyParts;
	private ArrayList<String> interiorParts;
	private ArrayList<String> luxuryParts;
	private ArrayList<String> miscellaneousParts;
	
	public ArrayList<String> getMiscellaneousParts() {
		return miscellaneousParts;
	}
	public void setMiscellaneousParts(ArrayList<String> miscellaneousParts) {
		this.miscellaneousParts = miscellaneousParts;
	}
	public ArrayList<String> getEngineParts() {
		return engineParts;
	}
	public void setEngineParts(ArrayList<String> engineParts) {
		this.engineParts = engineParts;
	}
	public ArrayList<String> getBodyParts() {
		return bodyParts;
	}
	public void setBodyParts(ArrayList<String> bodyParts) {
		this.bodyParts = bodyParts;
	}
	public ArrayList<String> getInteriorParts() {
		return interiorParts;
	}
	public void setInteriorParts(ArrayList<String> interiorParts) {
		this.interiorParts = interiorParts;
	}
	public ArrayList<String> getLuxuryParts() {
		return luxuryParts;
	}
	public void setLuxuryParts(ArrayList<String> luxuryParts) {
		this.luxuryParts = luxuryParts;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
}
