package com.ncs.doorsystem.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.AdminLoginModal;
import com.ncs.doorsystem.repository.AdminRepository;

@Service
public class AdminService 
{
	
	@Autowired
	AdminRepository adminRepo;

	public AdminLoginModal registerAdmin(AdminLoginModal loginModal) throws SQLIntegrityConstraintViolationException
	{
		AdminLoginModal login = adminRepo.findByemail(loginModal.getEmailId());
		if(login !=null)
		{
			return null;
		}
		adminRepo.save(loginModal);
		return loginModal;
		
		// TODO Auto-generated method stub
		
	}

}
