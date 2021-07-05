package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ncs.doorsystem.entity.SchedulesValuesModal;

@Repository
public interface SchedulesRepository extends JpaRepository<SchedulesValuesModal, Long> {

	@Query(value = "SELECT s.hours FROM schedules_values_modal_hours s ",nativeQuery=true)
	List<Object> getHours();
	
	

	@Query(value = "SELECT s.minutes FROM schedules_values_modal_minutes s ",nativeQuery=true)
	List<Object> getMinutes();

	@Query(value = "SELECT s.days FROM schedules_values_modal_days s ",nativeQuery=true)
	List<Object> getDays();


	@Query(value = "SELECT days FROM doorsystem.schedules_values_modal_days  where days=:day",nativeQuery=true)
	String getday(String day);

}
