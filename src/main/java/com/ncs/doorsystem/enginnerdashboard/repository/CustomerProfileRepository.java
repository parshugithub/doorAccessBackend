package com.ncs.doorsystem.enginnerdashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerProfile;

public interface CustomerProfileRepository  extends JpaRepository<CustomerProfile, Long>{

	CustomerProfile findBycustomerID(String customerID);

	@Query(value = "select * from doorsystem.customer_profile where customer_email =:customerEmail and customerid =:customerID",nativeQuery=true)
	CustomerProfile findbycustomerIDAndCustomerEmail(String customerID, String customerEmail);

	List<CustomerProfile> findByengId(long engid);

	CustomerProfile findBycustID(long custid);

	long deleteBycustID(long custid);

}
