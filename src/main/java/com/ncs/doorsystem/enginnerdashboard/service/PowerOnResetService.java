package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.enginnerdashboard.entity.PowerOnRestDoorModel;
import com.ncs.doorsystem.enginnerdashboard.repository.PowerOnResetRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;




@Service
public class PowerOnResetService {
	
	@Autowired 
	MQTTPublisherBase publish;
	@Autowired
	MQTTSubscriberBase subscribe;
	
	@Autowired
	private PowerOnResetRepository powerOnResetRepository;
	
	
	
	public PowerOnResetService() {
		

	}	
	public List<PowerOnRestDoorModel> getDoors(){		
		return powerOnResetRepository.findAll();
	}
	
	
	public PowerOnRestDoorModel getDoor(int doorid) {
		return powerOnResetRepository.findById(doorid).get();
	}
	
	public void deleteDoor(int doorid) {
		
		PowerOnRestDoorModel entity= powerOnResetRepository.getOne(doorid);
		powerOnResetRepository.delete(entity);
		
	}
	
	public PowerOnRestDoorModel createDoors(PowerOnRestDoorModel powerOnRestDoorModel,long siteid) {
		PowerOnRestDoorModel lobj=powerOnResetRepository.findByactivatedondoor(powerOnRestDoorModel.getActivatedondoor() );
		if(lobj!=null)
		{
			lobj.setActivatedondoor(powerOnRestDoorModel.getActivatedondoor());
			lobj.setLockrelay1(powerOnRestDoorModel.getLockrelay1());
			lobj.setLockrelay2(powerOnRestDoorModel.getLockrelay2());
			lobj.setSiteid(siteid);
			
			PowerOnRestDoorModel updatedObj= powerOnResetRepository.save(lobj);
			
			String powerOnResetMsg =updatedObj.getSiteid()+"_"+ updatedObj.getActivatedondoor()+"_"+updatedObj.getLockrelay1()+"_"+updatedObj.getLockrelay2();
			publish.publishMessage("reset", powerOnResetMsg);
			subscribe.subscribeMessage("reset");
			return updatedObj;
		}
		powerOnRestDoorModel.setSiteid(siteid);
		powerOnResetRepository.save(powerOnRestDoorModel);
		String powerOnResetMsg = powerOnRestDoorModel.getSiteid()+"_"+powerOnRestDoorModel.getActivatedondoor()+"_"+powerOnRestDoorModel.getLockrelay1()+"_"+powerOnRestDoorModel.getLockrelay2();
		publish.publishMessage("reset", powerOnResetMsg);
		subscribe.subscribeMessage("reset");
		return powerOnRestDoorModel;
	}
	
	
	
	
	
public PowerOnRestDoorModel updateDoor(PowerOnRestDoorModel powerOnRestDoorModel, int doorid) {
		
	PowerOnRestDoorModel Pobj=powerOnResetRepository.findBydoorid(doorid);
		if(Pobj!=null)
		{
			Pobj.setActivatedondoor(powerOnRestDoorModel.getActivatedondoor());
			Pobj.setLockrelay1(powerOnRestDoorModel.getLockrelay1());
			Pobj.setLockrelay2(powerOnRestDoorModel.getLockrelay2());
		
			
			PowerOnRestDoorModel updatedObj= powerOnResetRepository.save(Pobj);
			return updatedObj;
		}
		
		
		return null;
	}
	
	
}

