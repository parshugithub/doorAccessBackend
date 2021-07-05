package com.ncs.doorsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.repository.AdminDashBoardMainRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;

@Service
public class AdminDashBoardMainService 
{
	@Autowired
	AdminDashBoardMainRepository repository;
	@Autowired
	DashBoardRepository siteRepo;
	int customerCount=0;
	int sitesCount=0;

	public int getCustomer()
	{
		List<Customer> allCustomer = repository.findAll();
		for (Customer customer : allCustomer) 
		{
			if(customer!=null)
			{
				customerCount++;
			}
			
		}
		
		return customerCount;
	}

	public int getSites() {
		List<CreateSiteModal> allSites = siteRepo.findAll();
		for (CreateSiteModal CreateSiteModal : allSites) 
		{
			if(CreateSiteModal!=null)
			{
				sitesCount++;
			}
			
		}
		
		return sitesCount;
	}

}
