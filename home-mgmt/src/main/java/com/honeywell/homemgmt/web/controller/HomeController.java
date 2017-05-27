package com.honeywell.homemgmt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.HomeRepository;
import com.honeywell.homemgmt.dao.ModelRepository;
import com.honeywell.homemgmt.model.Home;
import com.honeywell.homemgmt.services.HomeService;

@RestController
@RequestMapping("/homes")
public class HomeController {
	
	@Autowired
	ModelRepository repo;
	

	@Autowired
	private HomeRepository homeRepo;
	
	@Autowired
	private HomeService homeService;
	

	@RequestMapping(method = RequestMethod.POST)
    public void addHome(@RequestBody Home home) {
		homeService.createHome(home);
 
    }

}
