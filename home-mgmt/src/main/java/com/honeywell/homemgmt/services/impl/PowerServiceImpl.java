package com.honeywell.homemgmt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.honeywell.homemgmt.dao.HomeRepository;
import com.honeywell.homemgmt.dao.PowerDeviceRepository;
import com.honeywell.homemgmt.model.Home;
import com.honeywell.homemgmt.model.PowerDevice;
import com.honeywell.homemgmt.services.PowerService;

public class PowerServiceImpl implements PowerService{
	
	@Autowired
	PowerDeviceRepository powerDeviceRepo;
	
	@Autowired
	HomeRepository homeRepo;

	@Override
	public List<PowerDevice> getAllPowerDevices(Long homeId) {
		
		Home home = homeRepo.findOne(homeId);
		
		return home.getDevices();
	}

	@Override
	public void addDevices(Long homeId, PowerDevice device) {
		
		Home home = homeRepo.findOne(homeId);
		
		device = powerDeviceRepo.save(device);
		
		home.getDevices().add(device);
		
		homeRepo.save(home);
		
		
	}

	

}
