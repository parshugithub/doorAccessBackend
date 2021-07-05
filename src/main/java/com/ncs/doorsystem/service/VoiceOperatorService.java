package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.VoiceOperatorModal;
import com.ncs.doorsystem.repository.UserManagementRepository;
import com.ncs.doorsystem.repository.VoiceOperatorRepository;

@Service
@Transactional
public class VoiceOperatorService 
{
	@Autowired
	VoiceOperatorRepository voiceRepo;
	
	@Autowired
	UserManagementRepository userRepo;

	public List<CreateUserModal> getAllVoiceOperators(long custId)
	{
		String voiceOperator ="Voice Operator";
		List<CreateUserModal> voiceoperator =userRepo.getAllVoiceOperator(voiceOperator,custId);
		
		return voiceoperator;
	}

	public String createVoiceOperator(@Valid VoiceOperatorModal modal, long custid, long siteid) 
	{
		System.out.println("The values "+modal.getIsVoiceOperatot());
		if(modal.getIsVoiceOperatot()==1)
		{
			modal.setSiteid(siteid);
			modal.setCustid(custid);
			VoiceOperatorModal values= voiceRepo.save(modal);
			
				return "Created successfully";
			
		}
		else
		{
			voiceRepo.deleteByuserName(modal.getUserName());
			
			
			return"Deleted successfully";
		}
		
	}

}
