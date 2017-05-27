package com.honeywell.homemgmt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Home extends Model{


	@OneToMany
	private List<PowerDevice> devices;
	
	private String room;
	
	private String door;


	public List<PowerDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<PowerDevice> devices) {
		this.devices = devices;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}
	
	
	
}
