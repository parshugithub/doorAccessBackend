package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.TradeCodeWithDoorModal;

@Repository
public interface TradeCodeWithDoorRepository extends JpaRepository<TradeCodeWithDoorModal, Long> {

	List<TradeCodeWithDoorModal> findBycustomerid(long custId);

	TradeCodeWithDoorModal findBydoorNumber(long doorNumber);

	TradeCodeWithDoorModal findBytdid(long tradeid);
	
	@Query(value = "select c.tradecode,e.door_number,e.lock_time from doorsystem.trade_schedule_table as c\n"
			+ "	inner join doorsystem.tradecode_door_table as e\n"
			+ "	where c.scheduleno =:scheduleno AND e.scheduleno=:scheduleno and c.siteid=:l AND e.siteid=:l AND e.door_number=:m ",nativeQuery=true)
	String getDoorTrade(long scheduleno, long l, long m);

	TradeCodeWithDoorModal findByscheduleno(long scheduleno);

	//TradeCodeWithDoorModal finddoorNumberForClient(long doorNumber, long custid);
	@Query(value = "select * from doorsystem.tradecode_door_table  where door_number =:doorNumber and customerid=:custid",nativeQuery=true)
	TradeCodeWithDoorModal finddoorNumberForClient(long doorNumber, long custid);

	@Query(value = "select * from doorsystem.tradecode_door_table  where siteid =:siteid and customerid=:custId",nativeQuery=true)
	List<TradeCodeWithDoorModal> findbycustomerid(long custId, long siteid);
	
	

}
