package com.amiaka.Userservice;

import java.util.List;
import java.util.Optional;

import com.amiaka.ModelDto.ApplicationUserDto;
import com.amiaka.Models.ApplicationUser;

public interface UserService {
	
	void RegisterUser( ApplicationUserDto applicationUserDto);
	
	Optional<ApplicationUser> findUserByEmail(String email);
	
	List<ApplicationUserDto> findAllUser();
	
	boolean findById(long id);
	
	void AssignTutorRole(long id);
	
	ApplicationUserDto getUserProfile();
	
	ApplicationUser getPrincipal();

}
