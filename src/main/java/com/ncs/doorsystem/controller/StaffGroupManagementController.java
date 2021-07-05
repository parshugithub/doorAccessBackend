package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.StaffGroupManagementModal;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.service.StaffGroupManagementService;
import com.ncs.doorsystem.service.StaffManagementService;

@RestController
@RequestMapping("/stffgroup")
public class StaffGroupManagementController 
{
	@Autowired
	StaffGroupManagementService groupService;
	
	@Autowired
	StaffManagementService staffService;
	@RequestMapping(value = "/createStaffGroup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

//	@PostMapping(value="/createStaffGroup",produces = "application/json")
	public ResponseEntity<StaffGroupManagementModal>  createNewStaff(@RequestBody StaffGroupManagementModal modal,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calling");
		StaffGroupManagementModal staffGroupManagementModal= groupService.createNewStaffgroup(modal,custid);
		System.out.println("the result is "+staffGroupManagementModal);
		if(staffGroupManagementModal!=null)
		{
			return new ResponseEntity<StaffGroupManagementModal>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<StaffGroupManagementModal>(HttpStatus.BAD_REQUEST);
		
	}
	
}
