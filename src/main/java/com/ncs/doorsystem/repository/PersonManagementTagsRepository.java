package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.entity.PersonManagementTags;
import com.ncs.doorsystem.entity.PersonTagsModal;

public interface PersonManagementTagsRepository extends JpaRepository<PersonManagementTags, Long>
{

	@Query(value = "select max(pid) from doorsystem.person_management_table ",nativeQuery=true)
	String getMaxPersonId();

	List<PersonManagementTags> findBypid(long personid);
	
	
	
	
	
	
	
}
