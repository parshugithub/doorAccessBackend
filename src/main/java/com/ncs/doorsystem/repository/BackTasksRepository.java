package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.BackTasksModal;

@Repository
public interface BackTasksRepository extends JpaRepository<BackTasksModal, Long> 
{

	BackTasksModal findBytaskNo(String siteval);

	

	int deleteBytaskNo(long taskNo);



	List<BackTasksModal> findBytaskId(long taskId);



	@Query(value = "SELECT * FROM  doorsystem.backtask_table where deviceid=:deviceid",nativeQuery=true)
	List<BackTasksModal> findbyPendingstatus(long deviceid);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%Site ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithSiteID(String siteval);
	
	@Query(value = "from BackTasksModal t where dateAndTime BETWEEN :startDate AND :endDate")
	public List<BackTasksModal> getAllBetweenDates(String startDate,String endDate);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%Staff ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithstaffID(String siteval);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%Door ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithDoorID(String siteval);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%Doorgroup ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithDoorgroupID(String siteval);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%person ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithpersonID(String siteval);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%TradeCode ID%';",nativeQuery=true)
	List<BackTasksModal> getBackTaskWithTradeCodeID(String siteval);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%:personID%';",nativeQuery=true)
	BackTasksModal getBackTaskWithPersonID(String personID);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no LIKE '%:staffID%';",nativeQuery=true)
	BackTasksModal getBackTaskWithStaffID(String staffID);
	
	@Query(value = "SELECT * FROM  doorsystem.backtask_table where task_no=:staffID and deviceid =:deviceid ",nativeQuery=true)
	BackTasksModal getBackTaskWithStaffID1(String staffID, String deviceid);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE deviceid =:deviceid",nativeQuery=true)
	List<BackTasksModal> finddeviceid(long deviceid);

	@Modifying
	@Query(value = "delete FROM doorsystem.backtask_table where task_no=:staffids",nativeQuery=true)
	int deleteId(String staffids);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE task_no =:siteval",nativeQuery=true)
	BackTasksModal getBackTaskWith(String siteval);


	
	BackTasksModal findBydeviceid(long deviceid);


	@Query(value = "SELECT * FROM doorsystem.backtask_table WHERE deviceid =:string and task_no =:staffid",nativeQuery=true)
	BackTasksModal findtaskNoAnddeviceid(String staffid, long string);
	
	//BackTasksModal getBackTaskWithstaffID(String siteval);

}
