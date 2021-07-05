package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.PersonManagementPersonGroup;
import com.ncs.doorsystem.service.PersonGroupService;
import com.ncs.doorsystem.service.PersonMangementPersonGroupService;

@RestController
@RequestMapping("personmangementgroup")
public class PersonMangementPersonGroupController 
{
	@Autowired
	PersonMangementPersonGroupService service;
	
	@GetMapping(path = "/getall",produces = "application/json")
	public List<PersonManagementPersonGroup> getAllPersonGroups(@RequestParam("custid") long custid)
	{
		List<PersonManagementPersonGroup>response = service.getAllPersonGroups(custid);
		
		return response;
		
	}
	
	
	@GetMapping(path = "/getallwithSite",produces = "application/json")
	public List<PersonManagementPersonGroup> getAllPersonGroupsForSite(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid)
	{
		List<PersonManagementPersonGroup>response = service.getAllPersonGroupsForSite(custid,siteid);
		
		return response;
		
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public PersonManagementPersonGroup  createNewPersonGroup(@Valid @RequestBody PersonManagementPersonGroup modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createNewPersonGroup(modal,custid,siteid);
		
	}
	
	@GetMapping("/details")
    public PersonManagementPersonGroup getPersonGroup(@RequestParam("persongroupid") long persongroupid) 
	{
		PersonManagementPersonGroup res=service.getPersonGroup(persongroupid);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deletePersonGroup(@RequestParam("persongroupid") long persongroupid) {
        return service.deletePersonGroup(persongroupid);
    }


	@PutMapping("/update")
	public PersonManagementPersonGroup updatePersonGroup(@RequestParam("persongroupid") long persongroupid, @RequestBody PersonManagementPersonGroup update) {
		return service.updatePersonGroup(persongroupid, update);
	}



}
