package com.honeywell.homemgmt.services;

import java.util.List;

import com.honeywell.homemgmt.model.Home;
import com.honeywell.homemgmt.model.PowerDevice;

public interface PowerService {
	
	List<PowerDevice> getAllPowerDevices(Home home);
	
	
	

}
