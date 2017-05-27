package com.honeywell.homemgmt.model;

import javax.persistence.Entity;

@Entity
public class WashingMachine extends PowerDevice {
	
	private String spin;
	
	private String dryer;
	
	private String regular;
	
	private String mild;

	public String getSpin() {
		return spin;
	}

	public void setSpin(String spin) {
		this.spin = spin;
	}

	public String getDryer() {
		return dryer;
	}

	public void setDryer(String dryer) {
		this.dryer = dryer;
	}

	public String getRegular() {
		return regular;
	}

	public void setRegular(String regular) {
		this.regular = regular;
	}

	public String getMild() {
		return mild;
	}

	public void setMild(String mild) {
		this.mild = mild;
	}
	
	

}
