package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.enginnerdashboard.entity.TotalDoorModal;
import com.ncs.doorsystem.enginnerdashboard.repository.TotalDoorModalRepository;

@Service
public class TotalDoorModalService 
{
	@Autowired
	TotalDoorModalRepository repo;

	public TotalDoorModal createDoors(TotalDoorModal doormodal, long custid, long siteid) {
		
		TotalDoorModal res = repo.findDoor(doormodal.getDoorNo(),siteid);
		if(res!=null)
		{
			res.setCreatedDate(doormodal.getCreatedDate());
			res.setCustomerid(custid);
			res.setDoorDeviceId(doormodal.getDoorDeviceId());
			res.setDoorNo(doormodal.getDoorNo());
			res.setDoorType(doormodal.getDoorType());
			res.setLocktime(doormodal.getLocktime());
			res.setSiteid(siteid);
			TotalDoorModal result = repo.save(res);
			return result;
			
		}
		else
		{
			doormodal.setCustomerid(custid);
			doormodal.setSiteid(siteid);
			TotalDoorModal result = repo.save(doormodal);
			return result;
		}
		
		
	}

	public List<TotalDoorModal> getDoors(long custid, long siteid) {
		List<TotalDoorModal> response = repo.getAllDoors(custid,siteid);
		return response;
	}
	

}
