package com.honeywell.homemgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.homemgmt.model.Model;

public interface ModelRepository extends CrudRepository<Model, Long>  {

}
