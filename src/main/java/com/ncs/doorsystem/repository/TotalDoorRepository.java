package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.entity.TotalDoorsModal;

@Repository
public interface TotalDoorRepository extends JpaRepository<TotalDoorsModal, Long> 
{
	@Query(value = "SELECT u FROM TotalDoorsModal u")
	List<TotalDoorsModal> getDoors();

	TotalDoorsModal findBydoorName(long doorname);

	TotalDoorsModal findBydoorId(int doorId);

}
