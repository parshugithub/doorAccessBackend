package com.ncs.doorsystem.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.CreateSiteRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;
import com.ncs.doorsystem.repository.ErrorLogsRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.TotalDoorRepository;

@Service
@Transactional
public class TotalDoorService  extends MQTTConfig
{
	@Autowired
	TotalDoorRepository repo;
	
	@Autowired
	MQTTPublisherBase publisher;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	CreateSiteRepository siterepo;
	
	@Autowired
	DashBoardRepository dashRepo;
	
	MQTTSubscriber sub;
	@Autowired
	ErrorLogsRepository errorRepo;
	@Autowired
	BackTasksRepository backTasksRepository;
	
	static long sitemodal;

	public List<TotalDoorsModal> findAllDoor() {
		return repo.getDoors();
		
	}

	public List<TotalDoorsModal> createDoor(List<TotalDoorsModal> modal) 
	{
//		TotalDoorsModal door = new TotalDoorsModal();
//		Integer doors[]= new Integer[128];
//		List<Integer> hourslist= new ArrayList<>(Arrays.asList(doors));
//		for (int i = 1; i <= doors.length; i++) 
//		{
//			hourslist.add(i);
//			
//		}
		//door.setDoorName(hourslist);
		List<TotalDoorsModal> saved=	repo.saveAll(modal);
		return saved;
	}

	public TotalDoorsModal findDoor(long doorname) 
	{
		//publisher.publishMessage("doorid", Long.toString(doorname));
		return repo.findBydoorName(doorname);
	}

	public String findDoorForEmbedded(long doorname, long siteid) 
	{
		byte[] data = {0};
		
		String message ="OPEN";
		//sub = new MQTTSubscriber();
		int res=sub.online;
		System.out.println("the res "+res);
		
		TotalDoorsModal result = repo.findBydoorName(doorname);
		sitemodal=siteid;
		 CreateSiteModal  site = siterepo.findBysiteid(siteid);
		System.out.println("the site modal is "+site.toString());
//		if(result!=null)
//		{
//			InetAddress address;
//			try {
//				address = InetAddress.getByName(this.clientIp);
//				boolean reachable = address.isReachable(1000);
//				System.out.println("the result is "+reachable);
				if (res==1) {
					System.out.println("if cmg");
					
					
					publisher.publishMessage("doorId", Long.toString(doorname));
					
					subscriber.subscribeMessage("doorId");
					return "Door Open Successful";
				} else {
					
					Calendar cal = Calendar.getInstance();
					
					System.out.println("The time is    " + cal.getTime());
					Date date = new Date();
					SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
					String stringDate = DateFor.format(date);
					ErrorLogsModal errorLogs = new ErrorLogsModal();
					errorLogs.setDateAndTime(stringDate);
					errorLogs.setErrorType("Door Open Failed "+Long.toString(result.getDoorName()));
					errorLogs.setErrorDescription("Door Open failed");
					errorLogs.setDeviceId(Long.parseLong(site.getDeviceId()));
					;
					errorLogs.setStatus("Door open Failed");
					errorRepo.save(errorLogs);
					

				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		
			
		
		
		
//		//subscriber.messageArrived();
//		MqttMessage messageforDoor = new MqttMessage();
//		//messageforDoor.gettpoic
//		String val=new String(messageforDoor.getPayload());
//		System.out.println("the val is"+val);
			return "Device is Offline" ;
		//}
		
		
		//return null;
	}

	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub
		
	}

}
