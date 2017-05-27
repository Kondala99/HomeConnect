package com.honeywell.homemgmt.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Television.class, name = "Television"),
		@JsonSubTypes.Type(value = AirConditioner.class, name = "AirConditioner"),
		@JsonSubTypes.Type(value = WashingMachine.class, name = "WashingMachine")})
public abstract class PowerDevice extends Model{

	private Boolean powerOn;
	

	public void setPowerOn(Boolean powerOn) {
		this.powerOn = powerOn;
	}


	public Boolean isPowerOn() {
		return powerOn;
	}	
	
	

}
