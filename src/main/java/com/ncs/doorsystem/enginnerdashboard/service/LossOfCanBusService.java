package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.enginnerdashboard.entity.LossOfCanBus;
import com.ncs.doorsystem.enginnerdashboard.repository.LossOfCanBusRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;



@Service
public class LossOfCanBusService {
	
	
	@Autowired 
	MQTTPublisherBase publish;
	@Autowired
	MQTTSubscriberBase subscribe;
	


	@Autowired
	private LossOfCanBusRepository lossOfCanBusRepository;
	
	
	
	public LossOfCanBusService() {
		
	}
	public List<LossOfCanBus> getDoors(){		
		return lossOfCanBusRepository.findAll();
	}
	
	
	public LossOfCanBus getDoor(int doorid) {
		return lossOfCanBusRepository.findById(doorid).get();
	}
	
	public void deleteDoor(int doorid) {
		
		LossOfCanBus entity= lossOfCanBusRepository.getOne(doorid);
		lossOfCanBusRepository.delete(entity);
		
	}
	
	
	

	public LossOfCanBus createDoors(LossOfCanBus lossOfCanBus,long siteid) {
		
		LossOfCanBus lobj=lossOfCanBusRepository.findByactivatedondoor(lossOfCanBus.getActivatedondoor() );
		if(lobj!=null)
		{
			lobj.setActivatedondoor(lossOfCanBus.getActivatedondoor());
			lobj.setLockrelay1(lossOfCanBus.getLockrelay1());
			lobj.setLockrelay2(lossOfCanBus.getLockrelay2());
			lobj.setSiteid(siteid);
			
			LossOfCanBus updatedObj= lossOfCanBusRepository.save(lobj);
			String fireInput =updatedObj.getSiteid()+"_"+ updatedObj.getActivatedondoor()+"_"+updatedObj.getLockrelay1()+"_"+updatedObj.getLockrelay2();
			publish.publishMessage("can_bus", fireInput);
			subscribe.subscribeMessage("can_bus");
			return updatedObj;
		}
		lossOfCanBus.setSiteid(siteid);
		lossOfCanBusRepository.save(lossOfCanBus);
		String fireInput = lossOfCanBus.getSiteid()+"_"+ lossOfCanBus.getActivatedondoor()+"_"+lossOfCanBus.getLockrelay1()+"_"+lossOfCanBus.getLockrelay2();
		publish.publishMessage("can_bus", fireInput);
		subscribe.subscribeMessage("can_bus");
		return lossOfCanBus;
	}
	
	
	
	
	public LossOfCanBus updateDoor(LossOfCanBus lossOfCanBus, int doorid) {
		
		LossOfCanBus lobj=lossOfCanBusRepository.findBydoorid	(doorid);
		if(lobj!=null)
		{
			lobj.setActivatedondoor(lossOfCanBus.getActivatedondoor());
			lobj.setLockrelay1(lossOfCanBus.getLockrelay1());
			lobj.setLockrelay2(lossOfCanBus.getLockrelay2());
		
			
			LossOfCanBus updatedObj= lossOfCanBusRepository.save(lobj);
			return updatedObj;
		}
		
		
		return null;
	}
	
	
}
