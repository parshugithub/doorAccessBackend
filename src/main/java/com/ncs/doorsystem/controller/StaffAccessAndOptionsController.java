package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.StaffAccessAndOptions;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.service.StaffAccessAndOptionsService;
import com.ncs.doorsystem.service.StaffManytoManyService;

@RestController
@RequestMapping("/StaffAccess")
public class StaffAccessAndOptionsController 
{
	@Autowired
	StaffAccessAndOptionsService service;
	@Autowired
	StaffManytoManyService staffManytoManyService;

	
	
	@GetMapping("/getall")
	public List<StaffAccessAndOptions> getAllTrades(@RequestParam("custid") long custId,@RequestParam("siteid") long siteid) {
		System.out.println("entered");
		List<StaffAccessAndOptions> getAllTrades =service.findAll(custId,siteid);
		if(getAllTrades!=null)
		{
			return getAllTrades;
		}
		return null;


	}
	
	@PostMapping(path = "/create",produces = "application/json")
	public @ResponseBody StaffAccessAndOptions createStaffAcess(@RequestBody StaffAccessAndOptions staffAccess, @RequestParam("custid") long custid,@RequestParam("siteid") long siteid,@RequestParam("staff") long staff) throws Exception
	{
		return service.createStaffAcess(staffAccess,custid,siteid,staff);
		
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

	@PutMapping("/update")
    public ResponseEntity<Object> updateStaffAccess(@RequestParam("staffaccessid") long staffaccessid, @RequestBody StaffAccessAndOptions staffAccess) {
        return service.updateStaffAccess(staffAccess, staffaccessid);
    }
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteStaffaccess(@RequestParam("staffaccessid") long staffaccessid) {
	        return service.deleteStaffaccess(staffaccessid);
	    }
}
