package com.ncs.doorsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.UserTypeModal;
import com.ncs.doorsystem.repository.UsertypeRepository;

@Service
public class UserTypeService 
{
	@Autowired 
	UsertypeRepository userRpo;

	public List<UserTypeModal> getAllUserTypes()
	{
		//		List<UserTypeModal> list = new ArrayList<UserTypeModal>();
		//	 userRpo.findAll().forEach(list::add);
		UserTypeModal typeModal = new UserTypeModal();
		//	 	 userRpo.findAll();
		List<UserTypeModal> list= userRpo.findAll();

		return list;
	}

}
