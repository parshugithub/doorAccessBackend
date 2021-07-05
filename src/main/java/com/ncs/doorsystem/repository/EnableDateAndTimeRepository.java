package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.EnableDateAndTime;

@Repository
public interface EnableDateAndTimeRepository extends JpaRepository<EnableDateAndTime, Long> {

	EnableDateAndTime findByid(long id);

}
