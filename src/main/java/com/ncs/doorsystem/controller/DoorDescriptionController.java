package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.DoorDescriptionModal;
import com.ncs.doorsystem.entity.ResidentModal;
import com.ncs.doorsystem.service.DoorDescriptionService;

@RestController
@RequestMapping("/doordescription")
public class DoorDescriptionController 
{
	@Autowired
	DoorDescriptionService service;
	
	
	
	@GetMapping(value = "/all")
	public @ResponseBody List<DoorDescriptionModal> findAll(@RequestParam("siteid") long siteid)
	{	
	List<DoorDescriptionModal> list=service.findAll(siteid);
		
		return list;
		
	}
	
	@GetMapping(value = "/getdoordesc")
	public @ResponseBody DoorDescriptionModal findOne(@RequestParam("door") long door)
	{	
	DoorDescriptionModal list=service.findOne(door);
		
		return list;
		
	}
	@PostMapping(path="/create", produces = "application/json")
	public ResponseEntity<Object> createDoorDescription(@RequestBody DoorDescriptionModal modal ,@RequestParam("siteid") long siteid) throws Exception
	{
		return service.createDoorDescription(modal,siteid);
		
	}
	
	@PostMapping(path="/createall", produces = "application/json")
	public List<DoorDescriptionModal> createDoorDescriptionAll(@RequestBody List<DoorDescriptionModal> modal ,@RequestParam("siteid") long siteid) throws Exception
	{
		return service.createDoorDescriptionAll(modal,siteid);
		
	}
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deleteDoorDes(@RequestParam("doorDesId") long doorDesId,@RequestParam("siteid") long siteid) {
        return service.deleteDoorDes(doorDesId,siteid);
    }
	
	@DeleteMapping("/deleteall")
    public ResponseEntity<Object> deleteDoorDesAll(@RequestBody List<DoorDescriptionModal> doorDesId,@RequestParam("siteid") long siteid) {
        return service.deleteDoorDesAll(doorDesId,siteid);
    }


	@PutMapping("/update")
	public ResponseEntity<Object> updateDoorDesc(@RequestParam("doorDesId") long doorDesId, @RequestBody DoorDescriptionModal Update) {
		return service.updateDoorDesc(doorDesId, Update);
	}

}
