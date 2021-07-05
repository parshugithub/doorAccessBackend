package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonGroupModal;


@Repository
public interface PersonGroupRepository extends JpaRepository<PersonGroupModal, Long> {

	List<PersonGroupModal> findBywebappPerosnId(long custid);

	PersonGroupModal findBypersongroupid(long persongroupid);

	PersonGroupModal findBypersonGroupName(String personGroupName);
	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_person_persongroup_mapping_table where persongroup_id=:persongroupid",nativeQuery=true)
	void deleteMappedPersonGroup(long persongroupid);


}
