package com.honeywell.homemgmt.model;

import javax.persistence.Entity;

@Entity
public class Television extends PowerDevice {
	
	
	private int channel;
	
	private int volume;
	
	private String wifi;
	
	private String standBy;

	

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getStandBy() {
		return standBy;
	}

	public void setStandBy(String standBy) {
		this.standBy = standBy;
	}
	
	

}
