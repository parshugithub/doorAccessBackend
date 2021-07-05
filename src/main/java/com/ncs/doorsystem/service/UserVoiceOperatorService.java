package com.ncs.doorsystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.UserAsVoiceOperator;
import com.ncs.doorsystem.repository.UserVoiceOperatorRepository;

@Service
public class UserVoiceOperatorService 
{
	@Autowired
	UserVoiceOperatorRepository repo;

	public List<UserAsVoiceOperator> getAllVoiceOperators(long custId) {
		List<UserAsVoiceOperator> result = repo.findBycustid(custId);
	
		return result;
	}

	public UserAsVoiceOperator createVoiceOperator(@Valid UserAsVoiceOperator modal, long custid, long siteid,
			long userid) {
		
		UserAsVoiceOperator res = repo.findBysitename(modal.getSitename());
		if(res!=null)
		{
			res.setCreatedDate(res.getCreatedDate());
			res.setUpdatedDate(modal.getCreatedDate());
			res.setCustid(custid);
			res.setSiteid(siteid);
			res.setUserid(userid);
			res.setIsVoiceoperator(modal.getIsVoiceoperator());
			res.setSitename(modal.getSitename());
			UserAsVoiceOperator result = repo.save(res);
			return result;
		}
		else
		{
			modal.setCustid(custid);
			modal.setSiteid(siteid);
			modal.setUserid(userid);
			modal.setCreatedDate(modal.getCreatedDate());
			modal.setUpdatedDate(modal.getCreatedDate());
			UserAsVoiceOperator result =  repo.save(modal);
			return result;
			
			
		}
		
	}

}
