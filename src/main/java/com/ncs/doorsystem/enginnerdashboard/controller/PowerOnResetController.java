package com.ncs.doorsystem.enginnerdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ncs.doorsystem.enginnerdashboard.entity.PowerOnRestDoorModel;




@RestController
@RequestMapping("/poweronreset")

public class PowerOnResetController {
	
	
	@Autowired
	private com.ncs.doorsystem.enginnerdashboard.service.PowerOnResetService PowerOnResetService;

	
	
	@PostMapping("/createdoors")
	public ResponseEntity<PowerOnRestDoorModel>createDoors( @RequestBody PowerOnRestDoorModel powerOnRestDoorModel,@RequestParam("siteid") long siteid)
	{
		PowerOnRestDoorModel response = PowerOnResetService.createDoors(powerOnRestDoorModel,siteid);
		if(response!=null)
		{
			return new ResponseEntity<PowerOnRestDoorModel>(HttpStatus.OK);
		}
		else
		{
			return null;
		}
	
	}
		
	@GetMapping("/getdoors")
	public List<PowerOnRestDoorModel>getDoors(){		
		
	 return this.PowerOnResetService.getDoors();
				
	}
	
	@GetMapping("/getdoor")
	public ResponseEntity<PowerOnRestDoorModel>getDoor(@RequestParam("id") int doorid) {
		
		try {
			this.PowerOnResetService.getDoor(doorid);
			return new ResponseEntity<PowerOnRestDoorModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<PowerOnRestDoorModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatedoor")
	public @ResponseBody PowerOnRestDoorModel updateDoor(@RequestBody PowerOnRestDoorModel powerOnRestDoorModel,@RequestParam("doorid") int doorid)
	{
		return PowerOnResetService.updateDoor(powerOnRestDoorModel,doorid);
		
	}
	
	
	
	
	
	@DeleteMapping("/delete/")
	public ResponseEntity<PowerOnRestDoorModel>deleteDoor(@RequestParam("id") int doorid){
		try {
			this.PowerOnResetService.deleteDoor(doorid);
			return new ResponseEntity<PowerOnRestDoorModel>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<PowerOnRestDoorModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
	
	

