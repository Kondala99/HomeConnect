package com.honeywell.homemgmt.model;

import javax.persistence.Entity;

@Entity
public class AirConditioner extends PowerDevice{
	
	
	private double temperature;
	
	private String onlyFan;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getOnlyFan() {
		return onlyFan;
	}

	public void setOnlyFan(String onlyFan) {
		this.onlyFan = onlyFan;
	}
	
	

}
