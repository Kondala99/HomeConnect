package com.honeywell.homemgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.homemgmt.model.Client;

/**
 * @author Abdul
 *
 */
public interface ClientRepository extends CrudRepository<Client, Long>   {

	Client findByClientId(String clientId);

}
