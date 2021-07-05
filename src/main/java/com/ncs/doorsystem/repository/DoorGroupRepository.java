package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.DoorGroupModal;


@Repository
public interface DoorGroupRepository extends JpaRepository<DoorGroupModal, Long> {

	DoorGroupModal findBydoorGroupName(String doorGroupName);

	DoorGroupModal findBydoorgroupid(long doorgroupid);

	@Modifying
	@Query(value = "delete FROM  doorsystem.t_doorgroup_door_mapping_table where doorgroupid=:doorgroupid",nativeQuery=true)
	void deleteMappedDoor(long doorgroupid);

	
	@Modifying
	@Query(value = "delete FROM  doorsystem.t_person_doorgroup_mapping_table where doorgroupid=:doorgroupid",nativeQuery=true)
	void deleteMappedPerson(long doorgroupid);

	@Query(value = "select * FROM  doorsystem.door_group_table where door_group_name=:doorGroupName and custid=:custid and siteid=:siteid",nativeQuery=true)
	DoorGroupModal findDoorGroup(String doorGroupName, long custid, long siteid);

	@Query(value = "select * FROM  doorsystem.door_group_table where  custid=:custid and siteid=:siteid",nativeQuery=true)
	List<DoorGroupModal> findAllDoorGroups(long siteid, long custid);

}
