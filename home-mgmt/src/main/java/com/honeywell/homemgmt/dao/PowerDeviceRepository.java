package com.honeywell.homemgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.homemgmt.model.PowerDevice;

public interface PowerDeviceRepository extends CrudRepository<PowerDevice, Long>  {

}
