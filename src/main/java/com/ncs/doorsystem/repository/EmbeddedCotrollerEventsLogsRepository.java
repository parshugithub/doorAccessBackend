package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;

@Repository
public interface EmbeddedCotrollerEventsLogsRepository extends JpaRepository<EmbeddedCotrollerEventsLogsModal, Long> 
{

	EmbeddedCotrollerEventsLogsModal findBysrNo(long srno);

	int deleteBysrNo(long srno);

	List<EmbeddedCotrollerEventsLogsModal> findBydeviceId(long deviceid);

	@Query(value = "from EmbeddedCotrollerEventsLogsModal where dateAndTime BETWEEN :startdate AND :enddate")
	List<EmbeddedCotrollerEventsLogsModal> getAllBetweenDate(String startdate, String enddate);
	

}
