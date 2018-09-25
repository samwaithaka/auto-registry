package com.vehicle.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vehicle.utils.PlateNumberComputations;
import com.vehicle.utils.StringProcessor;

@ManagedBean(name = "actionsController", eager = true)
@SessionScoped
public class ActionsController {
	
	/**
	 * plateNumberText is the text that has plate numbers that need to be extracted
	 */
	private String plateNumberText;
	
	/**
	 * comparisonPlateNumbers are two plate numbers that are separated by comma
	 */
	
	private String comparisonPlateNumbers;
	/**
	 * vehicleCount stores the number of cars in between two given plate numbers
	 */
	
	private int vehicleCount;
	
	/**
	 * plateNumbers is list of plate numbers extracted from a given text
	 */
	
	private List<String> plateNumbers;
	
	public void extractPlateNo() {
		plateNumbers = StringProcessor.extractPlateNumber(plateNumberText);
	}
	
	public void getPlateNumberDifference() {
		String[] plateNumberArray = comparisonPlateNumbers.split(",");
		vehicleCount = PlateNumberComputations.
				findPlateNumberDifference(plateNumberArray[0],plateNumberArray[1]);
	}
	
	public int getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}

	public List<String> getPlateNumbers() {
		return plateNumbers;
	}

	public void setPlateNumbers(List<String> plateNumbers) {
		this.plateNumbers = plateNumbers;
	}
	
	public String getPlateNumberText() {
		return plateNumberText;
	}
	
	public void setPlateNumberText(String plateNumberText) {
		this.plateNumberText = plateNumberText;
	}
	
	public String getComparisonPlateNumbers() {
		return comparisonPlateNumbers;
	}
	
	public void setComparisonPlateNumbers(String comparisonPlateNumbers) {
		this.comparisonPlateNumbers = comparisonPlateNumbers;
	} 
}
