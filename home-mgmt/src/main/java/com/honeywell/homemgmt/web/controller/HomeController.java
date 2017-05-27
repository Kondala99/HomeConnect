package com.honeywell.homemgmt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.ModelRepository;
import com.honeywell.homemgmt.model.Home;
import com.honeywell.homemgmt.model.PowerDevice;
import com.honeywell.homemgmt.services.HomeService;
import com.honeywell.homemgmt.services.PowerService;

@RestController
@RequestMapping("/homes")
public class HomeController {
	
	@Autowired
	ModelRepository repo;
	
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private PowerService powerService;	
	

	@RequestMapping(method = RequestMethod.POST)
    public void addHome(@RequestBody Home home) {
		homeService.createHome(home);
 
    }
	
	@RequestMapping(value = "/{homeId}/devices", method = RequestMethod.GET)
	public List<PowerDevice> powerDevicelist(@PathVariable("homeId") Long homeId){
		
		return powerService.getAllPowerDevices(homeId);
		
	}

}
