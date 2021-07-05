package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.ResidentModal;
import com.ncs.doorsystem.entity.VoiceOperatorModal;
import com.ncs.doorsystem.service.VoiceOperatorService;

@RestController
@RequestMapping("/voiceoperator")
public class VoiceOperatorController 
{
	@Autowired
	VoiceOperatorService service;
	
	@GetMapping(value = "/allvoice")
	public @ResponseBody List<CreateUserModal> getAllVoiceOperators(@RequestParam("custId") long custId)
	{	
	List<CreateUserModal> list=service.getAllVoiceOperators(custId);
		
		return list;
		
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public String  createVoiceOperator(@Valid @RequestBody VoiceOperatorModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createVoiceOperator(modal,custid,siteid);
		
	}
	

}
