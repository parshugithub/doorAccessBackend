package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ProgramToSite;

@Repository
public interface ProgramToSiteRepository extends JpaRepository<ProgramToSite, Long> {

}
