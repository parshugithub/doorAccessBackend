package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.enginnerdashboard.entity.FireInputModel;
import com.ncs.doorsystem.enginnerdashboard.repository.FireInputRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;



@Service
public class FireInputService {
	


	@Autowired
	private FireInputRepository fireInputRepository;
	@Autowired 
	MQTTPublisherBase publish;
	@Autowired
	MQTTSubscriberBase subscribe;
	
	
	
	
 public FireInputService() {
		

	}
	
		
	public List<FireInputModel> getDoors(){		
		return fireInputRepository.findAll();
	}
	
	
	public FireInputModel getDoor(int doorid) {
		return fireInputRepository.findById(doorid).get();
	}
	
	public void deleteDoor(int doorid) {
		
		FireInputModel entity= fireInputRepository.getOne(doorid);
		fireInputRepository.delete(entity);
		
	}
	
	
	

	public FireInputModel createDoors(FireInputModel fireInputModel, long siteid ) {
		
		
		FireInputModel lobj=fireInputRepository.findByactivatedondoor(fireInputModel.getActivatedondoor() );
		if(lobj!=null)
		{
			lobj.setActivatedondoor(fireInputModel.getActivatedondoor());
			lobj.setLockrelay1(fireInputModel.getLockrelay1());
			lobj.setLockrelay2(fireInputModel.getLockrelay2());
			lobj.setSiteid(siteid);
			
			FireInputModel updatedObj= fireInputRepository.save(lobj);
			String fireInput = updatedObj.getSiteid()+"_"+updatedObj.getActivatedondoor()+"_"+updatedObj.getLockrelay1()+"_"+updatedObj.getLockrelay2();
			publish.publishMessage("fire_input", fireInput);
			subscribe.subscribeMessage("fire_input");
			return updatedObj;
		}
		
		fireInputModel.setSiteid(siteid);
		fireInputRepository.save(fireInputModel);
		String fireInput = fireInputModel.getSiteid()+"_"+fireInputModel.getActivatedondoor()+"_"+fireInputModel.getLockrelay1()+"_"+fireInputModel.getLockrelay2();
		publish.publishMessage("fire_input", fireInput);
		subscribe.subscribeMessage("fire_input");
		return fireInputModel;
	}
		
		
		
		
		
//		fireInputRepository.save(fireInputModel);
//		return fireInputModel;
//		
//	}
	
	
	
	
	public FireInputModel updateDoor(FireInputModel fireInputModel, int doorid) {
		
		FireInputModel lobj=fireInputRepository.findBydoorid(doorid);
		if(lobj!=null)
		{
			lobj.setActivatedondoor(fireInputModel.getActivatedondoor());
			lobj.setLockrelay1(fireInputModel.getLockrelay1());
			lobj.setLockrelay2(fireInputModel.getLockrelay2());
		
			
			FireInputModel updatedObj= fireInputRepository.save(lobj);
			return updatedObj;
		}
		
		
		return null;
	}
	
	
}
