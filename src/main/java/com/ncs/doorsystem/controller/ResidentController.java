package com.ncs.doorsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ncs.doorsystem.entity.ResidentModal;
import com.ncs.doorsystem.service.ResidentService;

@RestController
@RequestMapping("/resident")
public class ResidentController 
{
	@Autowired
	ResidentService service;
	
	@RequestMapping(path = "/getallresidents",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public List<ResidentModal> getAllResident(@RequestParam("custId") long custID)
	{
		List<ResidentModal>  channels =service.getAllResident(custID);
		return channels;
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<Object>  createNewResident(@Valid @RequestBody ResidentModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createNewResident(modal,custid,siteid);
		
	}
	
	@GetMapping("/resident/details")
    public ResidentModal getResident(@RequestParam("residentid") long residentid) 
	{
		return service.getResident(residentid);
		
        
    }
	
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deleteResident(@RequestParam("residentid") long residentid) {
        return service.deleteResident(residentid);
    }


	@PutMapping("/update")
	public ResponseEntity<Object> updateResident(@RequestParam("residentid") long residentid, @RequestBody ResidentModal residentUpdate) {
		return service.updateResident(residentid, residentUpdate);
	}

}
