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
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.service.ErrorLogsService;

@RestController
@RequestMapping("/errorlogs")
public class ErrorLogsController 
{
	@Autowired
	ErrorLogsService service;
	
	@PostMapping(path = "/create",produces = "application/json" )
	public @ResponseBody ErrorLogsModal createErrorLogs(@RequestBody ErrorLogsModal modalObj)
	{
		return service.createErrorLogs(modalObj);
		
	}
	
	
	@PutMapping(path = "/update",produces = "application/json")
	public @ResponseBody ErrorLogsModal updateErrorLogs(@RequestBody ErrorLogsModal updateModalObj,@RequestParam("srno") long srno)
	{
		return service.updateErrorLogs(updateModalObj,srno);
		
	}
	
	@DeleteMapping("/delete")
	public int deleteErrorLogs(@RequestParam("srno") long srno)
	{
		return service.deleteErrorLogs(srno);
		
	}
	
	@GetMapping(value = "/allerrorlogs")
	public @ResponseBody List<ErrorLogsModal> findAll(@RequestParam("deviceid") long deviceid)
	{	
	List<ErrorLogsModal> list=service.findAll(deviceid);
		
		return list;
		
	}
	
	@GetMapping(value = "/searchdate")
	public @ResponseBody List<ErrorLogsModal> findAllBydate(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	{	
	List<ErrorLogsModal> list=service.findAllBydate(startdate,enddate);
		
		return list;
		
	}
	

}
