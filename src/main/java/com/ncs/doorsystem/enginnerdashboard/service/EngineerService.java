package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.enginnerdashboard.entity.EngineerEntity;
import com.ncs.doorsystem.enginnerdashboard.repository.EngineeringRepository;

@Service
@Transactional
public class EngineerService {
	
	@Autowired
	EngineeringRepository repo;

	public EngineerEntity createEngineer(EngineerEntity enginner) throws Exception {
		
		EngineerEntity result = repo.findByemployeeID(enginner.getEmployeeID());
		if(result!=null)
		{
			throw new Exception("Engineer  already exists");
		}
		else
		{
			EngineerEntity username = repo.findByuserName(enginner.getUserName());
			EngineerEntity password = repo.findBypassword(enginner.getPassword());
			
			if(username!=null)
			{
				throw new Exception("Engineer  already exists");
			}
			else
			{
				EngineerEntity response = repo.save(enginner);
				if(response!=null)
				{
					return response;
				}
				
			}
			
			
		}
		
		
		return null;
	}

	public List<EngineerEntity> getAllEngineer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public EngineerEntity updateEngineer(EngineerEntity enginner, long id) {
		EngineerEntity oldengineer = repo.findById(id).get();
		if(oldengineer!=null)
		{
			oldengineer.setEmployeeID(enginner.getEmployeeID());
			oldengineer.setEngineerName(enginner.getEngineerName());
			oldengineer.setUserName(enginner.getUserName());
			oldengineer.setPassword(enginner.getPassword());
			oldengineer.setCreatedDate(enginner.getCreatedDate());
			
			EngineerEntity res = repo.save(oldengineer);
			return res;
			
		}
		return null;
	}

	public String deleteEngineer(long id) {
		long res=repo.deleteByengID(id);
		if(res==1)
		{
			return "Engineer deleted successfully";
		}
		return null;
	}

	public EngineerEntity getEngineer(long id) {
		EngineerEntity res = repo.findByengID(id);
		return res;
	}

}
