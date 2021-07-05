package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ChannelsModal;

@Repository
public interface ChannelsRepository extends JpaRepository<ChannelsModal, Long> {

	List<ChannelsModal> findBycustomerid(long custID);

	ChannelsModal findBychannel(long channel);

	ChannelsModal findByflat(long flat);
	
	@Query(value = "SELECT flat FROM  doorsystem.channels where flat=:flat",nativeQuery=true)
	long getflat(long flat);
	

	ChannelsModal findByppp(long ppp);

	//List<ChannelsModal> findBychannelInAndflotInAndpppIn(long channel, long flot, long ppp);

//	List<ChannelsModal> findByChannelIgnoreCaseContainingOrFlotIgnoreCaseContainingOrPppIgnoreCaseContaining(
//			long channel, long flot, long ppp);

	List<ChannelsModal> findByChannelAndFlatAndPpp(long channel, long flot, long ppp);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custID And siteid=:siteid",nativeQuery=true)
	List<ChannelsModal> findBycustomeridAndsiteid(long custID, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custid And siteid=:siteid And channel=:channel",nativeQuery=true)
	ChannelsModal findchannelForSiteAndCustomer(long channel, long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custid And siteid=:siteid And flat=:flat",nativeQuery=true)
	ChannelsModal findByflatForSiteAndCustomer(long flat, long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custid And siteid=:siteid And ppp=:ppp",nativeQuery=true)
	ChannelsModal findBypppForSiteAndCustomer(long ppp, long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custid And siteid=:siteid And flat=:flatNumber",nativeQuery=true)
	ChannelsModal findbyflat(long flatNumber, long custid, long siteid);

	@Query(value = "SELECT * FROM  doorsystem.channels where customerid=:custid And siteid=:siteid",nativeQuery=true)
	List<ChannelsModal> findAllBasedOnCustIdAndSiteid(long custid, long siteid);

}
