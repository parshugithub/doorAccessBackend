package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.UserAsVoiceOperator;
import com.ncs.doorsystem.entity.VoiceOperatorModal;
import com.ncs.doorsystem.service.UserVoiceOperatorService;

@RestController
@RequestMapping("/uservoiceoperator")
public class UserVoiceOperatorController 
{
	@Autowired
	UserVoiceOperatorService service;
	
	@GetMapping(value = "/allvoice")
	public @ResponseBody List<UserAsVoiceOperator> getAllVoiceOperators(@RequestParam("custId") long custId)
	{	
	List<UserAsVoiceOperator> list=service.getAllVoiceOperators(custId);
		
		return list;
		
	}
	
	
	
	
	
	@PostMapping(value="/create",produces = "application/json")
	public UserAsVoiceOperator  createVoiceOperator(@Valid @RequestBody UserAsVoiceOperator modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid,@RequestParam("userid") long userid) 
			throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createVoiceOperator(modal,custid,siteid,userid);
		
	}
	

}
