package com.honeywell.homemgmt.security.service.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.honeywell.homemgmt.dao.UserRepository;
import com.honeywell.homemgmt.model.User;
import com.honeywell.homemgmt.model.UserDTO;


/**
 * The service class which provides user authentication
 * @author Abdul
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, SaltSource, Serializable {

	@Autowired
	transient UserRepository userRepository;

	private static final String ROLE_USER = "ROLE_USER";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger object for UserDetailsServiceImpl
	 */
	private static final Log log = LogFactory
			.getLog(UserDetailsServiceImpl.class);

	/*private static final String USER_ID = "USER_ID";

	private static final String PASSWORD = "PASSWORD";

	private static final String SALT = "SALT";

	private static final String ACCOUNT_ENABLED = "ACCOUNT_ENABLED";

	private static final String ROLE_NAME = "ROLE_NAME";

	private static final String PRIVILEGE_NAME = "PRIVILEGE_NAME";*/



	/**
	 * returning UserDetails for given username 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override 
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		try {			

			User user = userRepository.findByUsername(username);
			UserDTO userDetails = new UserDTO(user);




			/*List<String> userroles = new ArrayList<String>();
			userroles.add(ROLE_USER);*/
			if(user.getRoles() != null)
				setRoles(userDetails, Arrays.asList(user.getRoles().split(",")));

			log.info("user logged in "+userDetails);
			return userDetails;

		} catch (EmptyResultDataAccessException ErdaExc) {
			log.error("No user exists with given username :" + username,
					ErdaExc);
		} catch (IncorrectResultSizeDataAccessException incrRes) {
			log.error("More than one users exists with given username :"
					+ username, incrRes);
		} catch(Exception e){
			log.error("Error occurred whil loading user detials ", e);
		}
		return null;
	}

	private void setRoles(UserDTO userDetailsDTO, List<String> userroles) {

		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (final String role : userroles) {

			/*roles.add(new GrantedAuthority() {

				private static final long serialVersionUID = 1L;

				@Override
				public String getAuthority() {
					return role;
				}
			});*/

			roles.add( new SimpleGrantedAuthority("ROLE_" + role));
		}
		userDetailsDTO.setAuthorities(roles);
	}

	private void setPrivileges(UserDTO userDetailsDTO, List<String> userPrivileges) {

		Set<GrantedAuthority> privileges = new HashSet<GrantedAuthority>();
		for (final String privilege : userPrivileges) {

			/*privileges.add(new GrantedAuthority() {

				private static final long serialVersionUID = 1L;

				@Override
				public String getAuthority() {
					return privilege;
				}
			});*/

			privileges.add( new SimpleGrantedAuthority(privilege));
		}
		userDetailsDTO.setPreviliges(privileges);
	}



	@Override
	public Object getSalt(UserDetails userDetails) {
		return ((UserDTO) userDetails).getSalt();
	}
}
