package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.service.StaffManagementService;

@RestController
@RequestMapping("/staff")

public class StaffManagementController 
{
	@Autowired 
	StaffManagementService staffService;
	
	@RequestMapping(path = "/getAllStaff",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public StaffManagementModal getAllStaff(@RequestParam("custId") String custID)
	{
		StaffManagementModal  staff =staffService.getAllStaff(custID);
		return staff;
	}
	
	@PostMapping(value="/createStaff",produces = "application/json")
	public ResponseEntity<StaffManagementModal>  createNewStaff(@RequestBody StaffManagementModal modal,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calling");
		StaffManagementModal staffModal= staffService.createNewStaff(modal,custid);
		System.out.println("the result is"+staffModal);
		if(staffModal!=null)
		{
			return new ResponseEntity<StaffManagementModal>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<StaffManagementModal>(HttpStatus.BAD_REQUEST);
		
	}
	

	@PutMapping("/updateStaff")
	public ResponseEntity<StaffManagementModal> updateUser(@RequestBody StaffManagementModal modal,@RequestParam("staffId") long staffId)
	{
		StaffManagementModal staffUpdate = staffService.updateStaff(modal,staffId);
		
		if(staffUpdate!=null)
		{
			return new ResponseEntity<StaffManagementModal>(HttpStatus.OK);
		}
		return new ResponseEntity<StaffManagementModal>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deletestaff")
	public String deleteUser(@RequestParam("staffId") long staffId) throws Exception
	{
		System.out.println("id "+staffId);
		int result = staffService.deleteStaff(staffId);
		if(result!=0)
		{
			return "user deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	
}
