package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.EnableDateAndTime;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.service.EnableDateAndTimeService;

@RestController
@RequestMapping("/EnableDateAndTime")
public class EnableDateAndTimeContrpller 
{
	@Autowired
	EnableDateAndTimeService service;
	
	@PostMapping("/create")
	public EnableDateAndTime createEnableDateAndTime(@RequestBody EnableDateAndTime modal,@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) {
		return service.createEnableDateAndTime(modal,custid,siteid);
	}
	
	
	@PutMapping("/update")
    public EnableDateAndTime updateEnableDateAndTime(@RequestParam("id") long id, @RequestBody EnableDateAndTime modal) {
        return service.updateEnableDateAndTime(modal, id);
    }
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteEnableDateAndTime(@RequestParam("id") long id) {
	        return service.deleteEnableDateAndTime(id);
	    }

}
