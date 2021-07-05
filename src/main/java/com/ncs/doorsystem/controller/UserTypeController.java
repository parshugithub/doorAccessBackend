package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.UserTypeModal;
import com.ncs.doorsystem.service.UserTypeService;

@RestController
@RequestMapping(value = "/get")
public class UserTypeController 
{
	
	@Autowired
	UserTypeService userTypeservice;
	
	@GetMapping(value = "/getAllUserTypes")
	public @ResponseBody List<UserTypeModal> getAllUSerType()
	{
		
		List<UserTypeModal> userTypeModalList = userTypeservice.getAllUserTypes();
		System.out.println(userTypeModalList);
		
		return userTypeModalList;
		
		
	}
	

}
