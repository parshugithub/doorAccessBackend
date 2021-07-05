package com.ncs.doorsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.entity.PersonManagementTags;
import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.repository.PersonManagementTagsRepository;
import com.ncs.doorsystem.repository.PersonTagsRepository;

@Service
@Transactional
public class PersonManagementTagsService 
{
	@Autowired
	PersonManagementTagsRepository repo;
	

	public PersonManagementTags createTags(PersonManagementTags modal)
	{
		System.out.println("the tags modal is "+modal.toString());
		String personid = repo.getMaxPersonId();
		if(personid==null)
		{
			modal.setPid(1);
			PersonManagementTags saved = repo.save(modal);
			return saved;
		}
		else
		{
			modal.setPid(Long.parseLong(personid)+1);
			PersonManagementTags saved = repo.save(modal);
			return saved;
		}
		
		
		
		
		
	}

	public PersonManagementTags findTgas(long id) {
		
		return repo.findById(id).get();
	}

	public List<PersonManagementTags> findAllTags() {
		
		return repo.findAll();
	}

	public PersonManagementTags updateTags(PersonManagementTags updateModal, long id) 
	{
		PersonManagementTags existingTags= repo.findById(id).get();
		if(existingTags!=null)
		{
			existingTags.setPid(existingTags.getPid());
			existingTags.setTagcode(updateModal.getTagcode());
			existingTags.setTagcolor(updateModal.getTagcolor());
			existingTags.setTagExpiray(updateModal.getTagExpiray());
			PersonManagementTags update = repo.save(existingTags);
			return update;
			
			
		}
		return null;
	}


}
