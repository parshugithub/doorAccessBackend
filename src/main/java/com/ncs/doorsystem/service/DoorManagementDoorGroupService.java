package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.DoorManagementDoorGroupModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.CreateSiteRepository;
import com.ncs.doorsystem.repository.DoorGroupRepository;
import com.ncs.doorsystem.repository.DoorManagementDoorGroupRepository;
import com.ncs.doorsystem.repository.ErrorLogsRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.TotalDoorRepository;

@Service
@Transactional
public class DoorManagementDoorGroupService extends MQTTConfig
{
	
	@Autowired
	DoorManagementDoorGroupRepository doorRepo;
	@Autowired
	ErrorLogsRepository errorRepo;
	@Autowired
	TotalDoorRepository dRepo;
	@Autowired
	BackTasksRepository backTasksRepository;
	@Autowired
	MQTTPublisherBase publisher;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	CreateSiteRepository siterepo;

	
	MQTTSubscriber sub;

	static long sitemodal;

	public DoorManagementDoorGroupModal createDoor(DoorManagementDoorGroupModal modal, long custid, long siteid) throws Exception
	{
		
		List<TotalDoorsModal> doors = new ArrayList<>();
		for (int i = 0; i < modal.getDoors().size(); i++) {
			TotalDoorsModal doorCheck = dRepo.findBydoorName(modal.getDoors().get(i).getDoorName());
			if (doorCheck != null) {
				System.out.println("the doors are " + doorCheck.toString());
				doors.add(doorCheck);
			}

		}
				
		DoorManagementDoorGroupModal res = doorRepo.findDoorGroup(modal.getDoorGroupName(),custid,siteid);
		if(res!=null)
		{
			throw new Exception("DoorGroup is already Exists");
		}
		else
		{
			modal.setDoors(doors);
			modal.setCustid(custid);
			modal.setSiteid(siteid);
			DoorManagementDoorGroupModal savedData = doorRepo.save(modal);

			return savedData;
		}
		
	}

	public DoorManagementDoorGroupModal findDoorGroups(long doorgroupid) {
		DoorManagementDoorGroupModal result = doorRepo.findById(doorgroupid).get();

		return result;
	}

	public List<DoorManagementDoorGroupModal> findAllDoorGroups(long siteid, long custid) {
		List<DoorManagementDoorGroupModal> res = doorRepo.findAllDoorGroups(siteid,custid);
		return res;
	}

	public DoorManagementDoorGroupModal updateDoorGroup(DoorManagementDoorGroupModal updateModal, long doorgroupid) {
		DoorManagementDoorGroupModal checkDoorGroup = doorRepo.findBydgroupid(doorgroupid);
		if (checkDoorGroup != null) {
			List<TotalDoorsModal> doors = new ArrayList<>();
			for (int i = 0; i < updateModal.getDoors().size(); i++) {
				TotalDoorsModal doorCheck = dRepo.findBydoorName(updateModal.getDoors().get(i).getDoorName());
				if (doorCheck != null) {
					doors.add(doorCheck);
				}

			}

			checkDoorGroup.setDoorGroupName(updateModal.getDoorGroupName());
			checkDoorGroup.setCreatedDate(updateModal.getCreatedDate());
			checkDoorGroup.setExpiraydate(updateModal.getExpiraydate());
			checkDoorGroup.setDoors(doors);
			DoorManagementDoorGroupModal savedData = doorRepo.save(checkDoorGroup);
			return savedData;

		}
		return null;

	}

	public String findDoorGroupForEmbedded(long doorgroupid, long siteid) {
		DoorManagementDoorGroupModal result = doorRepo.findBydgroupid(doorgroupid);
		ArrayList<Long> doors = new ArrayList<>();
		List<TotalDoorsModal> doorsRes = result.getDoors();
		CreateSiteModal site = siterepo.findBysiteid(siteid);
		//sub= new MQTTSubscriber();
		int res = sub.online;
		System.out.println("The res"+res);
		for (int i = 0; i < doorsRes.size(); i++) {

			long doorid = doorsRes.get(i).getDoorId();
			doors.add(doorid);
		}
		String doorGroupMqtt = result.getDgroupid() + "_" + doors;

		sitemodal = siteid;
		// sitemodal = siterepo.findBysiteid(siteid);
		// System.out.println("the site modal is "+sitemodal.toString());
//		if (result != null) {
//
//			try {
//				InetAddress address = InetAddress.getByName(this.clientIp);
//				boolean reachable = address.isReachable(1000);
//				System.out.println("the result is " + reachable);
				if (res==1) {
					publisher.publishMessage("doorgroupId", doorGroupMqtt);

					subscriber.subscribeMessage("doorgroupId");
					return "Device is Online";
				} else {
					Calendar cal = Calendar.getInstance();

					System.out.println("The time is    " + cal.getTime());
					Date date = new Date();
					SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
					String stringDate = DateFor.format(date);
					ErrorLogsModal errorLogs = new ErrorLogsModal();
					errorLogs.setDateAndTime(stringDate);
					errorLogs.setErrorType("DoorGroup Open Failed " + Long.toString(doorgroupid));
					errorLogs.setErrorDescription("DoorGroup Open failed");
					errorLogs.setDeviceId(Long.parseLong(site.getDeviceId()));
					;
					errorLogs.setStatus("Door open Failed");
					errorRepo.save(errorLogs);
				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			// subscriber.messageArrived();
//		MqttMessage messageforDoor = new MqttMessage();
//		//messageforDoor.gettpoic
//		String val=new String(messageforDoor.getPayload());
//		System.out.println("the val is"+val);
			return "Device is Offline";
		//}
		

	}

	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub

	}

	public ResponseEntity<Object> deleteDoorGroup(long doorgroupid) {
		if (doorRepo.findById(doorgroupid).isPresent()) {
		//	doorRepo.deleteMappedPerson(doorgroupid);
			doorRepo.deleteMappedDoor(doorgroupid);
			doorRepo.deleteById(doorgroupid);
			if (doorRepo.findById(doorgroupid).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Door group");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified  Door group");
		}
		return null;
	}

	public List<DoorManagementDoorGroupModal> findAllDoorGroupsForCustomer(long custid) {
		List<DoorManagementDoorGroupModal> res = doorRepo.findAllDoorGroupsforCustomer(custid);
		return res;
	}

}
