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

import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.StaffAccessAndOptions;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.service.DoorGroupService;

@RestController
@RequestMapping("/doorgroup")
public class DoorGroupController 
{
	@Autowired
	DoorGroupService service;

	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody DoorGroupModal createDoor(@RequestBody DoorGroupModal modal,@RequestParam("custid") long custid, @RequestParam("siteid") long siteid) throws Exception
	{
		
		return service.createDoor(modal,custid,siteid);
		
	}
	
	@GetMapping(value = "/getdoorGroup")
	public @ResponseBody DoorGroupModal findDoorGroups(@RequestParam("doorgroupid") long doorgroupid)
	{	
		DoorGroupModal list=service.findDoorGroups(doorgroupid);
	
		
		return list;
		
	}
	
	@GetMapping(value = "/getall")
	public @ResponseBody List<DoorGroupModal> findAllDoorGroups(@RequestParam("siteid") long siteid,@RequestParam("custid") long custid)
	{	
		List<DoorGroupModal> list=service.findAllDoorGroups(siteid,custid);
	
		
		return list;
		
	}
	
	@PutMapping("/update")
    public @ResponseBody DoorGroupModal   updateDoorGroup(@RequestParam("doorgroupid") long doorgroupid, @RequestBody DoorGroupModal updateModal) {
        return service.updateDoorGroup(updateModal, doorgroupid);
    }
	
	@GetMapping(value = "/getdoorgroupforembedded")
	public @ResponseBody String findDoorGroupForEmbedded(@RequestParam("doorgroupid") long doorgroupid,@RequestParam("siteid") long siteid)
	{	
		String list=service.findDoorGroupForEmbedded(doorgroupid,siteid);
	
		
		return list;
		
	}
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteTrade(@RequestParam("doorgroupid") long doorgroupid) {
	        return service.deleteDoorGroup(doorgroupid);
	    }

	
}
