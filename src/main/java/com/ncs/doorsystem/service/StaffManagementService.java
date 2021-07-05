package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.StaffGroupManagementRepository;
import com.ncs.doorsystem.repository.StaffManagementRepository;

@Service
@Transactional
public class StaffManagementService
{
	@Autowired
	StaffManagementRepository staffRepo;

	@Autowired
	CustomerRepository customerrepo;

	@Autowired
	StaffGroupManagementRepository staffGroupRepo;
	public StaffManagementModal getAllStaff(String custID) 
	{
		return staffRepo.findBycustomerId(custID);


	}

	public StaffManagementModal createNewStaff(StaffManagementModal modal, long custid) throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("fsdfsd "+formatter.format(date));  
		System.out.println("service calling");
		
		//StaffFGroupModal grp = new StaffFGroupModal((List<StaffManagementModal>) modal);
		System.out.println("the response is"+modal);
		
		StaffManagementModal staffMoadl = staffRepo.findBypayrollno(modal.getPayrollno());
		Customer customerName= customerrepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if(staffMoadl!=null)
		{
			throw new  Exception("The payrollno with "+staffMoadl.getPayrollno()+" already exists");

		}
		modal.setCreatedDate(new Date(calendar.getTime().getTime()));
		modal.setExpiraydate(new Date(calendar.getTime().getTime()));
		modal.setCustomerId(custid);
		modal.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
		staffRepo.save(modal);
		//staffGroupRepo.save(grp);
		return modal;
	}


	public StaffManagementModal updateStaff(StaffManagementModal staffModal,long staffId)
	{
		Calendar calendar = Calendar.getInstance();
		System.out.println("The id is "+staffModal.getStaffId());
		StaffManagementModal  existingStaffRes = staffRepo.findBystaffId(staffId);
	//	StaffManagementModal  existingStaffRes = staffRepo.findByI
		
		if(existingStaffRes!=null)
		{
			System.out.println("The staffid is"+existingStaffRes.getStaffId());
			
			existingStaffRes.setFirstname(staffModal.getFirstname());
			existingStaffRes.setLastname(staffModal.getLastname());
			existingStaffRes.setPayrollno(staffModal.getPayrollno());
			existingStaffRes.setExpiraydate(new Date(calendar.getTime().getTime()));
			StaffManagementModal updateStaffres = staffRepo.save(existingStaffRes);
			return updateStaffres;
		}
		return null;
		
		

	}

	public int deleteStaff(long staffId) throws Exception
	{
		int value=0;
		StaffManagementModal staffDelete = staffRepo.findBystaffId(staffId);
		//System.out.println("The data is "+ userdelete.toString());
		if(staffDelete!=null)
		{
			System.out.println("entering");
			value= value+staffRepo.deleteBystaffId(staffId);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;



	}

}
