package com.ncs.doorsystem.enginnerdashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.doorsystem.enginnerdashboard.entity.LossOfCanBus;



public interface LossOfCanBusRepository extends JpaRepository<LossOfCanBus ,Integer> {

	
	LossOfCanBus findBydoorid(int doorid);

	LossOfCanBus findByactivatedondoor(int activated_on_door);
}
