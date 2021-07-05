package com.ncs.doorsystem.enginnerdashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.PowerOnRestDoorModel;


@Repository
public interface PowerOnResetRepository  extends JpaRepository<PowerOnRestDoorModel,Integer>{

	PowerOnRestDoorModel findBydoorid(int doorid);

	PowerOnRestDoorModel findByactivatedondoor(int activated_on_door);

}
