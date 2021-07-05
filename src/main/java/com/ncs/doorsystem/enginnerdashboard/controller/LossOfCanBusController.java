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

import com.ncs.doorsystem.enginnerdashboard.entity.LossOfCanBus;
import com.ncs.doorsystem.enginnerdashboard.service.LossOfCanBusService;


@RestController
@RequestMapping("/LossOfCanBus")
public class LossOfCanBusController {
	
	
	@Autowired
	private LossOfCanBusService lossOfCanBusService;

	
	
	@PostMapping("/createdoors")
	public ResponseEntity<LossOfCanBus>createDoors( @RequestBody LossOfCanBus lossOfCanBus,@RequestParam("siteid") long siteid ) {
	try {
		 this.lossOfCanBusService.createDoors(lossOfCanBus,siteid);
			return new ResponseEntity<LossOfCanBus>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<LossOfCanBus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/getdoors")
	public List<LossOfCanBus>getDoors(){		
		
	 return this.lossOfCanBusService.getDoors();
				
	}
	
	@GetMapping("/getdoor")
	public ResponseEntity<LossOfCanBus>getDoor(@RequestParam("id") int doorid) {
		
		try {
			this.lossOfCanBusService.getDoor(doorid);
			return new ResponseEntity<LossOfCanBus>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<LossOfCanBus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@PutMapping("/updatedoor")
	public @ResponseBody LossOfCanBus updateDoor(@RequestBody LossOfCanBus lossOfCanBus,@RequestParam("doorid") int doorid)
	{
		return lossOfCanBusService.updateDoor(lossOfCanBus,doorid);
		
	}
	
	

	@DeleteMapping("/delete")
	public ResponseEntity<LossOfCanBus>deleteDoor(@RequestParam("id") int doorid){
		try {
			this.lossOfCanBusService.deleteDoor(doorid);
			return new ResponseEntity<LossOfCanBus>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<LossOfCanBus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
	
	
