package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.AccessLevels;

@Repository
public interface AccesslevelsRepository extends JpaRepository<AccessLevels, Long> {

}
