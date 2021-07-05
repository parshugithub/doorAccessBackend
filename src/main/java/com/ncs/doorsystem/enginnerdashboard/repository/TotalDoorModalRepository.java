package com.ncs.doorsystem.enginnerdashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.TotalDoorModal;

@Repository
public interface TotalDoorModalRepository extends JpaRepository<TotalDoorModal, Long> {

	
	@Query(value = "select * from doorsystem.customer_site_door_table where customerid =:custid And siteid=:siteid",nativeQuery=true)
	List<TotalDoorModal> getAllDoors(long custid, long siteid);

	@Query(value = "select * from doorsystem.customer_site_door_table where door_no =:doorNo And siteid=:siteid",nativeQuery=true)
	TotalDoorModal findDoor(long doorNo, long siteid);

}
