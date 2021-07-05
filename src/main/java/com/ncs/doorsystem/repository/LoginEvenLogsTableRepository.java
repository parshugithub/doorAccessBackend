package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.LoginEvenLogsTable;

@Repository
public interface LoginEvenLogsTableRepository extends JpaRepository<LoginEvenLogsTable, Long> {

	
	@Query(value = "from LoginEvenLogsTable where updatedDate BETWEEN :startdate AND :enddate")
	List<LoginEvenLogsTable> getAllBetweenDate(String startdate, String enddate);

	List<LoginEvenLogsTable> findBycutomerid(long custid);

	List<LoginEvenLogsTable> findByusername(String username);
	
	@Query(value = "select *  from doorsystem.login_events_logs_table where username=:username",nativeQuery=true)
	List<LoginEvenLogsTable> finduserName(String username);

	@Query(value = "select *  from doorsystem.login_events_logs_table where (user_type is not null and cutomerid=:custid) and username=:username  ",nativeQuery=true)
	List<LoginEvenLogsTable> findbyusername(long custid, String username);

	@Query(value = "select *  from doorsystem.login_events_logs_table where user_type is null and cutomerid=:custid",nativeQuery=true)
	List<LoginEvenLogsTable> findbycutomerid( long custid);

	@Query(value = "select *  from doorsystem.login_events_logs_table where (user_type=:string or user_type is null) and cutomerid=:custid ",nativeQuery=true)
	List<LoginEvenLogsTable> findbywebapp(String string, long custid);

	@Query(value = "select *  from doorsystem.login_events_logs_table where user_type=:string and cutomerid=:custid",nativeQuery=true)
	List<LoginEvenLogsTable> findbyusertype(String string, long custid);

}
