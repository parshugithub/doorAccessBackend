package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.StaffGroupManagementModal;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.StaffGroupManagementRepository;
import com.ncs.doorsystem.repository.StaffManagementRepository;

@Service
@Transactional
public class StaffGroupManagementService 
{
	@Autowired
	StaffGroupManagementRepository staffGroupRepo;
	
	@Autowired
	
	CustomerRepository customerRepo;
	
	@Autowired
	StaffManagementRepository satffManRepo;

	
	public StaffGroupManagementModal createNewStaffgroup(StaffGroupManagementModal staffGroup, long custid) throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		
		
		
	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("fsdfsd "+formatter.format(date));  
		System.out.println("service calling");
		
		System.out.println("the response is"+staffGroup);
		
		System.out.println("the staff response is "+staffGroup.getStaff());
		
		
		StaffGroupManagementModal staffGroupMoadl = staffGroupRepo.findBystaffGroupName(staffGroup.getStaffGroupName());
		Customer customerName= customerRepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if(staffGroupMoadl!=null)
		{
			throw new  Exception("The Staffgroup with "+staffGroupMoadl.getStaffGroupName()+" already exists");

		}
		
		String customerFullname=customerName.getFirstname()+ "    " +  customerName.getLastname();
		
		Date createdDate=new Date(calendar.getTime().getTime());
		StaffManagementModal staffModal = new StaffManagementModal(custid,customerFullname,createdDate);
		Set<StaffManagementModal> set = new HashSet( );
		set.add(staffModal);
		
		staffGroup.setCreatedDate(new Date(calendar.getTime().getTime()));
		//modal.setExpiraydate(new Date(calendar.getTime().getTime()));
		staffGroup.setCustomerid(custid);
		//staffGroup.setStaffmodal(staffGroup.getStaffmodal());
		staffGroup.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
//		staffGroup.setStaff(staff.setCreatedDate(new Date(calendar.getTime().getTime())));
	//	staffGroup.setStaff(staff.setCreatedDate(new Date(calendar.getTime().getTime())));
		//staffGroup.setCreatedBy(createdBy);
		//staffGroup.setStaff(set);
		
		System.out.println("The set values are "+set);
		
		staffGroupRepo.save(staffGroup);
		satffManRepo.saveAll(set);
		return staffGroup;
	}

	

}
