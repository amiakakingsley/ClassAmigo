package com.amiaka.UserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amiaka.Repository.UserRepository;

@Service
public class UserDetailsServiceIMPL implements UserDetailsService {
	
	private final UserRepository userrepository;

	public UserDetailsServiceIMPL(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userrepository.findByEmail(username)
				.map(UserDetailsIMPL::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
	}

}
