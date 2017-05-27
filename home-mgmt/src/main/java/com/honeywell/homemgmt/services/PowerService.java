package com.honeywell.homemgmt.services;

import java.util.List;

import com.honeywell.homemgmt.model.PowerDevice;

public interface PowerService {
	
	List<PowerDevice> getAllPowerDevices(Long homeId);

	PowerDevice addDevices(Long homeId, PowerDevice powerdevice);

	PowerDevice powerOn(Long homeId, Long deviceId);

	PowerDevice powerOff(Long homeId, Long deviceId);
	
	

}
