package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.repository.CreateStaffgroupRepository;
import com.ncs.doorsystem.repository.CustomerRepository;

@Service
@Transactional
public class CreateStaffgroupservice 
{
	@Autowired
	CustomerRepository customerrepo;

	@Autowired
	CreateStaffgroupRepository staffgroupRepo;


	public List<CreateStaffgroupModal> findAllStaffgroup(long custid) {

		List<CreateStaffgroupModal> staffmodal = staffgroupRepo.findBycustomerid(custid);
		return staffmodal;
	}

	public CreateStaffgroupModal createStaffGroup(CreateStaffgroupModal staff, long custid) throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		CreateStaffgroupModal staffMoadl = staffgroupRepo.findBystaffGroupName(staff.getStaffGroupName());


		Customer customerName= customerrepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if(staffMoadl!=null)
		{
			throw new  Exception("The Staff Group with "+staffMoadl.getStaffGroupName()+" already exists");

		}
		staff.setCreatedDate(new Date(calendar.getTime().getTime()));

		staff.setCustomerid(custid);
		staff.setCreatedBy(customerName.getFirstname()+ " " +  customerName.getLastname());
		staffgroupRepo.save(staff);
		return staff;
	}

	public CreateStaffgroupModal updateStaffGroup(CreateStaffgroupModal staffModal,long groupid)
	{
		Calendar calendar = Calendar.getInstance();
		System.out.println("The id is "+staffModal.getGroupid());
		CreateStaffgroupModal  existingStaffRes = staffgroupRepo.findBygroupid(groupid);
		//	StaffManagementModal  existingStaffRes = staffRepo.findByI

		if(existingStaffRes!=null)
		{
			System.out.println("The staffid is"+existingStaffRes.getGroupid());

			//			existingStaffRes.setFirstname(staffModal.get());
			//			existingStaffRes.setLastname(staffModal.getLastname());
			//			existingStaffRes.setPayrollno(staffModal.getPayrollno());
			//			existingStaffRes.setExpiraydate(new Date(calendar.getTime().getTime()));
			CreateStaffgroupModal updateStaffres = staffgroupRepo.save(existingStaffRes);
			return updateStaffres;
		}
		return null;



	}

	public int deleteStaffGroup(long groupid) throws Exception
	{
		int value=0;
		CreateStaffgroupModal staffDelete = staffgroupRepo.findBygroupid(groupid);
		//System.out.println("The data is "+ userdelete.toString());
		if(staffDelete!=null)
		{
			System.out.println("entering");
			value= value+staffgroupRepo.deleteBygroupid(groupid);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;



	}



}
