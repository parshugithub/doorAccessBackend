package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.repository.EmbeddedCotrollerEventsLogsRepository;

@Service
@Transactional
public class EmbeddedCotrollerEventsLogsService 
{
	@Autowired
	EmbeddedCotrollerEventsLogsRepository repo;

	public EmbeddedCotrollerEventsLogsModal createEmbeddedControllerEvents(
			EmbeddedCotrollerEventsLogsModal modalObj)
	{
		System.out.println("obj is "+modalObj.toString());
		
		return repo.save(modalObj);
	}

	public EmbeddedCotrollerEventsLogsModal updateEmbeddedControllerEvents(
			EmbeddedCotrollerEventsLogsModal updateModalObj, long srno) 
	{
		EmbeddedCotrollerEventsLogsModal oldObj = repo.findBysrNo(srno);
		if(oldObj!=null)
		{
			oldObj.setDateAndTime(updateModalObj.getDateAndTime());
			oldObj.setDeviceId(updateModalObj.getDeviceId());
			
			oldObj.setStatus(updateModalObj.getStatus());
			
			EmbeddedCotrollerEventsLogsModal updatedObj=repo.save(oldObj);
			return updatedObj;
			
		}
		
		return null;
	}

	public int deleteEmbeddedControllerEvents(long srno) 
	{
		if(repo.findById(srno).isPresent())
		{
			System.out.println("return value "+repo.deleteBysrNo(srno));
			return repo.deleteBysrNo(srno);
		}
		return 1;
		// TODO Auto-generated method stub
		
	}

	public List<EmbeddedCotrollerEventsLogsModal> findAll(long deviceid) 
	{
		List<EmbeddedCotrollerEventsLogsModal> res = repo.findBydeviceId(deviceid);
		
		 return res;
	}

	public List<EmbeddedCotrollerEventsLogsModal> findAllBydate(String startdate, String enddate) 
	{
		List<EmbeddedCotrollerEventsLogsModal> result=	repo.getAllBetweenDate(startdate,enddate);
		return result;
	}

}
