package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.service.SiteControllerEventsLongsService;

@RestController
@RequestMapping("/sitecontrollereventslogs")
public class SiteControllerEventsLongsController 
{
	@Autowired
	SiteControllerEventsLongsService service;
	
	@PostMapping(path = "/create",produces = "application/json" )
	public @ResponseBody SiteControllerEventsLongsModal createSiteControllerEventsLogs(@RequestBody SiteControllerEventsLongsModal modalObj)
	{
		return service.createSiteControllerEventsLogs(modalObj);
		
	}
	
	
	@PutMapping(path = "/update",produces = "application/json")
	public @ResponseBody SiteControllerEventsLongsModal updateSiteControllerEventsLogs(@RequestBody SiteControllerEventsLongsModal updateModalObj,@RequestParam("srNo") long srNo)
	{
		return service.updateSiteControllerEventsLogs(updateModalObj,srNo);
		
	}
	
	@DeleteMapping("/delete")
	public int deleteSiteControllerEventsLogs(@RequestParam("srNo") long srNo)
	{
		return service.deleteSiteControllerEventsLogs(srNo);
		
	}
	
	@GetMapping(value = "/allsitelogs")
	public @ResponseBody List<SiteControllerEventsLongsModal> findAll(@RequestParam("site") long site)
	{	
	List<SiteControllerEventsLongsModal> list=service.findAll(site);
		
		return list;
		
	}
	
	@GetMapping(value = "/searchdate")
	public @ResponseBody List<SiteControllerEventsLongsModal> findAllBydate(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	{	
	List<SiteControllerEventsLongsModal> list=service.findAllBydate(startdate,enddate);
		
		return list;
		
	}
	

}
