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
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.service.PersonClassService;

@RestController
@RequestMapping("/personclass")
public class PersonClassController 
{
	@Autowired
	PersonClassService service;
	
	@GetMapping(path = "/getall",produces = "application/json")
	public List<PersonClassDTO> getAllPersonClass(@RequestParam("custid") long custid)
	{
		List<PersonClassDTO>response = service.getAllPersonClass(custid);
		
		return response;
		
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<Object>  createNewPersonClass(@Valid @RequestBody PersonClassModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
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
	public @ResponseBody PersonClassModal updatePersonClass(@RequestParam("personclassid") long personclassid, @RequestBody PersonClassModal update) 
	{
		System.out.println("respose "+update);
		return service.updatePersonClass(personclassid, update);
	}

}
