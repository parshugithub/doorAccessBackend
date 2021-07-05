package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.StaffManagementModal;

@Repository
public interface CreateStaffRepositoty extends JpaRepository<CreateStaffModal, String> {

	CreateStaffModal findBypayrollno(String payrollno);

	//CreateStaffModal findBystaffid(long staffId);

	int deleteBystaffid(long staffId);
	CreateStaffModal findBystaffid(long staffId);

	List<CreateStaffModal> findBycustomerId(long custid);

}
