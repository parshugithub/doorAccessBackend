package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.repository.BackTasksRepository;

@Service
@Transactional
public class BackTasksService 
{
	@Autowired
	BackTasksRepository repo;

	public BackTasksModal createBackTask(BackTasksModal modalObj) {
		
		return repo.save(modalObj);
	}

	public BackTasksModal updateBackTask(BackTasksModal updateModalObj, String taskNo)
	{
		BackTasksModal oldObj=repo.findBytaskNo(taskNo);
		if(oldObj!=null)
		{
			oldObj.setDateAndTime(updateModalObj.getDateAndTime());
			oldObj.setPriority(updateModalObj.getPriority());
			oldObj.setTaskDescription(updateModalObj.getTaskDescription());
			oldObj.setTaskNo(updateModalObj.getTaskNo());
			oldObj.setTaskStatus(updateModalObj.getTaskStatus());
			oldObj.setTaskTime(updateModalObj.getTaskTime());
			
			BackTasksModal updatedObj= repo.save(oldObj);
			return updatedObj;
		}
		
		
		return null;
	}

	public int deleteBackTask(long taskNo) {
		if(repo.findById(taskNo).isPresent())
		{
			return repo.deleteBytaskNo(taskNo);
		}
		return 1;
	}

	public List<BackTasksModal> findAll(long deviceid) {
		List<BackTasksModal> res = repo.finddeviceid(deviceid);
		
		 return res;
	}

	public List<BackTasksModal> findAllBydate(String startdate, String enddate) {
		List<BackTasksModal> result=	repo.getAllBetweenDates(startdate,enddate);
		return result;
	}
	

}
