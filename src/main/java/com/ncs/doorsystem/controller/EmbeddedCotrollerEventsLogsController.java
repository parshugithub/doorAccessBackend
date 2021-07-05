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

import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.service.EmbeddedCotrollerEventsLogsService;

@RestController
@RequestMapping("/emeddedcontroller")
public class EmbeddedCotrollerEventsLogsController 
{
	@Autowired
	EmbeddedCotrollerEventsLogsService service;
	
	
	@PostMapping(path = "/create",produces = "application/json" )
	public @ResponseBody EmbeddedCotrollerEventsLogsModal createEmbeddedControllerEvents(@RequestBody EmbeddedCotrollerEventsLogsModal modalObj)
	{
		return service.createEmbeddedControllerEvents(modalObj);
		
	}
	
	
	@PutMapping(path = "/update",produces = "application/json")
	public @ResponseBody EmbeddedCotrollerEventsLogsModal updateEmbeddedControllerEvents(@RequestBody EmbeddedCotrollerEventsLogsModal updateModalObj,@RequestParam("srno") long srno)
	{
		return service.updateEmbeddedControllerEvents(updateModalObj,srno);
		
	}
	
	@DeleteMapping("/delete")
	public int deleteEmbeddedControllerEvents(@RequestParam("srno") long srno)
	{
		return service.deleteEmbeddedControllerEvents(srno);
		
	}
	
	@GetMapping(value = "/allemebeddedlogs")
	public @ResponseBody List<EmbeddedCotrollerEventsLogsModal> findAll(@RequestParam("deviceid") long deviceid)
	{	
	List<EmbeddedCotrollerEventsLogsModal> list=service.findAll(deviceid);
		
		return list;
		
	}
	
	@GetMapping(value = "/searchdate")
	public @ResponseBody List<EmbeddedCotrollerEventsLogsModal> findAllBydate(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	{	
	List<EmbeddedCotrollerEventsLogsModal> list=service.findAllBydate(startdate,enddate);
		
		return list;
		
	}
	

}
