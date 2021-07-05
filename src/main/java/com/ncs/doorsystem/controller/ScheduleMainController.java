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

import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.service.ScheduleMainService;

@RestController
@RequestMapping("/schedulemain")
public class ScheduleMainController
{
	@Autowired
	ScheduleMainService service;
	
	
	@GetMapping("/all")
	public @ResponseBody List<ScheduleMainModal> getAllSchedules(@RequestParam("custId") long custId,@RequestParam("siteid") long siteid)
	{
		List<ScheduleMainModal> getschedule =  service.getAllSchedules(custId,siteid);
		
		return getschedule;

	}
	@GetMapping("/getSchedule")
	public @ResponseBody ScheduleMainModal getSchedules(@RequestParam("scheduleId") long scheduleId)
	{
	ScheduleMainModal getschedule =  service.getSchedules(scheduleId);
		
		return getschedule;

	}

	@PostMapping("/create")
	public @ResponseBody ScheduleMainModal createSchedule(@RequestBody ScheduleMainModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid,@RequestParam("scheduleid") long scheduleid) 
	{
		System.out.println("request is "+modal.toString());
		return service.createSchedule(modal,custid,siteid,scheduleid);
	}
	
	@PutMapping("/update")
    public ResponseEntity<Object> updateSchedule(@RequestParam("scheduleId") long scheduleId, @RequestBody ScheduleMainModal modal) {
        return service.updateSchedule(modal, scheduleId);
    }
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteSchedule(@RequestParam("scheduleId") long scheduleId) {
	        return service.deleteSchedule(scheduleId);
	    }
	 
	 @GetMapping("/staffall")
		public @ResponseBody List<ScheduleMainModal> getAllSchedulesForStaff(@RequestParam("custId") long custId)
		{
			List<ScheduleMainModal> getschedule =  service.getAllSchedulesForStaff(custId);

			return getschedule;

		}

}
