package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.DoorManagementDoorGroupModal;

@Repository
public interface DoorManagementDoorGroupRepository extends JpaRepository<DoorManagementDoorGroupModal, Long> {

	DoorManagementDoorGroupModal findBydoorGroupName(String doorGroupName);

	DoorManagementDoorGroupModal findBydgroupid(long doorgroupid);

	@Modifying
	@Query(value = "delete FROM  doorsystem.t_doormanagementdoorgroup_door_mapping_table where dgroupid=:doorgroupid",nativeQuery=true)
	void deleteMappedDoor(long doorgroupid);

	
	@Modifying
	@Query(value = "delete FROM  doorsystem.t_person_doorgroup_mapping_table where dgroupid=:doorgroupid",nativeQuery=true)
	void deleteMappedPerson(long doorgroupid);

	@Query(value = "select * FROM  doorsystem.doormanagement_door_group_table where door_group_name=:doorGroupName and custid=:custid and siteid=:siteid",nativeQuery=true)
	DoorManagementDoorGroupModal findDoorGroup(String doorGroupName, long custid, long siteid);

	@Query(value = "select * FROM  doorsystem.doormanagement_door_group_table where  custid=:custid and siteid=:siteid",nativeQuery=true)
	List<DoorManagementDoorGroupModal> findAllDoorGroups(long siteid, long custid);

	
	@Query(value = "select * FROM  doorsystem.doormanagement_door_group_table where  custid=:custid",nativeQuery=true)
	List<DoorManagementDoorGroupModal> findAllDoorGroupsforCustomer(long custid);


}
