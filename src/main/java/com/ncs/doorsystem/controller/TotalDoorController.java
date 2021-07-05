package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.service.MQTTSubscriber;
import com.ncs.doorsystem.service.TotalDoorService;

@RestController
@RequestMapping("/doors")
public class TotalDoorController 
{
	@Autowired
	TotalDoorService service;
	
	
	@GetMapping(value = "/alldoor")
	public @ResponseBody List<TotalDoorsModal> findAllDoor()
	{	
	List<TotalDoorsModal> list=service.findAllDoor();
		
		return list;
		
	}
	
	@GetMapping(value = "/getdoor")
	public @ResponseBody TotalDoorsModal findDoor(@RequestParam("door") long doorname)
	{	
	TotalDoorsModal list=service.findDoor(doorname);
	
		
		return list;
		
	}
	
	@GetMapping(value = "/getdoorforembedded")
	public @ResponseBody String findDoorForEmbedded(@RequestParam("door") long doorname,@RequestParam("siteid") long siteid)
	{	
	String list=service.findDoorForEmbedded(doorname,siteid);
	
		
		return list;
		
	}
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody List<TotalDoorsModal> createDoor(@RequestBody List<TotalDoorsModal> modal ) throws Exception
	{
		
		return service.createDoor(modal);
		
	}

}
