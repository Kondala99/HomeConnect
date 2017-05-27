package com.honeywell.homemgmt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.honeywell.homemgmt.dao.UserRepository;
import com.honeywell.homemgmt.model.User;
import com.honeywell.homemgmt.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<User> listUsers() {		
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User createUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return user;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
