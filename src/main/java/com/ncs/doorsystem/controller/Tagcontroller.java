package com.ncs.doorsystem.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

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

import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.entity.TagModal;
import com.ncs.doorsystem.service.TagService;

@RestController
@RequestMapping("/tag")
public class Tagcontroller 
{
	@Autowired
	TagService tagservice;
	
	@GetMapping(value = "/all")
	public @ResponseBody List<TagModal> getAllTag(@RequestParam("custId") long custid)
	{	
	List<TagModal> list=tagservice.findAllTag(custid);
		
		return list;
		
	}
	
	
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody TagModal  createStaffgroup( @RequestBody TagModal tag,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("calli");
		System.out.println(tag.toString());
		
		return  tagservice.createTag(tag,custid);
	
		
//		if(createTag!= null)
//		{
//			return new ResponseEntity<TagModal>(HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<TagModal>(HttpStatus.BAD_REQUEST);
				
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateTag(@RequestBody TagModal modal,@RequestParam("tagid") long tagid)
	{
		return tagservice.updateTag(modal,tagid);
		
		
	}
	
	@DeleteMapping("/delete")
	public String deleteTag(@RequestParam("tagid") long tagid) throws Exception
	{
		System.out.println("id "+tagid);
		int result = tagservice.deleteTag(tagid);
		if(result!=0)
		{
			return "Tag deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	
	@GetMapping("/getHexavalues")
	public Future<Optional<String>> getHexaVal(@RequestParam("tagrfid") long tagrfid)
	{
		Future<Optional<String>> modal = tagservice.getHexaValue(tagrfid);
		System.out.println("the hexavalue"+modal);
		return modal;
		
	}
	
	
	@GetMapping("/getHexavaluesfor")
	public TagModal getHexaValfor(@RequestParam("tagrfid") long tagrfid)
	{
		System.out.println("sdfsdf"+tagrfid);
		String str = Long.toHexString(tagrfid);
		TagModal hexavalues = new TagModal(str);
		return hexavalues;
		
	}
	
	
	
	

}
