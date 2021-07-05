package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.ProgramToSite;
import com.ncs.doorsystem.service.ProgramToSiteService;

@RestController
@RequestMapping("/programtosiet")
public class ProgramToSiteController 
{

	@Autowired
	ProgramToSiteService service;
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody ProgramToSite createProgramTosite(@RequestBody ProgramToSite modal ) throws Exception
	{
		//service.createProgramTosite(newObj);
		return service.createProgramTosite(modal);
		
	}
}
