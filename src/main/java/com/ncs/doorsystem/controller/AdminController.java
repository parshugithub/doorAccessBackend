package com.ncs.doorsystem.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.AdminLoginModal;
import com.ncs.doorsystem.repository.AdminRepository;
import com.ncs.doorsystem.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	AdminService adminserv;
	
	
	@PostMapping("/register")
	public  String registerAdmin(@RequestBody AdminLoginModal loginModal) throws SQLIntegrityConstraintViolationException
	{
		System.out.println("The method called");
		System.out.println(loginModal.toString());
		AdminLoginModal modal=adminserv.registerAdmin(loginModal);
		if(modal!=null)
		{
			return "ok";
		}
		
		return "Not ok";
		
	}

}
