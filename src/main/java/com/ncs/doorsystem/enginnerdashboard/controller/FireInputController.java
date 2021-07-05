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

import com.ncs.doorsystem.enginnerdashboard.entity.FireInputModel;
import com.ncs.doorsystem.enginnerdashboard.service.FireInputService;



@RestController
@RequestMapping("/fireinput")
public class FireInputController {
	
	@Autowired
	private FireInputService fireInputService;
	
	

	@PostMapping("/createdoors")
	public ResponseEntity<FireInputModel>createDoors( @RequestBody FireInputModel fireInputModel, @RequestParam("siteid") long  siteid ) {
	try {
		 this.fireInputService.createDoors(fireInputModel,siteid);
			return new ResponseEntity<FireInputModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<FireInputModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/getdoors")
	public List<FireInputModel>getDoors(@RequestParam("siteid") int siteid){		
		
	 return this.fireInputService.getDoors();
				
	}
	
	@GetMapping("/getdoor")
	public ResponseEntity<FireInputModel>getDoor(@RequestParam("id") int doorid) {
		
		try {
			this.fireInputService.getDoor(doorid);
			return new ResponseEntity<FireInputModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<FireInputModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@PutMapping("/updatedoor")
	public @ResponseBody FireInputModel updateDoor(@RequestBody FireInputModel fireInputModel,@RequestParam("doorid") int doorid)
	{
		return fireInputService.updateDoor(fireInputModel,doorid);
		
	}
	
	

	@DeleteMapping("/delete")
	public ResponseEntity<FireInputModel>deleteDoor(@RequestParam("id") int doorid){
		try {
			this.fireInputService.deleteDoor(doorid);
			return new ResponseEntity<FireInputModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<FireInputModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
	
	
