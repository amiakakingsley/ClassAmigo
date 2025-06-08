package com.amiaka.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
    private final CustomAccessDeniedHandler customAccessDenielHandler;
    
	public SecurityConfiguration(CustomAccessDeniedHandler customAccessDenielHandler) {
		super();
		this.customAccessDenielHandler = customAccessDenielHandler;
	}

	private final String authorisedUrl [] = {"/existingUser", "/login/**", "/register/**", "/changeNewPassword"};
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authManager(UserDetailsService userdetails) {
		 DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		 daoProvider.setUserDetailsService(userdetails);
		 return new ProviderManager(daoProvider);
	}
	
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		return  http.authorizeHttpRequests(auth -> auth
				.requestMatchers(authorisedUrl).permitAll()
				.requestMatchers("/tutor/**").hasRole("TUTOR")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				
				)
				.csrf(AbstractHttpConfigurer::disable)
				.formLogin(form -> form
						.loginPage("/login")
						.failureUrl("/error")
						.loginProcessingUrl("/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/user/home")
						)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.logoutSuccessUrl("/login")
						)
				.exceptionHandling(exceptionHandling -> exceptionHandling
		                .accessDeniedHandler(customAccessDenielHandler)).
		                
				build();
	}
	
	
}
