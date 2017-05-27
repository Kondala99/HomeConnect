package com.honeywell.homemgmt.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.honeywell.homemgmt.dao.ClientRepository;
import com.honeywell.homemgmt.model.Client;
import com.honeywell.homemgmt.model.ClientDTO;
import com.honeywell.homemgmt.security.service.ClientDetailService;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService, ClientDetailService {
	
	@Autowired
	ClientRepository clientRepository;

	
	public ClientDetailsServiceImpl() {
		super();
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		Client client = clientRepository.findByClientId(clientId);
		
		if(client != null)
			return new ClientDTO(client);
		return null;
	}

	@Override
	public Client getCurrentClient() {
		Authentication a = SecurityContextHolder.getContext().getAuthentication();

		String clientId = ((OAuth2Authentication) a).getOAuth2Request().getClientId();
		
		
		return clientRepository.findByClientId(clientId);
	}

}
