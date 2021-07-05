package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.Door;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.DoorRepository;

@Transactional
@Service
public class Doorservice 
{
	@Autowired
	DoorRepository doorRepo;
	
	@Autowired
	CustomerRepository customerrepo;

	public List<Door> getAllDoors(long custID) {
		// TODO Auto-generated method stub
		return doorRepo.findBycustomerid(custID);
	}

	public Door createNewDoor(Door modal, long custid) throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("fsdfsd "+formatter.format(date));  
		System.out.println("service calling");
		
		//StaffFGroupModal grp = new StaffFGroupModal((List<StaffManagementModal>) modal);
		System.out.println("the response is"+modal);
		
		Door doorMoadl = doorRepo.findBydoorName(modal.getDoorName());
		Customer customerName= customerrepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if(doorMoadl!=null)
		{
			throw new  Exception("The door with "+doorMoadl.getDoorName()+" already exists");

		}
		
		modal.setCustomerid(custid);
		
		doorRepo.save(modal);
		//staffGroupRepo.save(grp);
		return modal;
	}

	public Door updateDoor(Door modal, long doorid) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("The id is "+modal.getDoorid());
		Door  existingDoor = doorRepo.findBydoorid(doorid);
		//	StaffManagementModal  existingStaffRes = staffRepo.findByI

		if(existingDoor!=null)
		{
			System.out.println("The door is"+existingDoor.getDoorid());

			//			existingStaffRes.setFirstname(staffModal.get());
			//			existingStaffRes.setLastname(staffModal.getLastname());
			//			existingStaffRes.setPayrollno(staffModal.getPayrollno());
			//			existingStaffRes.setExpiraydate(new Date(calendar.getTime().getTime()));
			existingDoor.setDoorName(modal.getDoorName());
			Door updateDoorRes = doorRepo.save(existingDoor);
			return updateDoorRes;
		}
		return null;



	}

	public int deleteDoor(long doorid) {
		int value=0;
		Door doorDelete = doorRepo.findBydoorid(doorid);
		//System.out.println("The data is "+ userdelete.toString());
		if(doorDelete!=null)
		{
			System.out.println("entering");
			value= value+doorRepo.deleteBydoorid(doorid);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;



	}

}
