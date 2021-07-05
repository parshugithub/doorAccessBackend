package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.VoiceOperatorModal;

@Repository
public interface VoiceOperatorRepository extends JpaRepository<VoiceOperatorModal, Long> {

	int deleteByuserName(String userName);

	@Query(value = "DELETE FROM voice_operator v WHERE v.user_name=:userName",nativeQuery=true)
	ResponseEntity<Object> deleteuserName(String userName);

	

	boolean findByuserName(String userName);

}
