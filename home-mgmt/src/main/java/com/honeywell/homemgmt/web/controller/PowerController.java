package com.honeywell.homemgmt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.ModelRepository;
import com.honeywell.homemgmt.model.PowerDevice;
import com.honeywell.homemgmt.services.PowerService;

@RestController
public class PowerController {
	
	@Autowired
	ModelRepository repo;
	

	@Autowired
	private PowerService powerService;	
	
	
	@RequestMapping(value = "/homes/{homeId}/devices", method = RequestMethod.POST)
    public PowerDevice addDevices(@PathVariable("homeId") Long homeId, @RequestBody PowerDevice device) {
		return powerService.addDevices(homeId, device);
 
    }
	
	@RequestMapping(value = "/homes/{homeId}/devices/{deviceId}/on", method = RequestMethod.PUT)
    public PowerDevice powerOn(@PathVariable("homeId") Long homeId, @PathVariable("deviceId") Long deviceId) {
		return powerService.powerOn(homeId,deviceId);
 
    }
	
	@RequestMapping(value = "/homes/{homeId}/devices/{deviceId}/off", method = RequestMethod.PUT)
    public PowerDevice powerOff(@PathVariable("homeId") Long homeId, @PathVariable("deviceId") Long deviceId) {
		return powerService.powerOff(homeId,deviceId); 
    }

}
