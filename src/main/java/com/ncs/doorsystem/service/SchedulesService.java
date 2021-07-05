package com.ncs.doorsystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ncs.doorsystem.entity.SchedulesValuesModal;
import com.ncs.doorsystem.repository.SchedulesRepository;
import com.sun.tools.javac.util.ArrayUtils;

@Service
public class SchedulesService 
{
	@Autowired
	SchedulesRepository srepo;

	public List<Object> findAllHours() {
		
		return srepo.getHours();
	}

	public List<Object> getAllMinutes() {
		// TODO Auto-generated method stub
		return srepo.getMinutes();
	}

	public List<Object> getAllDays() {
		// TODO Auto-generated method stub
		 return srepo.getDays();
	}

	public ResponseEntity<Object> createSchedules() 
	{
		
		SchedulesValuesModal schedules = new SchedulesValuesModal();
		
		String day[]= {"Mo","Tu","We","Th","Fr","Sa","Su"};
			
		List<String> days = new ArrayList<>(Arrays.asList(day));
		System.out.println("The days are  "+days);
		
		Integer hours[]= new Integer[24];
		List<Integer> hourslist= new ArrayList<>(Arrays.asList(hours));
		for (int i = 0; i < hours.length; i++) 
		{
			hourslist.add(i);
			
		}
		
		System.out.println("The hours are  "+hourslist);
	
		
		Integer minutes[]= new Integer[60];
		List<Integer> minuteslist= new ArrayList<>();
//		Integer minutes[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,
//				36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
		for (int i = 0; i < minutes.length; i++) 
		{
			minuteslist.add(i);
			
		}
		
		
		schedules.setDays(days);
		schedules.setHours(hourslist);
		schedules.setMinutes(minuteslist);
		srepo.save(schedules);
		
		
		
		return  ResponseEntity.ok("Scheules Created Successfully");
	}

	public String getDay(String day) 
	{
		
		
		return srepo.getday(day);
	}

	

}
