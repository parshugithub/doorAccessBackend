package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.DoorDescriptionModal;

@Repository
public interface DoorDescriptionRepository extends JpaRepository<DoorDescriptionModal, Long> 
{

	List<DoorDescriptionModal> findBysiteid(long siteid);

	DoorDescriptionModal findBydoor(long door);

	DoorDescriptionModal findBydoorDesId(long doorDesId);

	@Modifying
	@Query(value = "delete FROM doorsystem.door_description where door=:doorDesId And siteid=:siteid",nativeQuery=true)
	int deleteDoorDescription(long doorDesId, long siteid);

	@Query(value = "select * FROM doorsystem.door_description where door=:doorDesId ",nativeQuery=true)
	DoorDescriptionModal finddoorDesId(long doorDesId);

}