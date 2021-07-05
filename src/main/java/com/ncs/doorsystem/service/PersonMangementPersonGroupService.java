package com.ncs.doorsystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.PersonManagementPersonGroup;
import com.ncs.doorsystem.repository.PersonGroupRepository;
import com.ncs.doorsystem.repository.PersonManagementGroupRepository;
import com.ncs.doorsystem.repository.PersonManagementRepository;
import com.ncs.doorsystem.repository.PersonRepository;

@Service
@Transactional
public class PersonMangementPersonGroupService 
{
	@Autowired
	PersonManagementGroupRepository repo;
	@Autowired
	PersonManagementRepository personRepo;

	public List<PersonManagementPersonGroup> getAllPersonGroups(long custid) {
		List<PersonManagementPersonGroup> result = repo.findBywebappPerosnId(custid);

		return result;
	}

	public PersonManagementPersonGroup createNewPersonGroup(@Valid PersonManagementPersonGroup modal, long custid, long siteid) throws Exception 
	{
		PersonManagementPersonGroup existingGroup = repo.findBypersonGroupName(modal.getPersonGroupName());
		
		if(existingGroup!=null)
		{
			throw new Exception("The Person group already exists");
		}
		else
		{
			
		
			PersonManagementPersonGroup newGroup = new PersonManagementPersonGroup();
		
		newGroup.setPersonGroupName(modal.getPersonGroupName());
        newGroup.setWebappPerosnId(custid);
        newGroup.setSiteid(siteid);
        newGroup.setCreateddate(modal.getCreateddate());
        newGroup.setExpirydate(modal.getExpirydate());
        PersonManagementPersonGroup saved = repo.save(newGroup);
        
        return saved;
		}
		
	}

	public PersonManagementPersonGroup getPersonGroup(long persongroupid)
	{
		if(repo.findById(persongroupid).isPresent())
		{
			PersonManagementPersonGroup res= repo.findBypgroupid(persongroupid);
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

	public PersonManagementPersonGroup updatePersonGroup(long persongroupid, PersonManagementPersonGroup update) {
		if(repo.findById(persongroupid).isPresent()){
			PersonManagementPersonGroup newGroup = repo.findById(persongroupid).get();
			newGroup.setCreateddate(update.getCreateddate());
			newGroup.setExpirydate(update.getExpirydate());
			//newGroup.setPerson(update.getPerson());
			newGroup.setPersonGroupName(update.getPersonGroupName());
            
			PersonManagementPersonGroup saved = repo.save(newGroup);
            return saved;
	}
		return update;
	}

	public List<PersonManagementPersonGroup> getAllPersonGroupsForSite(long custid, long siteid) {
		List<PersonManagementPersonGroup> result = repo.findallForSite(custid,siteid);

		return result;
	}
	
	


}
