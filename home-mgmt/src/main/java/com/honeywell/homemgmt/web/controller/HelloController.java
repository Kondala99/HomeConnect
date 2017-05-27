package com.honeywell.homemgmt.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.ModelRepository;

@RestController
public class HelloController {
	
	@Autowired
	ModelRepository repo;
	
	
	

}
