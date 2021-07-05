package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.UserAsVoiceOperator;

@Repository
public interface UserVoiceOperatorRepository  extends JpaRepository<UserAsVoiceOperator, Long>
{

	List<UserAsVoiceOperator> findBycustid(long custId);

	UserAsVoiceOperator findByuserid(long userid);

	UserAsVoiceOperator findBysitename(String sitename);
	

}
