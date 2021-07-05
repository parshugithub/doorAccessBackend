package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.ScheduleDays;
import com.ncs.doorsystem.entity.ScheduleMainModal;

@Repository
public interface ScheduleMainRepository extends JpaRepository<ScheduleMainModal, Long> {

	List<ScheduleMainModal> findBycustomerid(long custId);

	ScheduleMainModal findByscheduleId(long scheduleno);

	@Query("select s.scheduleId from ScheduleMainModal s where s.scheduleId = :scheduleId ")
	long findscheduleId(long scheduleId);

	@Query(value = "select * from doorsystem.schedule_main  where schedule_id =:scheduleid and customerid=:custid",nativeQuery=true)
	ScheduleMainModal findscheduleIdForClient(long scheduleid, long custid);

	@Query(value = "select * from doorsystem.schedule_main  where siteid =:siteid and customerid=:custId",nativeQuery=true)
	List<ScheduleMainModal> findbycustomeridAndSite(long custId, long siteid);

	@Query(value = "select * from doorsystem.schedule_days  where day =:day and schedule_id=:scheduleId",nativeQuery=true)
	List<ScheduleDays> findScheduleDays(String day, long scheduleId);

	@Query(value = "select * from doorsystem.schedule_main  where (schedule =:schedule and customerid=:custid) and siteid =:siteid",nativeQuery=true)
	ScheduleMainModal findscheduleIdForClientAndSite(long schedule, long custid, long siteid);
	@Query(value = "select * from doorsystem.schedule_main  where  customerid=:custId",nativeQuery=true)
	List<ScheduleMainModal> findbycustomerid(long custId);

	@Query(value = "select * from doorsystem.schedule_main  where (schedule =:scheduleno and customerid=:custid) and siteid =:siteid",nativeQuery=true)
	ScheduleMainModal findbyscheduleIdForCustAndsite(long scheduleno, long custid, long siteid);
}
