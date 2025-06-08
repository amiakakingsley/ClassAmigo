package com.amiaka.Userservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amiaka.ModelDto.ApplicationUserDto;
import com.amiaka.Models.ApplicationUser;
import com.amiaka.Models.Role;
import com.amiaka.Repository.RoleRepository;
import com.amiaka.Repository.UserRepository;
import com.amiaka.UserDetails.UserDetailsIMPL;
@Service
public class UserServiceIMPL implements UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	private ApplicationUser applicationUser;

	public UserServiceIMPL(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
		this.applicationUser = new ApplicationUser();
	}

	@Override
	public void RegisterUser( ApplicationUserDto applicationUserDto) {
		
		ApplicationUser user = new ApplicationUser();
		user.setFirstname(applicationUserDto.getFirstname());
		user.setLastname(applicationUserDto.getLastname());
		user.setEmail(applicationUserDto.getEmail());
		user.setPassword(passwordEncoder.encode(applicationUserDto.getPassword()));
		
		String roleName = "USER"; 
		
	    Role existingRole = roleRepository.findByName(roleName);
	    
	    if (existingRole == null) {
	        Role newRole = new Role();
	        newRole.setName(roleName);
	        existingRole = roleRepository.save(newRole); // Save the new role
	    }

		Set<Role> roles =  new HashSet<>();
		roles.add(existingRole); 
	    
	    user.setRoles(roles);

	   
	    userRepository.save(user);
	}
		
		

	@Override
	public Optional<ApplicationUser> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<ApplicationUserDto> findAllUser() {
		
		List<ApplicationUser> allUser = userRepository.findAll();
		
		List<ApplicationUserDto> applicationUserDto = new ArrayList<>();
		 
		for(ApplicationUser user : allUser) {
			ApplicationUserDto userDto = new ApplicationUserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFirstname(user.getFirstname());
			userDto.setLastname(user.getLastname());
			userDto.setPassword(user.getPassword());
			
		
	        userDto.setRoles(new HashSet<>(user.getRoles())); 
	        
	        // Add the user DTO to the list
	        applicationUserDto.add(userDto);
	    }
	    return applicationUserDto;
	}

	@Override
	public void AssignTutorRole(long id) {
		ApplicationUser user = userRepository.findById(id).orElse(null);
		
		Role tutorRole = roleRepository.findByName("TUTOR");
		
		if(tutorRole == null) {
			tutorRole = new Role();
			tutorRole.setName("TUTOR");
			tutorRole = roleRepository.save(tutorRole);
		}
		
		if(!user.getRoles().contains(tutorRole)) {
		user.getRoles().add(tutorRole);
		userRepository.save(user);
		}
	}

	@Override
	public boolean findById(long id) {
		if(userRepository.findById(id).isPresent())
		return true;
		
		return false;
	}

	@Override
	public ApplicationUserDto getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
        	UserDetailsIMPL userDetails = (UserDetailsIMPL) authentication.getPrincipal();
            ApplicationUserDto applicationUserDto = new ApplicationUserDto();
            applicationUserDto.setFirstname(userDetails.getFirstName());
            applicationUserDto.setLastname(userDetails.getLateName());
            applicationUserDto.setId(userDetails.getId());
            applicationUserDto.setEmail(userDetails.getUsername());
            
            ApplicationUser applicationUser = new ApplicationUser();
            applicationUser.setFirstname(userDetails.getFirstName());
            applicationUser.setLastname(userDetails.getLateName());
            applicationUser.setId(userDetails.getId());
            applicationUser.setEmail(userDetails.getUsername());
            
            this.applicationUser = applicationUser;
            
            return applicationUserDto;
                
        }
		
		return null;
	}

	@Override
	public ApplicationUser getPrincipal() {
		return this.applicationUser;
	}

}
