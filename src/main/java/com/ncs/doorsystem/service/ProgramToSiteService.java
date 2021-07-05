package com.ncs.doorsystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.doorsystem.entity.ProgramToSite;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.repository.ProgramToSiteRepository;

@Service
@Transactional
public class ProgramToSiteService 
{
	@Autowired
	ProgramToSiteRepository repo;
	

	public ProgramToSite createProgramTosite(ProgramToSite modal) {
		
		ProgramToSite newObj = new ProgramToSite();
		System.out.println("the door are "+modal.getDoors() );
		newObj.setDoors(modal.getDoors());
		newObj.setSiteid(modal.getSiteid());
		newObj.setSiteName(modal.getSiteName());
		newObj.setStaffid(modal.getStaffid());
		newObj.setStaffName(modal.getStaffName());
		//repo.save(newObj);
		return repo.save(newObj);
	}
	
	

}
