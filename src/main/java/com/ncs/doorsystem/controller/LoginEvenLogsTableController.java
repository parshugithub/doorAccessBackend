package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.LoginEvenLogsTable;
import com.ncs.doorsystem.entity.TagModal;
import com.ncs.doorsystem.service.LoginEvenLogsTableUserService;



@RestController
@RequestMapping("/eventslogs")
public class LoginEvenLogsTableController 
{
	@Autowired
	LoginEvenLogsTableUserService service;
	
	@GetMapping(value = "/all")
	public @ResponseBody List<LoginEvenLogsTable> getAllLogs(@RequestParam("custid") long custid,@RequestParam("username") String username)
	{	
		List<LoginEvenLogsTable> list = service.getAllLogsfor(custid,username);
		return list;
	}
	
	
	@GetMapping(value = "/geteventslogs")
	public @ResponseBody LoginEvenLogsTable findWErrorLog(@RequestParam("loginid") long loginid)
	{	
		LoginEvenLogsTable list=service.findWErrorLog(loginid);
		
		return list;
		
	}
	@GetMapping(value = "/searchdate")
	public @ResponseBody List<LoginEvenLogsTable> findAllBydate(@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	{	
	List<LoginEvenLogsTable> list=service.findAllBydate(startdate,enddate);
		
		return list;
		
	}
	

}
