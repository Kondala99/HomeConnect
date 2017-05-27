package com.honeywell.homemgmt.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ClientDTO implements Serializable, ClientDetails {
	
	static final String DELIMITER = ",";

	String clientId;

	Set<String> resourceIds = Collections.emptySet();

	String clientSecret;

	Set<String> scope = Collections.emptySet();;

	Set<String> authorizedGrantTypes = Collections.emptySet();;

	Set<String> registeredRedirectUri;

	Map<String, Object> additionalInformation = new LinkedHashMap<>();

	Collection<GrantedAuthority> authorities;



	public ClientDTO(Client client) {
		this.clientId = client.getClientId();

		if(client.getResourceIds() != null)
			this.resourceIds = new HashSet<>(Arrays.asList(client.getResourceIds().split(DELIMITER)));
		this.clientSecret = client.getClientSecret();
		this.scope = new HashSet<>(Arrays.asList(client.getScope().split(DELIMITER)));
		this.authorizedGrantTypes = new HashSet<>(Arrays.asList(client.getAuthorizedGrantTypes().split(DELIMITER)));
		if(client.getWebServerRedirectUri() != null)
			this.registeredRedirectUri = new HashSet<>(Arrays.asList(client.getWebServerRedirectUri().split(DELIMITER)));

		if(client.getAuthorities() != null)
			setAuthorities(client.getAuthorities());


	}

	private void setAuthorities(String authorities2) {
		String[] roles = authorities2.split(DELIMITER);
		authorities = new HashSet<>();
		for (String a : roles) {
			authorities.add(new SimpleGrantedAuthority(a));
		}

	}

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return resourceIds;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return scope;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return authorizedGrantTypes;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return registeredRedirectUri;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return 4000;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return 50000;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return additionalInformation;
	}

}
