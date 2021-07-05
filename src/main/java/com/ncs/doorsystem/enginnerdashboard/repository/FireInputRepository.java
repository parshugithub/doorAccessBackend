package com.ncs.doorsystem.enginnerdashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.enginnerdashboard.entity.FireInputModel;



public interface FireInputRepository extends JpaRepository<FireInputModel ,Integer> {
	FireInputModel findBydoorid(int doorid);

	


	FireInputModel findByactivatedondoor(int activated_on_door);
	
	
	

}
