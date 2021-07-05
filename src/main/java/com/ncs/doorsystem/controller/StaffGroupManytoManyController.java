package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.dto.StaffGroupMainModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;
import com.ncs.doorsystem.service.DashboardSerive;
import com.ncs.doorsystem.service.StaffGroupManytoManyService;
import com.ncs.doorsystem.service.StaffManytoManyService;


@RestController
@RequestMapping("/staffmanagement")
public class StaffGroupManytoManyController 
{
	@Autowired
	StaffGroupManytoManyService service;
	
	@Autowired
	DashboardSerive dashboardService;
	
	@Autowired
	StaffManytoManyService staffManytoManyService;

	@PostMapping(value = "/group/create", produces = "application/json")
	public ResponseEntity<Object> createStaff(@RequestBody StaffGroupManytoMany staffgroup,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("the group id "+staffgroup.getStaffGroupId());
		return service.createStaffGroup(staffgroup,custid);
	}

	@GetMapping("/group/details")
	public StaffGroupMainModal getStaffGroup(@RequestParam("id") long id) 
	{
		StaffGroupMainModal resposeStaffgroup =service.getStaffGroup(id);
		if(resposeStaffgroup!=null)
		{
			return resposeStaffgroup;
		}

		else return null;
	}

	@GetMapping(value = "/group/allstaffgroup")
	public List<StaffGroupMainModal> getSatffGroup(@RequestParam("custId") long custId) 
	{
		System.out.println("calling this all");
		
		List<StaffGroupMainModal> getAllStaff =service.findAllSatffGroup(custId);
		if(getAllStaff!=null)
		{
			return getAllStaff;
		}
		return null;
		//return service.findAllSatffGroup(custId);
	}
	@PutMapping("/group/update")
	public StaffGroupManytoMany updateStaffGroup(@RequestParam("id") long id, @RequestParam("custid") long custid,@RequestBody StaffGroupManytoMany staffGroupManytoMany) throws Exception {
		return service.updateStaffGroup(id,staffGroupManytoMany,custid);
	}

	@DeleteMapping("/group/delete")
    public ResponseEntity<Object> deleteStaffGroup(@RequestParam("id") long id) {
        return service.deleteStaffGroup(id);
    }

	@GetMapping(value = "/allstaffs")
	public @ResponseBody List<StaffModal> getAllStaff(@RequestParam("custId") long custid)
	{	
	List<StaffModal> list=staffManytoManyService.findAllStaff(custid);
		
		return list;
		
		
	}
	
	// function to get all sites in staff group
	
	@GetMapping(value = "/allsites")
	public @ResponseBody List<CreateSiteModal> getAllSites(@RequestParam("custId") long custId)
	{	
	List<CreateSiteModal> list=dashboardService.findAllSitesOfCustomer(custId);
		
		return list;
		
	}

}
