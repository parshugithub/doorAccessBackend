package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.ErrorLogsModal;
import com.ncs.doorsystem.entity.SiteControllerEventsLongsModal;
import com.ncs.doorsystem.repository.SiteControllerEventsLongsRepository;

@Service
@Transactional
public class SiteControllerEventsLongsService
{
	@Autowired
	SiteControllerEventsLongsRepository repo;
	

	public SiteControllerEventsLongsModal createSiteControllerEventsLogs(SiteControllerEventsLongsModal modalObj)
	{
	
		return repo.save(modalObj);
	}

	public SiteControllerEventsLongsModal updateSiteControllerEventsLogs(SiteControllerEventsLongsModal updateModalObj,
			long srNo) {
		SiteControllerEventsLongsModal oldObj = repo.findBysrNo(srNo);
		if(oldObj!=null)
		{
			oldObj.setDateAndTime(updateModalObj.getDateAndTime());
			oldObj.setDeviceData(updateModalObj.getDeviceData());
			oldObj.setEventType(updateModalObj.getEventType());
			oldObj.setMessageSuccess(updateModalObj.getMessageSuccess());
		//	oldObj.setPersonclass(updateModalObj.getPersonclass());
			oldObj.setPersonName(updateModalObj.getPersonName());
			oldObj.setPhysicalAccessAuthorised(updateModalObj.getPhysicalAccessAuthorised());
			//oldObj.setProperty(updateModalObj.getProperty());
			//oldObj.setSite(updateModalObj.getSite());
		//	oldObj.setTagcolor(updateModalObj.getTagcolor());
			oldObj.setTwoDoorcontrollerId(updateModalObj.getTwoDoorcontrollerId());
			oldObj.setWeigendDeviceClassification(updateModalObj.getWeigendDeviceClassification());
			oldObj.setWeigendDeviceType(updateModalObj.getWeigendDeviceType());
			oldObj.setWeigendOrLockChannelNum(updateModalObj.getWeigendOrLockChannelNum());
			
			SiteControllerEventsLongsModal updatedObj =repo.save(oldObj);
			return updatedObj;
		}
		return null;
	}

	public int deleteSiteControllerEventsLogs(long srNo) {
		if(repo.findById(srNo).isPresent())
		{
			return repo.deleteBysrNo(srNo);
		}
		return 1;
	}

	public List<SiteControllerEventsLongsModal> findAll(long site) {
		
		List<SiteControllerEventsLongsModal> res = repo.getAll(site);
		
		 return res;
	}

	public List<SiteControllerEventsLongsModal> findAllBydate(String startdate, String enddate)
	{
		List<SiteControllerEventsLongsModal> result=	repo.getAllBetweenDate(startdate,enddate);
		return result;
	}
	

}
