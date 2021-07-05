package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.StaffAccessAndOptions;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.repository.SatffAccessAndOptionRepository;

@Service
@Transactional
public class StaffAccessAndOptionsService
{
	@Autowired
	SatffAccessAndOptionRepository repo;

	
	public List<StaffAccessAndOptions> findAll(long custId, long siteid) {
		List<StaffAccessAndOptions> result=repo.findbycustomerid(custId,siteid);
		return result;
	}
	public StaffAccessAndOptions createStaffAcess(StaffAccessAndOptions staffAccess, long custid, long siteid,long staff) throws Exception 
	{
		
		staffAccess.setCustomerid(custid);
		staffAccess.setSiteid(siteid);
		
		long staffvalue=staffAccess.getStaff();
		String accesslevels= staffAccess.getAccessLevel();
		System.out.println("the values" +staffvalue);
		
		StaffAccessAndOptions values= repo.findBystaff(staff);
		if(values!=null)
		{
			values.setAccessLevel(staffAccess.getAccessLevel());
			values.setCustomerid(custid);
			values.setPassnumber(staffAccess.getPassnumber());
			values.setSiteid(siteid);
			values.setStaff(staff);
			values.setUpdatedDate(staffAccess.getUpdatedDate());
			
				StaffAccessAndOptions saved=repo.save(values);
				if(repo.findById(saved.getStaffaccessid()).isPresent())
					return saved;
					//else null;
		
		}
		else
		{
			staffAccess.setCustomerid(custid);
			staffAccess.setSiteid(siteid);
			staffAccess.setStaff(staff);
			
			StaffAccessAndOptions saved=repo.save(staffAccess);
			if(repo.findById(saved.getStaffaccessid()).isPresent())
				return saved;
				
		}
		return null;
		
	
		
		
	}

	public ResponseEntity<Object> updateStaffAccess(StaffAccessAndOptions staffAccess, long staffaccessid) {
		
		StaffAccessAndOptions oldValues = repo.findBystaffaccessid(staffaccessid);
		if(oldValues!=null)
		{
			oldValues.setAccessLevel(staffAccess.getAccessLevel());
			oldValues.setPassnumber(staffAccess.getPassnumber());
			oldValues.setStaff(staffAccess.getStaff());
			oldValues.setUpdatedDate(staffAccess.getUpdatedDate());
			StaffAccessAndOptions savedValues = repo.save(oldValues);
			
			if(repo.findById(savedValues.getStaffaccessid()).isPresent())
				return ResponseEntity.ok("Updated successfully");
			else return ResponseEntity.unprocessableEntity().body("Failed to update");
			
		}
		return ResponseEntity.unprocessableEntity().body("Cannot find the staff specified");
	}

	public ResponseEntity<Object> deleteStaffaccess(long staffaccessid) {
		if(repo.findById(staffaccessid).isPresent())
		{
			repo.deleteById(staffaccessid);
		}
		if(repo.findById(staffaccessid).isPresent())
			return ResponseEntity.ok("Failed to delete");
		else return ResponseEntity.unprocessableEntity().body("Deleted Successfully");
	}

}
