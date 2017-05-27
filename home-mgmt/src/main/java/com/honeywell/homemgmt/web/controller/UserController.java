package com.honeywell.homemgmt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honeywell.homemgmt.model.User;
import com.honeywell.homemgmt.services.AccountService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public User registerUser(@RequestBody User user){
		return accountService.createUser(user);
	}

}
