package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonManagementPersonClassModal;

public interface PersonMangementClassRepository extends JpaRepository<PersonManagementPersonClassModal, Long> 
{
	List<PersonManagementPersonClassModal> findBywebAppPersonClassid(long custid);

	PersonManagementPersonClassModal findBypersonClassName(String personClassName);

	PersonManagementPersonClassModal findBypclassid(long personclassid);
	@Modifying
	@Query(value = "delete from doorsystem.t_personmanagment_personclass_mapping_table  WHERE pclassid = :personid",nativeQuery=true)
	void deleteMappedpersobclass(long personid);

	@Query(value = "select count(*) from doorsystem.t_personmanagment_personclass_mapping_table where pclassid =:personclassid",nativeQuery=true)
	int findPersonclss(long personclassid);

	@Query(value = "select * from doorsystem.person_management_class_table where web_app_person_classid =:custid and siteid=:siteid",nativeQuery=true)
	List<PersonManagementPersonClassModal> findAllPersons(long custid, long siteid);

}
