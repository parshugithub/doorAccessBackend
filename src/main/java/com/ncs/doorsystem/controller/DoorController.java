package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.entity.Door;
import com.ncs.doorsystem.service.Doorservice;

@RestController
@RequestMapping("/door")

public class DoorController
{
	@Autowired
	Doorservice doorservice;
	
	@RequestMapping(path = "/getdoors",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public List<Door> getAllDoors(@RequestParam("custId") long custID)
	{
		List<Door>  doors =doorservice.getAllDoors(custID);
		return doors;
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<Door>  createNewDoor(@RequestBody Door modal,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calling");
		Door doorModal= doorservice.createNewDoor(modal,custid);
		System.out.println("the result is"+doorModal);
		if(doorModal!=null)
		{
			return new ResponseEntity<Door>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<Door>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Door> updateStaffGroup(@RequestBody Door modal,@RequestParam("doorid") long doorid)
	{
		Door doorupdate = doorservice.updateDoor(modal,doorid);
		
		if(doorupdate!=null)
		{
			return new ResponseEntity<Door>(HttpStatus.OK);
		}
		return new ResponseEntity<Door>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/delete")
	public String deleteDoor(@RequestParam("doorid") long doorid) throws Exception
	{
		System.out.println("id "+doorid);
		int result = doorservice.deleteDoor(doorid);
		if(result!=0)
		{
			return "staff group deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	

}
