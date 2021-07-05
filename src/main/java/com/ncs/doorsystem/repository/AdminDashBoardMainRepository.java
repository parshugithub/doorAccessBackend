package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.Customer;

@Repository
public interface AdminDashBoardMainRepository extends JpaRepository<Customer, Long> 
{

}
