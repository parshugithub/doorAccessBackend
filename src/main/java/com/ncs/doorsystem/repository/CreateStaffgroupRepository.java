package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.doorsystem.entity.CreateStaffModal;
import com.ncs.doorsystem.entity.CreateStaffgroupModal;

public interface CreateStaffgroupRepository extends JpaRepository<CreateStaffgroupModal, Long> {

	CreateStaffgroupModal findBystaffGroupName(String staffGroupName);

	CreateStaffgroupModal findBygroupid(long groupid);

	int deleteBygroupid(long groupid);

	List<CreateStaffgroupModal> findBycustomerid(long custid);

}
