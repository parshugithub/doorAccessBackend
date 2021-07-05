package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonMangementPersonModal;
import com.ncs.doorsystem.entity.PersonModal;

@Repository
public interface PersonManagementRepository extends JpaRepository<PersonMangementPersonModal, Long> 
{
	List<PersonMangementPersonModal> findBywebappPerosnId(long custID);

	@Query("select p from PersonMangementPersonModal p where p.webappPerosnId = :custID and p.siteid = :siteid")
	List<PersonMangementPersonModal> findBywebappPerosnIdAndsiteid(long custID, long siteid);

	@Query(value = "select * from doorsystem.person_management_table where webapp_perosn_id =:custid and mobile_number =:mobileNumber",nativeQuery=true)
	
	PersonMangementPersonModal findmobileNumber(String mobileNumber, long custid);

	PersonMangementPersonModal findBypid(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_personmanagment_persongroup_mapping_table where pid=:personid",nativeQuery=true)
	void deleteMappedPersonGroup(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_personmanagment_doorgroup_mapping_table where pid=:personid",nativeQuery=true)
	void deleteMappedDoorGroup(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_personmanagment_totaldoor_mapping_table where pid=:personid",nativeQuery=true)
	void deleteMappedDoor(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_personmanagment_schedule_mapping_table where pid=:personid",nativeQuery=true)
	void deleteMappedSchedule(long personid);

	PersonMangementPersonModal findBymobileNumber(String personid);

	
//	@Query(value = "select * from doorsystem.person_table where personclassid =:personclassid",nativeQuery=true)
//
//	PersonModal findPersonclss(long personclassid);




}
