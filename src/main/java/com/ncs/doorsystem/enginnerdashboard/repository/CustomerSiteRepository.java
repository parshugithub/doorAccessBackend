package com.ncs.doorsystem.enginnerdashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerSiteModal;

@Repository
public interface CustomerSiteRepository  extends JpaRepository<CustomerSiteModal, Long>{

	
	@Query(value = "select * from doorsystem.customer_site_table where deviceid =:deviceID and customerid =:custid",nativeQuery=true)
	CustomerSiteModal findbyDeviceidandcustid(long deviceID, long custid);

	List<CustomerSiteModal> findBycustomerid(long custid);

	CustomerSiteModal findBysiteid(long siteid);

}
