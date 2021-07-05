package com.ncs.doorsystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.entity.DoorDescriptionModal;
import com.ncs.doorsystem.entity.DoorManagementModal;
import com.ncs.doorsystem.entity.PersonManagementPersonGroup;
import com.ncs.doorsystem.entity.PersonMangementPersonModal;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.repository.DoorDescriptionRepository;
import com.ncs.doorsystem.repository.DoorManagementRepository;
import com.ncs.doorsystem.repository.PersonManagementGroupRepository;
import com.ncs.doorsystem.repository.PersonManagementRepository;
import com.ncs.doorsystem.repository.ScheduleMainRepository;

@Service
@Transactional
public class DoorManagementService {
	
	@Autowired
	DoorManagementRepository repo;
	
	@Autowired
	PersonManagementGroupRepository pgrouprepo;
	
	@Autowired
	PersonManagementRepository prepo;
	
	@Autowired
	DoorDescriptionRepository descrepo;
	@Autowired
	ScheduleMainRepository schRepo;
	

	public DoorManagementModal createNewDoor(@Valid DoorManagementModal modal, long custid, long siteid) throws Exception 
	{
		System.out.println("object is "+modal.toString());
		
		ArrayList<PersonManagementPersonGroup> persongrouplist = new ArrayList<PersonManagementPersonGroup>();
		ArrayList<PersonMangementPersonModal> personlist = new ArrayList<PersonMangementPersonModal>();
		ArrayList<DoorDescriptionModal> desc = new ArrayList<DoorDescriptionModal>();
		HashSet<ScheduleMainModal> schedule = new HashSet<ScheduleMainModal>();
		
		
		DoorManagementModal oldValues = repo.findbyDoorAndcust(modal.getDoorname(),custid,siteid);
		if(oldValues!=null)
		{
			throw new Exception("Door alreday exists ");
		}
		else
		{
			
		
		for (int i = 0; i < modal.getPersongroup().size(); i++)
		{
			String persongroupid = modal.getPersongroup().get(i).getPersonGroupName();
			System.out.println("the group name is "+persongroupid);
			PersonManagementPersonGroup res = pgrouprepo.findBypersonGroupName(persongroupid);
		//	persongrouplist.add(modal.getPersongroup().get(i));
			System.out.println("the person group res "+res.toString());
			if(res!=null)
			{
				persongrouplist.add(res);
				
			}
				
		}
		
		for (int j = 0; j < modal.getPerson().size(); j++) 
		{
			String personid = modal.getPerson().get(j).getMobileNumber();
			PersonMangementPersonModal res = prepo.findBymobileNumber(personid);
			//personlist.add(modal.getPerson().get(j));
			if(res!=null)
			{
				personlist.add(res);
				
			}
			
		}
		for (int k = 0; k < modal.getDoordesc().size(); k++) 
		{
			long descid = modal.getDoordesc().get(k).getDoorDesId();
			DoorDescriptionModal res = descrepo.findBydoorDesId(descid);
			if(res!=null)
			{
				desc.add(res);
				
			}
			
		}
		for (int l = 0; l < modal.getSchedule().size(); l++) {
			schedule.addAll(modal.getSchedule());

		}

		modal.setCustid(custid);
		modal.setSiteid(siteid);
		modal.setSchedule(schedule);
		modal.setDoordesc(desc);
		modal.setPerson(personlist);
		modal.setPersongroup(persongrouplist);
		DoorManagementModal doorres = repo.save(modal);
		return doorres;
		

		}
		
		//return null;
	}


	public List<DoorManagementModal> getAllDoorsWithSite(long custid, long siteid) {
		List<DoorManagementModal> result = repo.findbyCustAndSite(custid,siteid);
		return result;
	}


	public List<DoorManagementModal> getAllDoors(long custid) {
		List<DoorManagementModal> result = repo.findbyCust(custid);
		return result;
		
	}


	public DoorManagementModal getSingleDoor(long doorid) {
		
		return repo.findById(doorid).get();
	}


	public DoorManagementModal updateDoor(long doorid, DoorManagementModal doorUpdate) {
		DoorManagementModal res = repo.findById(doorid).get();
		
		ArrayList<PersonManagementPersonGroup> persongrouplist = new ArrayList<PersonManagementPersonGroup>();
		ArrayList<PersonMangementPersonModal> personlist = new ArrayList<PersonMangementPersonModal>();
		ArrayList<DoorDescriptionModal> desc = new ArrayList<DoorDescriptionModal>();
		HashSet<ScheduleMainModal> schedule = new HashSet<ScheduleMainModal>();
		if(res!=null)
		{
			for (int i = 0; i < doorUpdate.getPersongroup().size(); i++)
			{
				String persongroupid = doorUpdate.getPersongroup().get(i).getPersonGroupName();
				System.out.println("the group name is "+persongroupid);
				PersonManagementPersonGroup result = pgrouprepo.findBypersonGroupName(persongroupid);
			//	persongrouplist.add(modal.getPersongroup().get(i));
				System.out.println("the person group res "+result.toString());
				if(result!=null)
				{
					persongrouplist.add(result);
					
				}
					
			}
			
			for (int j = 0; j < doorUpdate.getPerson().size(); j++) 
			{
				String personid = doorUpdate.getPerson().get(j).getMobileNumber();
				PersonMangementPersonModal result = prepo.findBymobileNumber(personid);
				//personlist.add(modal.getPerson().get(j));
				if(result!=null)
				{
					personlist.add(result);
					
				}
				
			}
			for (int k = 0; k < doorUpdate.getDoordesc().size(); k++) 
			{
				long descid = doorUpdate.getDoordesc().get(k).getDoorDesId();
				DoorDescriptionModal result = descrepo.findBydoorDesId(descid);
				if(result!=null)
				{
					desc.add(result);
					
				}
				
			}
			for (int l = 0; l < doorUpdate.getSchedule().size(); l++) {
				
				ScheduleMainModal schedule1 = doorUpdate.getSchedule().iterator().next();

				ScheduleMainModal existingschedule = schRepo.findByscheduleId(schedule1.getScheduleId());
				if(existingschedule!=null)
				{
					schedule.add(existingschedule);
					
				}
				

			}
			
			res.setAccessType(doorUpdate.getAccessType());
			res.setCustid(res.getCustid());
			res.setDoordesc(desc);
			res.setDoorname(doorUpdate.getDoorname());
			res.setLocktime(doorUpdate.getLocktime());
			res.setPerson(personlist);
			res.setPersongroup(persongrouplist);
			res.setSchedule(schedule);
			res.setSiteid(res.getSiteid());
			res.setTradecode(doorUpdate.getTradecode());
			DoorManagementModal result = repo.save(res);
			
			return result; 
			
		}
		return null;
	}

}
