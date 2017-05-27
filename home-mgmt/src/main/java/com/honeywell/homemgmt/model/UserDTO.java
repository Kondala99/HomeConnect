package com.honeywell.homemgmt.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDTO implements Serializable, UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	

	public UserDTO(String username) {
		super();
		this.username = username;		
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		encoder.setIterations(1);
	       String hashOutput = encoder.encodePassword(password,null);
	       this.password = "7c329cfa2c2f6b30fe75e7406676a36ca7e5cdb95871e916306f5f83607d4259ad3ee298f1152d94";
		this.accountEnable = true;
		
	}
	
	public UserDTO(User user){
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.accountEnable = user.isAccountEnable();
		this.salt = user.getSalt();
		
	}

	public UserDTO() {
		super();
		this.accountEnable = true;
	}

	private String username;
	
	private String password;
	
	private String salt;
	
	private boolean accountEnable;
	
	
	
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	
	
	
	private Set<GrantedAuthority> privileges = new HashSet<GrantedAuthority>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isAccountEnable() {
		return accountEnable;
	}

	public void setAccountEnable(boolean accountEnable) {
		this.accountEnable = accountEnable;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	}
	
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public Set<GrantedAuthority> getPrivileges() {
		return privileges;
	}

	public void setPreviliges(Set<GrantedAuthority> privileges) {
		this.privileges = privileges;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountEnable;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountEnable;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return accountEnable;
	}

	@Override
	public boolean isEnabled() {
		return accountEnable;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password="
				+ password + ", salt=" + salt + ", accountEnable="
				+ accountEnable + ", authorities=" + authorities + "]";
	}

}
