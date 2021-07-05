package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.service.StaffManytoManyService;




@RestController
@RequestMapping("/staffManagement")
public class StaffManytoManyController 
{
	@Autowired
	StaffManytoManyService staffManytoManyService;

	public @ResponseBody List<StaffManyToMany> getAllStaffs()
	{
		List<StaffManyToMany> getStaff =  staffManytoManyService.getAllStaffs();
		return getStaff;


	}

	@PostMapping(path="/staff/create", produces = "application/json")
	public ResponseEntity<Object> createStaff(@RequestBody StaffManyToMany staffManyToMany,@RequestParam("custId") long custid) {
		return staffManytoManyService.createStaff(staffManyToMany,custid);
	}

	@GetMapping("/staff/details")
	public StaffModal getStaff(@RequestParam("staffid") long staffid) 
	{
		StaffModal getStaff =staffManytoManyService.findStaff(staffid);
		if(getStaff!=null)
			return getStaff;
		else return  null;
	}

	@GetMapping("/staff/all")
	public List<StaffModal> getAllStaff(@RequestParam("custId") long custId) {
		System.out.println("entered");
		List<StaffModal> getAllStaff =staffManytoManyService.findAllStaff(custId);
		if(getAllStaff!=null)
		{
			return getAllStaff;
		}
		return null;


	}
	
	@PutMapping("/staff/update")
    public StaffManyToMany updateStaff(@RequestParam("staffid") long staffid, @RequestBody StaffManyToMany staffManyToMany,@RequestParam("custId") long custId) {
        return staffManytoManyService.updateStaff(staffManyToMany, staffid,custId);
    }
	
	 @DeleteMapping("/staff/delete")
	    public ResponseEntity<Object> deleteStaff(@RequestParam("staffid") long staffid) throws Exception {
	        return staffManytoManyService.deleteStaff(staffid);
	    }

	 
	 
}
