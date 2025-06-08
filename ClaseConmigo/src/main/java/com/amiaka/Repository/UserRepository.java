package com.amiaka.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.ApplicationUser;

public interface UserRepository  extends JpaRepository<ApplicationUser, Long> { 

	Optional<ApplicationUser> findByEmail(String email);

}
