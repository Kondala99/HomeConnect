package com.honeywell.homemgmt.services;

import java.util.List;

import com.honeywell.homemgmt.model.PowerDevice;

public interface PowerService {
	
	List<PowerDevice> getAllPowerDevices(Long homeId);

	void addDevices(Long homeId, PowerDevice powerdevice);
	
	

}
