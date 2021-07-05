package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.StaffAccessAndOptions;

@Repository
public interface SatffAccessAndOptionRepository  extends JpaRepository<StaffAccessAndOptions, Long>{

	StaffAccessAndOptions findBystaffaccessid(long staffaccessid);

	List<StaffAccessAndOptions> findBycustomerid(long custId);

	

	StaffAccessAndOptions findBystaff(long staff);

	
	@Query(value = "select * from doorsystem.staff_access_options  where customerid =:custId and siteid=:siteid",nativeQuery=true)
	List<StaffAccessAndOptions> findbycustomerid(long custId, long siteid);

}
