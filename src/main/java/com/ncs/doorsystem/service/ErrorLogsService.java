package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.repository.ErrorLogsRepository;

@Service
@Transactional
public class ErrorLogsService 
{
	@Autowired
	ErrorLogsRepository repo;

	public ErrorLogsModal createErrorLogs(ErrorLogsModal modalObj) 
	{
		
		return repo.save(modalObj);
	}

	public ErrorLogsModal updateErrorLogs(ErrorLogsModal updateModalObj, long srno) 
	{
		ErrorLogsModal oldObj= repo.findBysrNo(srno);
		
		if(oldObj!=null)
		{
			oldObj.setDateAndTime(updateModalObj.getDateAndTime());
			oldObj.setDeviceId(updateModalObj.getDeviceId());
			oldObj.setErrorDescription(updateModalObj.getErrorDescription());
			//oldObj.setErrorType(updateModalObj.getErrorType());
			oldObj.setStatus(updateModalObj.getStatus());
			
			ErrorLogsModal updatedObj = repo.save(oldObj);
			return updatedObj;
			//oldObj.set
			
		}
		return null;
	}

	public int deleteErrorLogs(long srno) {
		if(repo.findById(srno).isPresent())
		{
			return repo.deleteBysrNo(srno);
		}
		return 1;
	}

	public List<ErrorLogsModal> findAll(long deviceid) 
	{
		List<ErrorLogsModal> res = repo.findBydeviceId(deviceid);
		
		 return res;
	}

	public List<ErrorLogsModal> findAllBydate(String startdate, String enddate) 
	{
		List<ErrorLogsModal> result=	repo.getAllBetweenDate(startdate,enddate);
		return result;
	}

}
