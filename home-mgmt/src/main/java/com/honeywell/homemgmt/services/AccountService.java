package com.honeywell.homemgmt.services;

import java.util.List;

import com.honeywell.homemgmt.model.User;

public interface AccountService {
	
	List<User> listUsers();	
	User createUser(User user);
	User getUser();
	boolean deleteUser();
	

}
