package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.AccessLevels;
import com.ncs.doorsystem.repository.AccesslevelsRepository;

@Service
@Transactional
public class AccessLevelsService
{
	@Autowired
	AccesslevelsRepository repo;

	public AccessLevels createAccessLevels(AccessLevels access) {
		
		return repo.save(access);
	}

	public List<AccessLevels> getAccessLevels() {
		List<AccessLevels> result = repo.findAll();
		return result;
	}

}
