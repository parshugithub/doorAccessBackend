package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.service.CreateSatffService;
import com.ncs.doorsystem.service.CreateStaffgroupservice;
import com.ncs.doorsystem.service.DashboardSerive;

@RestController
@RequestMapping("/staffmanagement/createstaffgroup")
public class CreateStaffGroupController
{
	
	
	@Autowired
	CreateStaffgroupservice groupServ;
	
	@Autowired
	CreateSatffService createStaffService;
	
	@Autowired
	DashboardSerive dashboardService;
	
	@GetMapping(value = "/all")
	public @ResponseBody List<CreateStaffgroupModal> getAllStaffGroup(@RequestParam("custId") long custid)
	{	
	List<CreateStaffgroupModal> list=groupServ.findAllStaffgroup(custid);
		
		return list;
		
	}
	
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<CreateStaffgroupModal>  createStaffgroup( @RequestBody CreateStaffgroupModal staff,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calli");
		System.out.println(staff.toString());
		CreateStaffgroupModal createStaff = groupServ.createStaffGroup(staff,custid);
		if(createStaff!= null)
		{
			return new ResponseEntity<CreateStaffgroupModal>(HttpStatus.OK);
		}
		
		return new ResponseEntity<CreateStaffgroupModal>(HttpStatus.BAD_REQUEST);
				
	}
	
	@PutMapping("/update")
	public ResponseEntity<CreateStaffgroupModal> updateStaffGroup(@RequestBody CreateStaffgroupModal modal,@RequestParam("groupId") long groupId)
	{
		CreateStaffgroupModal staffUpdate = groupServ.updateStaffGroup(modal,groupId);
		
		if(staffUpdate!=null)
		{
			return new ResponseEntity<CreateStaffgroupModal>(HttpStatus.OK);
		}
		return new ResponseEntity<CreateStaffgroupModal>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete")
	public String deleteStaffGroup(@RequestParam("groupid") long groupId) throws Exception
	{
		System.out.println("id "+groupId);
		int result = groupServ.deleteStaffGroup(groupId);
		if(result!=0)
		{
			return "staff group deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	
	//get all staffs in staff group
	
	@GetMapping(value = "/allstaffs")
	public @ResponseBody List<CreateStaffModal> getAllStaff(@RequestParam("custId") long custid)
	{	
	List<CreateStaffModal> list=createStaffService.findAllStaff(custid);
		
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
