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

import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.service.PersonTagsService;

@RestController
@RequestMapping("/personTags")
public class PersonTagsController 
{
	
	@Autowired
	PersonTagsService service;
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody PersonTagsModal createTags(@RequestBody PersonTagsModal modal ) throws Exception
	{
		
		return service.createTags(modal);
		
	}
	
	@GetMapping(value = "/gettags")
	public @ResponseBody PersonTagsModal findTgas(@RequestParam("id") long id)
	{	
		PersonTagsModal list=service.findTgas(id);
	
		
		return list;
		
	}
	
	@GetMapping(value = "/getall")
	public @ResponseBody List<PersonTagsModal> findAllTags()
	{	
		List<PersonTagsModal> list=service.findAllTags();
	
		
		return list;
		
	}
	
	@PutMapping("/update")
    public @ResponseBody PersonTagsModal   updateDoorGroup(@RequestParam("id") long id, @RequestBody PersonTagsModal updateModal) {
        return service.updateTags(updateModal, id);
    }

}
