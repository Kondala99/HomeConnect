package com.honeywell.homemgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.homemgmt.model.Home;


public interface HomeRepository extends CrudRepository<Home, Long>{

}
