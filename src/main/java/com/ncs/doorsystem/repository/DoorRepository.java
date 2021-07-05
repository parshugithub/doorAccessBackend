package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.doorsystem.entity.Door;

public interface DoorRepository  extends JpaRepository<Door, Long>{

	List<Door> findBycustomerid(long custID);

	//Door findBydoor(long door);

	Door findBydoorid(long doorid);

	int deleteBydoorid(long doorid);

	Door findBydoorName(long door);

}
