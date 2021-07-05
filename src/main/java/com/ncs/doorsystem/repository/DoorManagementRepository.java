package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.entity.DoorManagementModal;

public interface DoorManagementRepository  extends JpaRepository<DoorManagementModal, Long>{

	
	@Query(value = "SELECT * FROM  doorsystem.doormanagement_door_table where (doorname=:doorname And custid=:custid) And siteid=:siteid",nativeQuery=true)
	DoorManagementModal findbyDoorAndcust(String doorname, long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.doormanagement_door_table where  custid=:custid And siteid=:siteid",nativeQuery=true)
	List<DoorManagementModal> findbyCustAndSite(long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.doormanagement_door_table where  custid=:custid",nativeQuery=true)
	List<DoorManagementModal> findbyCust(long custid);

}
