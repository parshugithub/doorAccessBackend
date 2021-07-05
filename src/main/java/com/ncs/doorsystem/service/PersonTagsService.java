package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.repository.PersonClassRepository;
import com.ncs.doorsystem.repository.PersonTagsRepository;


@Service
@Transactional
public class PersonTagsService
{
	@Autowired
	PersonTagsRepository repo;
	

	public PersonTagsModal createTags(PersonTagsModal modal)
	{
		System.out.println("the tags modal is "+modal.toString());
		String personid = repo.getMaxPersonId();
		if(personid==null)
		{
			modal.setPersonid(1);
			PersonTagsModal saved = repo.save(modal);
			return saved;
		}
		else
		{
			modal.setPersonid(Long.parseLong(personid)+1);
			PersonTagsModal saved = repo.save(modal);
			return saved;
		}
		
		
		
		
		
	}

	public PersonTagsModal findTgas(long id) {
		
		return repo.findById(id).get();
	}

	public List<PersonTagsModal> findAllTags() {
		
		return repo.findAll();
	}

	public PersonTagsModal updateTags(PersonTagsModal updateModal, long id) 
	{
		PersonTagsModal existingTags= repo.findById(id).get();
		if(existingTags!=null)
		{
			existingTags.setPersonid(existingTags.getPersonid());
			existingTags.setTagcode(updateModal.getTagcode());
			existingTags.setTagcolor(updateModal.getTagcolor());
			existingTags.setTagExpiray(updateModal.getTagExpiray());
			PersonTagsModal update = repo.save(existingTags);
			return update;
			
			
		}
		return null;
	}

}
