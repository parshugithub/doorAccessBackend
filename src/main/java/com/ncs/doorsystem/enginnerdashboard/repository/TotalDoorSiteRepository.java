package com.ncs.doorsystem.enginnerdashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.TotalDoorModal;

@Repository
public interface TotalDoorSiteRepository extends JpaRepository<TotalDoorModal, Long> {

//	TotalDoorModal findbyDoorDeviceId(long doorDeviceId);

	
	@Query(value = "select * from doorsystem.customer_site_door_tablewhere door_device_id =:doorDeviceId and door_no =:doorNo",nativeQuery=true)
	TotalDoorModal findyDoorDeviceId(long doorDeviceId, long doorNo);

	@Query(value = "select * from doorsystem.customer_site_door_table where customerid =:custid and siteid =:siteid",nativeQuery=true)
	List<TotalDoorModal> findDoor(long custid, long siteid);

}
