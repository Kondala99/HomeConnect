package com.honeywell.homemgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {
	
	public Model(String name) {
		super();
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	String name;

}
