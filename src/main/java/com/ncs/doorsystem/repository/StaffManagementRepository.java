package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.StaffManagementModal;

@Repository
public interface StaffManagementRepository extends JpaRepository<StaffManagementModal, Long> 
{

	StaffManagementModal findBycustomerId(String customerId);

	StaffManagementModal findBypayrollno(String payrollNo);

	StaffManagementModal findBystaffId(long staffId);

	int deleteBystaffId(long staffId);
	

}
