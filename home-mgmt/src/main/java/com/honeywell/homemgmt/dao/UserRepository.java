package com.honeywell.homemgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.homemgmt.model.User;

/**
 * @author Abdul
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
