package com.ncs.doorsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.Days;
import com.ncs.doorsystem.repository.DaysRepository;

@Service
public class DaysService 
{
	@Autowired
	DaysRepository repo;

	public Days createDoor(Days modal) {
		// TODO Auto-generated method stub
		return repo.save(modal);
	}

	public Days findDay(String day)
	{
		return repo.getday(day);
		// TODO Auto-generated method stub
		
	}

}
