package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerSiteModal;
import com.ncs.doorsystem.enginnerdashboard.entity.TotalDoorModal;
import com.ncs.doorsystem.enginnerdashboard.repository.CustomerSiteRepository;

import com.ncs.doorsystem.enginnerdashboard.repository.TotalDoorSiteRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;

@Service
@Transactional
public class CustomerSiteService 
{
	@Autowired
	CustomerSiteRepository repo;
	@Autowired 
	TotalDoorSiteRepository doorRepo;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	MQTTPublisherBase publisher;
	public CustomerSiteModal createCustomerSite(CustomerSiteModal sitemodal, long custid) throws Exception
	{
		CustomerSiteModal siteres = repo.findbyDeviceidandcustid(sitemodal.getDeviceID(),custid);
		if(siteres!=null)
		{
			throw new Exception("site With device id already present");
		}
		else {
//			List<TotalDoorModal> doors = new ArrayList<>();
////			List<TotalDoorModal> doormodal = sitemodal.getDoors();
//			for (int i = 0; i < doormodal.size(); i++) 
//			{
//				TotalDoorModal doorResponse = doorRepo.findyDoorDeviceId(doormodal.get(i).getDoorDeviceId(),
//						doormodal.get(i).getDoorNo());
////				
//				if(doorResponse!=null)
//				{
//					doormodal.get(i).setCustomerid(custid);
//					doors.addAll(doormodal);
//					
//				}
//				
//				
//			}
//			
			sitemodal.setCustomerid(custid);
			
			
			//List<TotalDoorModal> res=	doorRepo.saveAll(doors);
			
			CustomerSiteModal result=	repo.save(sitemodal);
			//System.out.println("the doors are "+res.toString());
//			String siteMqtt = result.getSiteid()+"_"+result.getSiteName()+"_"+result.getDeviceID()+"_"+result.getDoors();
//			System.out.println("the mqtt response is "+siteMqtt.toString());
//			
//			publisher.publishMessage("SITE", siteMqtt);
//			subscriber.subscribeMessage("SITE");
			return result;
			
		//}
		}
		
		
		
		
		
	}
	public List<CustomerSiteModal> getSites(long custid) {
		List<CustomerSiteModal> res = repo.findBycustomerid(custid);
		return res;
	}
	public String sendMQTT(long custid, long siteid) {
		CustomerSiteModal res = repo.findBysiteid(siteid);
		
		List<TotalDoorModal> doors = doorRepo.findDoor(custid,siteid);
		
		String siteMqtt = res.getSiteid()+"_"+res.getSiteName()+"_"+res.getDeviceID()+"_"+doors.toString();
		System.out.println("the mqtt response is "+siteMqtt.toString());
		
		publisher.publishMessage("SITE", siteMqtt);
		subscriber.subscribeMessage("SITE");
		return "Site Information shared successfully";
	}

}
