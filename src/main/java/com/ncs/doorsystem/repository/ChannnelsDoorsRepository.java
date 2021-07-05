package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.Door;


@Repository
public interface ChannnelsDoorsRepository extends JpaRepository<Door, Long> {

	
	@Query(
			value = "SELECT * FROM doorsystem.channel_door_table t where  t.channels_id = :channelid", 
			nativeQuery=true
			)
	List<Door> findDoor(long channelid);

}
