package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;


@Repository
public interface TradeCodeAndDoorRepository extends JpaRepository<TradeCodesAndDoorModal, Long> {

	TradeCodesAndDoorModal findBytradecode(long tradecode);

	List<TradeCodesAndDoorModal> findBycustomerid(long custId);

	TradeCodesAndDoorModal findBytradid(long tradeid);

	TradeCodesAndDoorModal findByscheduleno(long scheduleno);

	TradeCodesAndDoorModal findBytradeNo(long tradeid);
	
	@Query(value = "select * from doorsystem.trade_schedule_table  where (trade_no =:tradeid and customerid=:custid) And siteid=:siteid",nativeQuery=true)
	TradeCodesAndDoorModal findbytradeNoAndCustomerAndSite(long tradeid, long custid, long siteid);
	@Query(value = "select * from doorsystem.trade_schedule_table  where customerid=:custId And siteid=:siteid",nativeQuery=true)
	List<TradeCodesAndDoorModal> findbycustomerid(long custId, long siteid);

}
