package com.amiaka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String roleName);
	
	

}
