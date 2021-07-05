package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonModal;

@Repository
public interface PersonRepository  extends JpaRepository<PersonModal, Long>{

	List<PersonModal> findBywebappPerosnId(long custID);

	@Query("select p from PersonModal p where p.webappPerosnId = :custID and p.siteid = :siteid")
	List<PersonModal> findBywebappPerosnIdAndsiteid(long custID, long siteid);

	@Query(value = "select * from doorsystem.person_table where webapp_perosn_id =:custid and mobile_number =:mobileNumber",nativeQuery=true)
	
	PersonModal findmobileNumber(String mobileNumber, long custid);

	PersonModal findBypersonid(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_person_persongroup_mapping_table where person_id=:personid",nativeQuery=true)
	void deleteMappedPersonGroup(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_person_doorgroup_mapping_table where person_id=:personid",nativeQuery=true)
	void deleteMappedDoorGroup(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_person_totaldoor_mapping_table where person_id=:personid",nativeQuery=true)
	void deleteMappedDoor(long personid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_person_schedule_mapping_table where person_id=:personid",nativeQuery=true)
	void deleteMappedSchedule(long personid);

	
//	@Query(value = "select * from doorsystem.person_table where personclassid =:personclassid",nativeQuery=true)
//
//	PersonModal findPersonclss(long personclassid);

}
