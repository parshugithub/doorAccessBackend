package com.ncs.doorsystem.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@ComponentScan({"com.ncs.doorsystem.controller","com.ncs.doorsystem.enginnerdashboard.controller"})
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().
		disable()
		
		.authorizeRequests()
		//.antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/login","/register","/usermanagemet/allusers","/dashboard/allsites","/usermanagemet/createuser","/usermanagemet/getuser","/customerprofile/create","/site/create"
				,"/usermanagemet/updateUser","/usermanagemet/deleteuser","/dashboard/createsite","/dashboard/search ","/dashboard/updateSite","/dashboard/deletesite","/dashboard/getsite",
				"/staff/createStaff","/createStaff/create","/createStaff/allSatff","/staff/delete","/staffManagement/staff/create","/staffgroup/group/create","/staffgroup/group/create","/staffManagement/staff/details","/staffManagement/staff/all","/**",
				"/staffmanagement/createStaff/all","/staffmanagement/createStaff/create","/staffmanagement/createStaff/update","/staffmanagement/createStaff/delete","/staffmanagement/createstaffgroup/all",
				"/staffmanagement/createstaffgroup/create","/staffmanagement/createstaffgroup/delete","/staffmanagement/createstaffgroup/update","/staffmanagement/createstaffgroup/allstaffs","/tag/getHexavaluesfor",
				"/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		http.cors();
		http.headers()
		.addHeaderWriter(
                new StaticHeadersWriter("Access-Control-Allow-Origin '*'", "http://213.171.211.57/doorentrysystem")
        );
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
	}
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Collections.singletonList("*")); // Provide list of origins if you want multiple origins
	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Access-Control-Allow-Headers", "X-Requested-With", "Authorization"));
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
	    config.setAllowCredentials(true);
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
