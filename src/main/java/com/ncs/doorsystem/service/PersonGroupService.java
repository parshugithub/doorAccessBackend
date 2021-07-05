package com.ncs.doorsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.repository.PersonGroupRepository;
import com.ncs.doorsystem.repository.PersonRepository;

@Service
@Transactional
public class PersonGroupService 
{
	@Autowired
	PersonGroupRepository repo;
	@Autowired
	PersonRepository personRepo;

	public List<PersonGroupModal> getAllPersonGroups(long custid) {
		List<PersonGroupModal> result = repo.findBywebappPerosnId(custid);

		return result;
	}

	public PersonGroupModal createNewPersonGroup(@Valid PersonGroupModal modal, long custid, long siteid) throws Exception 
	{
		PersonGroupModal existingGroup = repo.findBypersonGroupName(modal.getPersonGroupName());
		
		if(existingGroup!=null)
		{
			throw new Exception("The Person group already exists");
		}
		else
		{
			
		
		PersonGroupModal newGroup = new PersonGroupModal();
		
		newGroup.setPersonGroupName(modal.getPersonGroupName());
        newGroup.setWebappPerosnId(custid);
        newGroup.setSiteid(siteid);
        newGroup.setCreateddate(modal.getCreateddate());
        newGroup.setExpirydate(modal.getExpirydate());
        PersonGroupModal saved = repo.save(newGroup);
        
        return saved;
		}
		
	}

	public PersonGroupModal getPersonGroup(long persongroupid)
	{
		if(repo.findById(persongroupid).isPresent())
		{
			PersonGroupModal res= repo.findBypersongroupid(persongroupid);
			return res;
		}
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Object> deletePersonGroup(long persongroupid) {
		if(repo.findById(persongroupid).isPresent()){
			repo.deleteMappedPersonGroup(persongroupid);
            	repo.deleteById(persongroupid);
                if (repo.findById(persongroupid).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
                } else return ResponseEntity.ok().body("Successfully deleted specified record");
            } else return ResponseEntity.unprocessableEntity().body("Failed to delete,  Please delete the Person associated with this role");
        
	}

	public PersonGroupModal updatePersonGroup(long persongroupid, PersonGroupModal update) {
		if(repo.findById(persongroupid).isPresent()){
			PersonGroupModal newGroup = repo.findById(persongroupid).get();
			newGroup.setCreateddate(update.getCreateddate());
			newGroup.setExpirydate(update.getExpirydate());
			//newGroup.setPerson(update.getPerson());
			newGroup.setPersonGroupName(update.getPersonGroupName());
            
			PersonGroupModal saved = repo.save(newGroup);
            return saved;
	}
		return update;
	}
	
	

}
