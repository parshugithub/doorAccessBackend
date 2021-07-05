package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.doorsystem.entity.StaffGroupManytoMany;

public interface StaffGroupMainRepository extends JpaRepository<StaffGroupManytoMany, Long> {

}
