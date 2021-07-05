package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ResidentModal;

@Repository
public interface ResidentRepository extends JpaRepository<ResidentModal, Long> {

	List<ResidentModal> findBycustomerid(long custID);

	ResidentModal findBypersonName(String personName);

	ResidentModal findByresidentid(long residentid);

}
