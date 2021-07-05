package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;

@Repository
public interface ErrorLogsRepository extends JpaRepository<ErrorLogsModal, Long> 
{

	ErrorLogsModal findBysrNo(long srno);

	int deleteBysrNo(long srno);
	@Query(value = "SELECT u FROM ErrorLogsModal u")
	List<ErrorLogsModal> getEvents();

	List<ErrorLogsModal> findBydeviceId(long deviceid);
	
	@Query(value = "from ErrorLogsModal where dateAndTime BETWEEN :startdate AND :enddate")
	List<ErrorLogsModal> getAllBetweenDate(String startdate, String enddate);
	

}
