package com.ncs.doorsystem.enginnerdashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.LockDownModel;



@Repository
public interface LockdownRepository extends JpaRepository<LockDownModel,Integer> {

	LockDownModel findBydoorid(int doorid);

	int deleteBydoorid(int doorid);

	LockDownModel findByactivatedondoor(int activated_on_door);

}
