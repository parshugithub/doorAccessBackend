package com.ncs.doorsystem.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.service.CreateSatffService;
import com.ncs.doorsystem.service.StaffManytoManyService;

@RestController
@RequestMapping("/staffmanagement/createStaff")
public class CreateStaffController 
{
	@Autowired
	CreateSatffService createStaffService;
	
	@Autowired
	StaffManytoManyService staffManytoManyService;


	
	@GetMapping(value = "/all")
	public @ResponseBody List<CreateStaffModal> getAllStaff(@RequestParam("custId") long custid)
	{	
	List<CreateStaffModal> list=createStaffService.findAllStaff(custid);
	
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		CreateStaffModal createStaffModal = (CreateStaffModal) iterator.next();
		System.out.println("The date is"+createStaffModal.getCreatedDate());
		List<StaffModal> getStaff =  staffManytoManyService.findAllStaff(custid);
		for (Iterator iterator2 = getStaff.iterator(); iterator2.hasNext();) {
			StaffManyToMany staffManyToMany = (StaffManyToMany) iterator2.next();
			
		}
		
	}
		
		return list;
		
	}
	
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<CreateStaffModal>  createStaff( @RequestBody CreateStaffModal staff,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calli");
		System.out.println(staff.toString());
		CreateStaffModal createStaff = createStaffService.createStaff(staff,custid);
		if(createStaff!= null)
		{
			return new ResponseEntity<CreateStaffModal>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<CreateStaffModal>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<CreateStaffModal> updateStaff(@RequestBody CreateStaffModal modal,@RequestParam("staffId") long staffId)
	{
		CreateStaffModal staffUpdate = createStaffService.updateStaff(modal,staffId);
		
		if(staffUpdate!=null)
		{
			return new ResponseEntity<CreateStaffModal>(HttpStatus.OK);
		}
		return new ResponseEntity<CreateStaffModal>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete")
	public String deleteStaff(@RequestParam("staffId") long staffId) throws Exception
	{
		System.out.println("id "+staffId);
		int result = createStaffService.deleteStaff(staffId);
		if(result!=0)
		{
			return "user deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
}
