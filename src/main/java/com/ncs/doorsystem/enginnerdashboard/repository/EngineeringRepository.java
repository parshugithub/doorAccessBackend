package com.ncs.doorsystem.enginnerdashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.EngineerEntity;

@Repository
public interface EngineeringRepository extends JpaRepository<EngineerEntity, Long> {

	

	long deleteByengID(long id);

	EngineerEntity findByemployeeID(String employeeID);

	EngineerEntity findByuserName(String userName);

	EngineerEntity findBypassword(String password);

	EngineerEntity findByengID(long id);

	@Query(value = "SELECT * FROM  doorsystem.engneer_profile where user_name=:emailid and password=:pass",nativeQuery=true)
	EngineerEntity finduser(String emailid, String pass);

}
