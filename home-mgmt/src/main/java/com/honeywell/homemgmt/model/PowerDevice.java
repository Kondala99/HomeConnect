package com.honeywell.homemgmt.model;

import javax.persistence.Entity;

@Entity
public class PowerDevice extends Model{

	private String powerOn;
	
	private String powerOff;
	
	

	public String getPowerOn() {
		return powerOn;
	}

	public void setPowerOn(String powerOn) {
		this.powerOn = powerOn;
	}

	public String getPowerOff() {
		return powerOff;
	}

	public void setPowerOff(String powerOff) {
		this.powerOff = powerOff;
	}
	
	

}
