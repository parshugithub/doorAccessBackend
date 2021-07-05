package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	Customer findByEmailId(String emailId);
	Customer findUserByEmailIdAndPassword(String emailID,String password);
	//String findById(long custid);
	Customer findById(long custid);
	Customer findByid(long id);
}
