package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.doorsystem.entity.SipSettingEntity;

public interface SipSettingRepository extends JpaRepository<SipSettingEntity, Long> {

	List<SipSettingEntity> findBycustid(long custid);

	SipSettingEntity findByserverAddress(String serverAddress);

}
