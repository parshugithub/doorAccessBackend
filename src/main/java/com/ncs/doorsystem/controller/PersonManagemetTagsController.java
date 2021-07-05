package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.PersonManagementTags;
import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.service.PersonManagementTagsService;
import com.ncs.doorsystem.service.PersonTagsService;

@RestController
@RequestMapping("/personmanagmenttags")
public class PersonManagemetTagsController
{
	
	@Autowired
	PersonManagementTagsService service;
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody PersonManagementTags createTags(@RequestBody PersonManagementTags modal ) throws Exception
	{
		
		return service.createTags(modal);
		
	}
	
	@GetMapping(value = "/gettags")
	public @ResponseBody PersonManagementTags findTgas(@RequestParam("id") long id)
	{	
		PersonManagementTags list=service.findTgas(id);
	
		
		return list;
		
	}
	
	@GetMapping(value = "/getall")
	public @ResponseBody List<PersonManagementTags> findAllTags()
	{	
		List<PersonManagementTags> list=service.findAllTags();
	
		
		return list;
		
	}
	
	@PutMapping("/update")
    public @ResponseBody PersonManagementTags   updateDoorGroup(@RequestParam("id") long id, @RequestBody PersonManagementTags updateModal) {
        return service.updateTags(updateModal, id);
    }


}
