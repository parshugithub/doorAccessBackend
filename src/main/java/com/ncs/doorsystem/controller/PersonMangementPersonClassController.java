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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.dto.PersonClassDTO;
import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonManagementPersonClassModal;
import com.ncs.doorsystem.service.PersonClassService;
import com.ncs.doorsystem.service.PersonManagementPersonClassService;

@RestController
@RequestMapping("personmanagmentpersonclass")
public class PersonMangementPersonClassController 
{
	@Autowired
	PersonManagementPersonClassService service;
	
	@GetMapping(path = "/getall",produces = "application/json")
	public List<PersonClassDTO> getAllPersonClass(@RequestParam("custid") long custid)
	{
		List<PersonClassDTO>response = service.getAllPersonClass(custid);
		
		return response;
		
	}
	
	@GetMapping(path = "/getallforsite",produces = "application/json")
	public List<PersonClassDTO> getAllPersonClassForSite(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid)
	{
		List<PersonClassDTO>response = service.getAllPersonClassForSite(custid,siteid);
		
		return response;
		
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public PersonManagementPersonClassModal  createNewPersonClass(@Valid @RequestBody PersonManagementPersonClassModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createNewPersonClass(modal,custid,siteid);
		
	}
	
	@GetMapping("/details")
    public PersonClassDTO getPersonClass(@RequestParam("personclassid") long personclassid) 
	{
		PersonClassDTO res=service.getPersonClass(personclassid);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deletePersonClass(@RequestParam("personclassid") long personclassid) {
        return service.deletePersonClass(personclassid);
    }


	@PutMapping("/update")
	public @ResponseBody PersonManagementPersonClassModal updatePersonClass(@RequestParam("personclassid") long personclassid, @RequestBody PersonManagementPersonClassModal update) 
	{
		System.out.println("respose "+update);
		return service.updatePersonClass(personclassid, update);
	}


}
