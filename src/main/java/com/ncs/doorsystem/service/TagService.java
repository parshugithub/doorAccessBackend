package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ncs.doorsystem.entity.CreateStaffgroupModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.TagModal;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.TagRepository;

@Service
@Transactional
public class TagService {
	
	@Autowired
	TagRepository tagRepo;
	
	@Autowired
	CustomerRepository customerrepo;

	public List<TagModal> findAllTag(long custid) 
	{
		List<TagModal> listTag=tagRepo.findBycustomerid(custid);
		
		
		return listTag;
	}

	public TagModal createTag(TagModal tag, long custid) throws Exception 
	{
		
		//Optional<TagModal> tagMoadl = tagRepo.findBytagnameAndtagRFid(tag.getTagname(),tag.getTagRFid());
		
//		TagModal tagMoadl = tagRepo.findBytagname(tag.getTagname());
//		TagModal tagMoadlRf = tagRepo.findBytagRFid(tag.getTagRFid());
		Customer customerName= customerrepo.findById(custid);
		
		String str = Long.toHexString(tag.getTagRFid());
		
		System.out.println("the customer name "+ customerName);
		
			tag.setCreatedDate(tag.getCreatedDate());
			tag.setUpdatedDate(tag.getCreatedDate());
			tag.setHexaval(str);
			tag.setCustomerid(custid);
			
			tagRepo.save(tag);
			return tag ;
		
			
		
		
		
	}

	public ResponseEntity<Object> updateTag(TagModal modal, long tagid) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("The id is "+modal.getTagid());
		TagModal  existingTag = tagRepo.findBytagid(tagid);
		if(existingTag!=null)
		{
			System.out.println("The tag is"+existingTag.getTagid());
			existingTag.setTagname(modal.getTagname());
			existingTag.setTagRFid(modal.getTagRFid());
			//existingTag.setCreatedDate(modal.getCreatedDate());
			existingTag.setUpdatedDate(modal.getCreatedDate());

			TagModal updateTag = tagRepo.save(existingTag);
			return ResponseEntity.ok("Tag  updates Successfully");
		}
			else return ResponseEntity.unprocessableEntity().body("Failed update Tag as Specified");
		
	
		
	}

	public int deleteTag(long tagid) {
		int value=0;
		TagModal tagDelete = tagRepo.findBytagid(tagid);
		//System.out.println("The data is "+ userdelete.toString());
		if(tagDelete!=null)
		{
			System.out.println("entering");
			value= value+tagRepo.deleteBytagid(tagid);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;
	}

	public Future<Optional<String>> getHexaValue(long tagrfid) {
		
		return tagRepo.findByhexaval(tagrfid);
	}

}
