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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.PersonMangementPersonModal;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.service.PersonManagementService;
import com.ncs.doorsystem.service.PersonService;

@RestController
@RequestMapping("/personmanagemet")
public class PersonManagementController 
{
	@Autowired
	PersonManagementService service;
	
	
	@RequestMapping(path = "/getallpersons",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public List<PersonMangementPersonModal> getAllPerson(@RequestParam("custId") long custID)
	{
		List<PersonMangementPersonModal>  persons =service.getAllPerson(custID);
		return persons;
	}
	
	@RequestMapping(path = "/getallpersonsofsite",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public List<PersonMangementPersonModal> getAllPersonsOfSite(@RequestParam("custId") long custID,@RequestParam("siteid") long siteid)
	{
		List<PersonMangementPersonModal>  personsOfSite =service.getAllPersonsOfSite(custID,siteid);
		return personsOfSite;
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody PersonMangementPersonModal  createNewPerson(@Valid @RequestBody PersonMangementPersonModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		return service.createNewPerson(modal,custid,siteid);
		
	}
	
	@GetMapping("/details")
    public PersonMangementPersonModal getPerson(@RequestParam("personid") long personid) 
	{
		PersonMangementPersonModal res=service.getPerson(personid);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	
	@DeleteMapping("/delete")
    public ResponseEntity<Object> deletePerson(@RequestParam("personid") long personid) {
        return service.deletePerson(personid);
    }


	@PutMapping("/update")
	public PersonMangementPersonModal updatePesron(@RequestParam("personid") long personid, @RequestBody PersonMangementPersonModal personUpdate) {
		return service.updatePesron(personid, personUpdate);
	}

	@GetMapping("/getflatnumber")
    public List<ChannelsModal> getflatnumber(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) 
	{
		List<ChannelsModal> res=service.getflatnumber(custid,siteid);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	@GetMapping("/getflat")
    public long getflat(@RequestParam("flat") long flat) 
	{
		long res=service.getflat(flat);
		System.out.println("the response is "+res);
		return res;
		
        
    }
	
	
	@PutMapping("/personwithall/update")
	public PersonMangementPersonModal updatePesronWithGroups(@RequestParam("personid") long personid,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid ,@RequestBody PersonMangementPersonModal personUpdate)
	{
		System.out.println("called");
		System.out.println("the request is "+personUpdate.toString());
		return service.updatePesronWithGroups(personid, personUpdate,custid,siteid);
	}
	

}
