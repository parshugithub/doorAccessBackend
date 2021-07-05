package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;

@Repository
public interface SiteControllerEventsLongsRepository extends JpaRepository<SiteControllerEventsLongsModal, Long> {

	SiteControllerEventsLongsModal findBysrNo(long srNo);
	
	
	@Query(value = "SELECT * FROM doorsystem.sitecontroller_events_logs  where site=:site",nativeQuery=true)
	List<SiteControllerEventsLongsModal> getAll(long site);

	int deleteBysrNo(long srNo);
	
	@Query(value = "from SiteControllerEventsLongsModal where dateAndTime BETWEEN :startdate AND :enddate")
	List<SiteControllerEventsLongsModal> getAllBetweenDate(String startdate, String enddate);

//	List<SiteControllerEventsLongsModal> findBysite(String site);

}
