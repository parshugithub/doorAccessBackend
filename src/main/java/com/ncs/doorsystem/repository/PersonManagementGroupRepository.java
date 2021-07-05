package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.PersonManagementPersonGroup;

@Repository
public interface PersonManagementGroupRepository extends JpaRepository<PersonManagementPersonGroup, Long> 
{
	List<PersonManagementPersonGroup> findBywebappPerosnId(long custid);

	PersonManagementPersonGroup findBypgroupid(long persongroupid);

	PersonManagementPersonGroup findBypersonGroupName(String personGroupName);
	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_personmanagment_persongroup_mapping_table where pgroupid=:persongroupid",nativeQuery=true)
	void deleteMappedPersonGroup(long persongroupid);

	@Query(value = "select * FROM doorsystem.person_management_group_table where webapp_perosn_id=:custid and siteid=:siteid",nativeQuery=true)
	List<PersonManagementPersonGroup> findallForSite(long custid, long siteid);

}
