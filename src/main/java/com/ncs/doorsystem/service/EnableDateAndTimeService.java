package com.ncs.doorsystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.EnableDateAndTime;
import com.ncs.doorsystem.repository.EnableDateAndTimeRepository;

@Service
@Transactional
public class EnableDateAndTimeService
{
	@Autowired
	EnableDateAndTimeRepository repo;

	public EnableDateAndTime createEnableDateAndTime(EnableDateAndTime modal, long custid, long siteid) 
	{
		modal.setCustomerid(custid);
		modal.setSiteid(siteid);
		
		return repo.save(modal);
	}

	public EnableDateAndTime updateEnableDateAndTime(EnableDateAndTime modal, long id) {
		EnableDateAndTime old= repo.findByid(id);
		if(old!=null)
		{
			old.setEnableDateAndTime(modal.getEnableDateAndTime());
			old.setEnableDateAndTimeUK(modal.getEnableDateAndTimeUK());
			old.setEnableDateAndTimeindia(modal.getEnableDateAndTimeindia());
			EnableDateAndTime obj= repo.save(old);
			if(repo.findById(old.getId()).isPresent())
				return obj;
				
			
		}
		
			return modal;
		
	}

	public ResponseEntity<Object> deleteEnableDateAndTime(long id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
		}
		if(repo.findById(id).isPresent())
			return ResponseEntity.unprocessableEntity().body("Failed to delete");
		else return ResponseEntity.ok("Deleted successfully");
		
	}

}
