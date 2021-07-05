package com.ncs.doorsystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.entity.SipSettingEntity;
import com.ncs.doorsystem.repository.SipSettingRepository;

@Service
@Transactional
public class SipSettingService 
{
	@Autowired
	SipSettingRepository repo;

	public List<SipSettingEntity> getAllSipsetting(long custid) {
		List<SipSettingEntity> result = repo.findBycustid(custid);
		if(result!=null)
		{
			return result;
		}
		return null;
	}

	public SipSettingEntity createNewsipSetting(@Valid SipSettingEntity modal, long custid) throws Exception
	{
		SipSettingEntity res= repo.findByserverAddress(modal.getServerAddress());
//		if(res!=null)
//		{
//			throw new Exception("The Sip Server alreday existes");
//			res.setCustid(custid);
//			res.setCreateddate(modal.getCreateddate());
//			res.setPortNumber(modal.getPortNumber());
//			res.setRegisterInterval(modal.getRegisterInterval());
//			res.setServerAddress(modal.getServerAddress());
//			SipSettingEntity response = repo.save(res);
//			return response;
//		}
//		else
//		{
			modal.setCustid(custid);
			SipSettingEntity response = repo.save(modal);
			return response;
		//}
		// TODO Auto-generated method stub
		  
	}

	public SipSettingEntity getSipSetting(long id) {
		SipSettingEntity response = repo.findById(id).get();
		if(response!=null)
			
		{
			return response;
			
		}
		return null;
	}

	public ResponseEntity<Object> deleteSipSetting(long id) {
		SipSettingEntity response = repo.findById(id).get();
		if(response!=null)
		{
			repo.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted specified record");
		}
		return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
	}

	public SipSettingEntity upadteNewsipSetting(long id,long custid,SipSettingEntity modal ) {
		SipSettingEntity response = repo.findById(id).get();
		if(response!=null)
		{
			response.setCustid(custid);
			response.setCreateddate(modal.getCreateddate());
			response.setPortNumber(modal.getPortNumber());
			response.setRegisterInterval(modal.getRegisterInterval());
			response.setServerAddress(modal.getServerAddress());
			SipSettingEntity res = repo.save(response);
			return response;
			
		}
		return modal;
	}
	

}
