package com.profile.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.profile.app.jwtfilter.JwtFilter;
import com.profile.app.security.service.SpringUserService;


@Configuration
public class SecurityConfig{

	@Autowired
	private SpringUserService springUserService;
	
	@Autowired
	private JwtFilter jwtRequestFilter;
	
	@Bean
	protected AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
		
		return authConfig.getAuthenticationManager();		
//		auth.inMemoryAuthentication()
//		.withUser("harry").password(getEncryptPassword().encode("potter"))
//		.authorities("Customer")
//		.and()
//		.withUser("ronald").password(getEncryptPassword().encode("weasely"))
//		.authorities("Merchant");	
	}
	
	@Bean
	public AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(springUserService);
		auth.setPasswordEncoder(getEncryptPassword());
		
		return auth;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authenticationProvider(getAuthProvider());
		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST,"/user/autnenticate").permitAll()
				.antMatchers(HttpMethod.POST, "/user/user").permitAll()
				.antMatchers(HttpMethod.GET,"/user/user").authenticated()
				.antMatchers(HttpMethod.GET,"/user/user/*").authenticated()
				.antMatchers(HttpMethod.GET,"/user/user1/*").permitAll()
				.antMatchers(HttpMethod.PUT,"/user/user/*").authenticated()
				.antMatchers(HttpMethod.DELETE,"/user/user/*").authenticated()
				.antMatchers(HttpMethod.GET,"/user/user/mobileno/*").authenticated()
				.antMatchers(HttpMethod.GET,"/user/user/email/*").authenticated()
				.antMatchers(HttpMethod.GET, "/user/user/login").authenticated()
				.antMatchers(HttpMethod.GET,"/user/user/email1/*").permitAll()
				.anyRequest().permitAll()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	
		return http.build();
		
	}
	
//	 @Bean
//	    public WebSecurityCustomizer webSecurityCustomizer() {
//	        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//	    }
	
	@Bean
	public PasswordEncoder getEncryptPassword() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
