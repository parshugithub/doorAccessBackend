package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.DoorManagementModal;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.service.DoorManagementService;

@RestController
@RequestMapping("/doormanagement")
public class DoorManagementController 
{
	@Autowired
	DoorManagementService service;
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody DoorManagementModal  createNewDoor(@Valid @RequestBody DoorManagementModal modal,@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		DoorManagementModal result = service.createNewDoor(modal,custid,siteid);
		return result;
		
	}
	
	@GetMapping(value = "/getallwithsite",produces = "application/json")
	public @ResponseBody List<DoorManagementModal> getAllDoorsWithSite(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid)
	{
		
		List<DoorManagementModal> res = service.getAllDoorsWithSite(custid,siteid);
		return res;
		
	}
	
	@GetMapping(value = "/getall",produces = "application/json")
	public @ResponseBody List<DoorManagementModal> getAllDoors(@RequestParam("custid") long custid)
	{
		
		List<DoorManagementModal> res = service.getAllDoors(custid);
		return res;
		
	}
	
	
	@GetMapping(value = "/getsingledoor",produces = "application/json")
	public @ResponseBody DoorManagementModal getSingleDoor(@RequestParam("doorid") long doorid)
	{
		
		DoorManagementModal res = service.getSingleDoor(doorid);
		return res;
		
	}
	
	@PutMapping(value = "/update",produces = "application/json")
	public DoorManagementModal updateDoor(@RequestParam("doorid") long doorid, @RequestBody DoorManagementModal doorUpdate) {
		return service.updateDoor(doorid, doorUpdate);
	}


}
