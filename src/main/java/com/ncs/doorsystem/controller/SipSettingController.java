package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ncs.doorsystem.entity.SipSettingEntity;
import com.ncs.doorsystem.service.SipSettingService;

@RestController
@RequestMapping("/sipsetting")
public class SipSettingController 
{
	@Autowired
	SipSettingService service;
	
	@GetMapping(path = "/getall",produces = "application/json")
	public List<SipSettingEntity> getAllSipsetting(@RequestParam("custId") long custid)
	{
		List<SipSettingEntity>response = service.getAllSipsetting(custid);
		
		return response;
		
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public SipSettingEntity  createNewsipSetting(@Valid @RequestBody SipSettingEntity modal,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createNewsipSetting(modal,custid);
		
	}
	
	@PutMapping(value="/update",produces = "application/json")
	public SipSettingEntity  upadteNewsipSetting(@RequestParam("id") long id,@RequestParam("custid") long custid,@RequestBody SipSettingEntity modal) throws Exception
	{
//		System.out.println("calling");
//		System.out.println("the modal is"+modal.toString());
//		
		return service.upadteNewsipSetting(id,custid,modal);
		
	}
	
	@GetMapping("/details")
    public SipSettingEntity getSipSetting(@RequestParam("id") long id) 
	{
		SipSettingEntity res=service.getSipSetting(id);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deleteSipSetting(@RequestParam("id") long id) {
        return service.deleteSipSetting(id);
    }



}
