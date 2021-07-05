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

import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.service.ChannelsService;

@RestController
@RequestMapping("/channels")
public class ChannelsController
{
	@Autowired
	ChannelsService service;
	
	@RequestMapping(path = "/getChannels",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public List<ChannelsModal> getAllchannels(@RequestParam("custId") long custID,@RequestParam("siteid") long siteid)
	{
		List<ChannelsModal>  channels =service.getAllChannels(custID,siteid);
		return channels;
	}
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<ChannelsModal>  createNewChannel(@Valid @RequestBody ChannelsModal modal,@RequestParam("custId") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		System.out.println("calling");
		System.out.println("the modal is"+modal.toString());
		
		System.out.println("the door is"+ modal.getDoor());
		System.out.println("the tags "+modal.getTags());
		ChannelsModal channelsModal= service.createNewChannes(modal,custid,siteid);
		System.out.println("the result is"+channelsModal);
		if(channelsModal!=null)
		{
			return new ResponseEntity<ChannelsModal>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<ChannelsModal>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/channles/details")
    public ChannelsModal getChannels(@RequestParam("channelid") long channelid) 
	{
		return service.getSingleChannel(channelid);
		
        
    }
	
	@DeleteMapping("/channles/delete")
    public ResponseEntity<Object> deleteChannel(@RequestParam("channelid") long channelid) {
        return service.deleteChannel(channelid);
    }


	@PutMapping("/channles/update")
	public ResponseEntity<Object> updateChannels(@RequestParam("channelid") Long channelid, @RequestBody ChannelsModal channelsUpdate) {
		return service.updateChannels(channelid, channelsUpdate);
	}
}
