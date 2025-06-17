package com.edu.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig
{
	@Autowired
	public MyAuthFailureHandler myAuthFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception
	{
		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests((request) -> request
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/").permitAll()
					.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
					.requestMatchers("/guest/**").permitAll()
					.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					);
		
		http.formLogin((formLogin) ->
				formLogin.permitAll());
		
		http.logout((logout) -> 
				logout.permitAll());
		
		http.formLogin((formLogin) -> formLogin
				.loginPage("/myLogin.do")
				.loginProcessingUrl("/myLoginAction.do")
//				.failureUrl("/myError.do")
				.failureHandler(myAuthFailureHandler)
				.usernameParameter("my_id")
				.passwordParameter("my_pass")
				.permitAll());
		http.logout((logout) -> logout
				.logoutUrl("/myLogout.do")
				.logoutSuccessUrl("/")
				.permitAll());
		http.exceptionHandling((expHandling) -> expHandling
				.accessDeniedPage("/denied.do"));
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService users() {
//		UserDetails user = User.builder()
//				.username("user")
//				.password(passwordEncoder().encode("1234"))
//				.roles("USER")
//				.build();
//		
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("1234"))
//				.roles("USER", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//	
//	public PasswordEncoder passwordEncoder()
//	{
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select user_id, user_pw, enabled"
					+ " from security_admin where user_id = ?")
			.authoritiesByUsernameQuery("select user_id, authority "
					+ "from security_admin where user_id = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
