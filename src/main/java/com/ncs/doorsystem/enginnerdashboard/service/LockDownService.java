package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.enginnerdashboard.entity.LockDownModel;
import com.ncs.doorsystem.enginnerdashboard.repository.LockdownRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;



@Service
public class LockDownService {
	
	@Autowired 
	MQTTPublisherBase publish;
	@Autowired
	MQTTSubscriberBase subscribe;
	

	@Autowired
	private LockdownRepository lockdownRepository;
	
	
	
	public LockDownService() {
		

	}
	
		
	public List<LockDownModel> getDoors(){		
		return lockdownRepository.findAll();
	}
	
	
	public LockDownModel getDoor(int doorid) {
		return lockdownRepository.findById(doorid).get();
	}
	
	public int deleteDoor(int doorid) 
	{
		if(lockdownRepository.findById(doorid).isPresent())
		{
			lockdownRepository.deleteById(doorid);
			return 1;
			
		}
		return 0;
	}
	
	
	public LockDownModel createDoors(LockDownModel lockDownModel,long siteid) {
		

		LockDownModel lobj=lockdownRepository.findByactivatedondoor(lockDownModel.getActivatedondoor() );
		if(lobj!=null)
		{
			lobj.setActivatedondoor(lockDownModel.getActivatedondoor());
			lobj.setLockrelay1(lockDownModel.getLockrelay1());
			lobj.setLockrelay2(lockDownModel.getLockrelay2());
			lobj.setSiteid(siteid);
		
			
			LockDownModel updatedObj= lockdownRepository.save(lobj);
			String fireInput = updatedObj.getSiteid()+"_"+updatedObj.getActivatedondoor()+"_"+updatedObj.getLockrelay1()+"_"+updatedObj.getLockrelay2();
			publish.publishMessage("lock_down", fireInput);
			subscribe.subscribeMessage("lock_down");
			return updatedObj;
		}
		lockDownModel.setSiteid(siteid);
		lockdownRepository.save(lockDownModel);
		String fireInput = lockDownModel.getSiteid()+"_"+lockDownModel.getActivatedondoor()+"_"+lockDownModel.getLockrelay1()+"_"+lockDownModel.getLockrelay2();
		publish.publishMessage("lock_down", fireInput);
		subscribe.subscribeMessage("lock_down");
		return lockDownModel ;
	}
	
	
	
	public LockDownModel updateDoor(LockDownModel lockDownModel, int doorid) {
		
		LockDownModel lobj=lockdownRepository.findBydoorid	(doorid);
		if(lobj!=null)
		{
			lobj.setActivatedondoor(lockDownModel.getActivatedondoor());
			lobj.setLockrelay1(lockDownModel.getLockrelay1());
			lobj.setLockrelay2(lockDownModel.getLockrelay2());
		
			
			LockDownModel updatedObj= lockdownRepository.save(lobj);
			return updatedObj;
		}
		
		
		return null;
	}
	
	
}
