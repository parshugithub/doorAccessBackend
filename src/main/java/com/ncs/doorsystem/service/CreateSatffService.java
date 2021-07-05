package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.repository.CreateStaffRepositoty;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.StaffGroupManytomanyRepository;
import com.ncs.doorsystem.repository.StaffManytoManyRepository;

@Service
@Transactional
public class CreateSatffService 
{
	@Autowired
	CreateStaffRepositoty createStaffRepo;
	
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	StaffManytoManyRepository repo;

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	StaffGroupManytomanyRepository staffGroupRepo;
	
	@Autowired
	StaffManytoManyService staffManytoManyService;



	public CreateStaffModal createStaff(CreateStaffModal staff, long custid) throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    CreateStaffModal staffMoadl = createStaffRepo.findBypayrollno(staff.getPayrollno());
	    
	    
		Customer customerName= customerrepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if(staffMoadl!=null)
		{
			throw new  Exception("The payrollno with "+staffMoadl.getPayrollno()+" already exists");

		}
		staff.setCreatedDate(new Date(calendar.getTime().getTime()));
		staff.setExpiraydate(new Date(calendar.getTime().getTime()));
		staff.setCustomerId(custid);
		staff.setCreatedBy(customerName.getFirstname()+ " " +  customerName.getLastname());
		createStaffRepo.save(staff);
		return staff;
	}
 
	public CreateStaffModal updateStaff(CreateStaffModal staffModal,long staffId)
	{
		Calendar calendar = Calendar.getInstance();
		System.out.println("The id is "+staffModal.getStaffid());
		CreateStaffModal  existingStaffRes = createStaffRepo.findBystaffid(staffId);
	//	StaffManagementModal  existingStaffRes = staffRepo.findByI
		
		if(existingStaffRes!=null)
		{
			System.out.println("The staffid is"+existingStaffRes.getStaffid());
			
			existingStaffRes.setFirstname(staffModal.getFirstname());
			existingStaffRes.setLastname(staffModal.getLastname());
			existingStaffRes.setPayrollno(staffModal.getPayrollno());
			existingStaffRes.setExpiraydate(new Date(calendar.getTime().getTime()));
			CreateStaffModal updateStaffres = createStaffRepo.save(existingStaffRes);
			return updateStaffres;
		}
		return null;
		
		

	}

	public int deleteStaff(long staffId) throws Exception
	{
		int value=0;
		CreateStaffModal staffDelete = createStaffRepo.findBystaffid(staffId);
		//System.out.println("The data is "+ userdelete.toString());
		if(staffDelete!=null)
		{
			System.out.println("entering");
			value= value+createStaffRepo.deleteBystaffid(staffId);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;



	}

	public List<CreateStaffModal> findAllStaff(long custid) {
		
		List<CreateStaffModal> staffmodal = createStaffRepo.findBycustomerId(custid);
		
		List<StaffModal> getStaff =  staffManytoManyService.findAllStaff(custid);
		for (Iterator iterator = getStaff.iterator(); iterator.hasNext();) {
			StaffManyToMany staffManyToMany = (StaffManyToMany) iterator.next();
			System.out.println("The payroll is"+ staffManyToMany.getPayrollno());
			
			for (Iterator iterator2 = staffmodal.iterator(); iterator2.hasNext();) {
				CreateStaffModal createStaffModal = (CreateStaffModal) iterator2.next();
				if(staffManyToMany.getPayrollno()==createStaffModal.getPayrollno())
				{
					System.out.println("The staff groups are "+staffManyToMany.getStaffgroup());
				}
				
			}
		}
		
		
		return staffmodal;
	}
}
