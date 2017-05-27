package com.honeywell.homemgmt.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(value="/hello" ,method=RequestMethod.GET)
	String hello(){
		return "hello";
	}

}
