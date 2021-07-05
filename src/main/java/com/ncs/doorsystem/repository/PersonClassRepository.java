package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonClassModal;

@Repository
public interface PersonClassRepository extends JpaRepository<PersonClassModal, Long> {

	List<PersonClassModal> findBywebAppPersonClassid(long custid);

	PersonClassModal findBypersonClassName(String personClassName);

	PersonClassModal findBypersonclassid(long personclassid);
	@Modifying
	@Query(value = "delete from doorsystem.t_person_personclass_mapping_table  WHERE personclassid = :personid",nativeQuery=true)
	void deleteMappedpersobclass(long personid);

	@Query(value = "select count(*) from doorsystem.t_person_personclass_mapping_table where personclassid =:personclassid",nativeQuery=true)
	int findPersonclss(long personclassid);

}
