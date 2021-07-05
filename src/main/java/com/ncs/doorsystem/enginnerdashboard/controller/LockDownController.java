package com.ncs.doorsystem.enginnerdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.enginnerdashboard.entity.LockDownModel;
import com.ncs.doorsystem.enginnerdashboard.service.LockDownService;



@RestController
@RequestMapping("/lockdown")
public class LockDownController {
	
	
	
	@Autowired
	private LockDownService lockDownService;

	
	
	@PostMapping("/createdoors")
	public ResponseEntity<LockDownModel>createDoors( @RequestBody LockDownModel lockDownModel,@RequestParam("siteid") long siteid) {
	try {
		 this.lockDownService.createDoors(lockDownModel,siteid);
			return new ResponseEntity<LockDownModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<LockDownModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/getdoors")
	public List<LockDownModel>getDoors(){		
		
	 return this.lockDownService.getDoors();
				
	}
	
	@GetMapping("/getdoor")
	public ResponseEntity<LockDownModel>getDoor(@RequestParam("id") int doorid) {
		
		try {
			this.lockDownService.getDoor(doorid);
			return new ResponseEntity<LockDownModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<LockDownModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@PutMapping("/updatedoor")
	public @ResponseBody LockDownModel updateDoor(@RequestBody LockDownModel lockDownModel,@RequestParam("doorid") int doorid)
	{
		return lockDownService.updateDoor(lockDownModel,doorid);
		
	}
	
	

	@DeleteMapping("/delete")
	public int deleteDoor(@RequestParam("id") int doorid)
	{
		return lockDownService.deleteDoor(doorid);
		
	}
	
	
}
	
