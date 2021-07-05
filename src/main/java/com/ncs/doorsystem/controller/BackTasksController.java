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

import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.service.BackTasksService;

@RestController
@RequestMapping(path = "/backtask")
public class BackTasksController
{
	@Autowired
	BackTasksService service;
	
	
	@PostMapping(path = "/create",produces = "application/json" )
	public @ResponseBody BackTasksModal createBackTask(@RequestBody BackTasksModal modalObj)
	{
		return service.createBackTask(modalObj);
		
	}
	
	
	@PutMapping(path = "/update",produces = "application/json")
	public @ResponseBody BackTasksModal updateBackTask(@RequestBody BackTasksModal updateModalObj,@RequestParam("taskNo") String taskNo)
	{
		return service.updateBackTask(updateModalObj,taskNo);
		
	}
	
	@DeleteMapping("/delete")
	public int deleteBackTask(@RequestParam("taskNo") long taskNo)
	{
		return service.deleteBackTask(taskNo);
		
	}
	
	@GetMapping(value = "/allbacktasklogs")
	public @ResponseBody List<BackTasksModal> findAll(@RequestParam("deviceid") long deviceid)
	{	
	List<BackTasksModal> list=service.findAll(deviceid);
		
		return list;
		
	}
	
	@GetMapping(value = "/searchdate")
	public @ResponseBody List<BackTasksModal> findAllBydate(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	{	
	List<BackTasksModal> list=service.findAllBydate(startdate,enddate);
		
		return list;
		
	}

}
