package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonTagsModal;


@Repository
public interface PersonTagsRepository extends JpaRepository<PersonTagsModal, Long>
{

	@Query(value = "select max(personid) from doorsystem.person_table ",nativeQuery=true)
	String getMaxPersonId();

	List<PersonTagsModal> findBypersonid(long personid);
}
