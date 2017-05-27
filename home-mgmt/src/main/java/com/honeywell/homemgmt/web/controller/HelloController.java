package com.honeywell.homemgmt.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.ModelRepository;
import com.honeywell.homemgmt.model.Model;

@RestController
public class HelloController {
	
	@Autowired
	ModelRepository repo;
	
	@RequestMapping(value="/hello" ,method=RequestMethod.GET)
	Model hello(){
		Model model = new Model("abc");
		repo.save(model);
		
		return model;
	}

}
