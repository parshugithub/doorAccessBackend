package com.ncs.doorsystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.util.concurrent.ExecutionError;
import com.ncs.doorsystem.dto.CreateSiteDto;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.DashBoardmodal;
import com.ncs.doorsystem.repository.CreateSiteRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;

@Service
@Transactional
public class DashboardSerive
{
	@Autowired
	DashBoardRepository dashRepo;
	
	@Autowired
	CreateSiteRepository siterepo;
	
	public DashBoardmodal getAllSitesCreatedByLoggedCustomer(CreateSiteModal siteModal)
	{
		dashRepo.findByCustomerName(siteModal.getCustomerName());
		
		return null;
		
	}
	
	// create the sites
	public CreateSiteModal createsite(CreateSiteModal siteModal,long custid) throws Exception
	{
		System.out.println("The values are"+ siteModal.toString());
		//CreateSiteModal checkSite = siterepo.findbysiteNameAnddeviceId(siteModal.getSiteName(),siteModal.getDeviceId());
		CreateSiteModal checkSite =siterepo.findBysiteName(siteModal.getSiteName());
//		
		CreateSiteModal checkDevideid = siterepo.findBydeviceId(siteModal.getDeviceId());
		
		//String deviceId = checkSite.getDeviceId();
		//System.out.println("The device id "+checkDevideid);
		if(checkSite==null && checkDevideid==null)
		{
			System.out.println(CustomerService.custid);
			siteModal.setCustId(custid);
			
			siterepo.save(siteModal);
			
			return siteModal;
			
			
		}
		
		else
		{
			System.out.println("is der");
			throw new Exception("The Site with "+ siteModal.getSiteName()+" Or deviceID "+siteModal.getDeviceId()+" already exists");
		}
		
//		
		
		
	}


	//get all the sites created by the logged customer
	public List<CreateSiteModal> findAllSitesOfCustomer(long custId)
	{
		
		System.out.println("service called");
		List<CreateSiteModal> siteModal = siterepo.findBycustId(custId);
	
		
		return siteModal;
	}

// search the sites
	
	public List<CreateSiteModal> searchSite(String keyword) 
	{
		if (keyword != null) {
            return siterepo.search(keyword);
        }
        return siterepo.findAll();
		
	}
	
public CreateSiteModal findSites(String sitename) {
		
	CreateSiteModal usermodal = siterepo.findBysiteName(sitename);
		return usermodal;
	}


	public CreateSiteModal updateSite(CreateSiteModal siteModal, String siteName) {
		
		System.out.println("The site is "+siteModal.getSiteName());
		CreateSiteModal  site = siterepo.findBysiteName(siteName);
		System.out.println("The site is"+site.getSiteName());
		
		site.setAddress2(siteModal.getAddress2());
		site.setArea(siteModal.getArea());
		site.setCity(siteModal.getCity());
		site.setCountry(siteModal.getCountry());
		site.setCustomerAddress(siteModal.getCustomerAddress());
		site.setCustomerName(siteModal.getCustomerName());
		site.setCustomerPhone(siteModal.getCustomerPhone());
		site.setDeviceId(siteModal.getDeviceId());
		site.setSiteReference(siteModal.getSiteReference());
		site.setAddress2(siteModal.getAddress2());
		
		CreateSiteModal updatesite = siterepo.save(site);
		return updatesite;

	}
	
	public int deleteSite(String sitename) throws Exception
	{
		int value=0;
		
		CreateSiteModal siteDelete = siterepo.findBysiteName(sitename);
		siterepo.deleteMappedSite(siteDelete.getSiteid());
		//System.out.println("The data is "+ userdelete.toString());
		if(siteDelete!=null)
		{
			System.out.println("entering");
			value= value+siterepo.deleteBysiteName(sitename);
			System.out.println("The values "+value);
			return value;
		}
		System.out.println("Valus"+value);

		return value;



	}
	

	
	
	

}
