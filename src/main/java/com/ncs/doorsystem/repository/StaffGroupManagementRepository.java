package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.StaffGroupManagementModal;

@Repository
public interface StaffGroupManagementRepository extends JpaRepository<StaffGroupManagementModal, Long> {

	StaffGroupManagementModal findBystaffGroupName(String staffGroupName);

}
