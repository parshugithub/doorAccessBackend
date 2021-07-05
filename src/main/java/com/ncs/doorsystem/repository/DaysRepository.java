package com.ncs.doorsystem.repository;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.Days;

@Repository
public interface DaysRepository  extends JpaRepository<Days, Long>{

	
	@Query(value = "SELECT * FROM  doorsystem.days where day=:day",nativeQuery=true)
	
	Days getday(String day);

}
