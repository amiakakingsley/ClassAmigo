package com.amiaka.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.amiaka.Models.ApplicationUser;
public class UserDetailsIMPL implements UserDetails{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ApplicationUser applicationUser;
	
	public UserDetailsIMPL(ApplicationUser applicationUser) {
		super();
		this.applicationUser = applicationUser;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return  applicationUser.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return applicationUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return applicationUser.getEmail();
	}
	
	public Long getId() {
		return applicationUser.getId() ;
	}
	
	public String getFirstName() {
		return applicationUser.getFirstname() ;
	}
	
	public String getLateName() {
		return applicationUser.getLastname() ;
	}
	
	

}
