package com.honeywell.homemgmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.homemgmt.dao.HomeRepository;
import com.honeywell.homemgmt.model.Home;
import com.honeywell.homemgmt.services.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	
	@Autowired
	private HomeRepository homeRepo;
	@Override
	public Home createHome(Home home) {
		homeRepo.save(home);
		return home;
	}
	
	

}
