package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.ResidentModal;
import com.ncs.doorsystem.repository.ChannelsRepository;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.ResidentRepository;

@Service
@Transactional
public class ResidentService 
{
	@Autowired
	ResidentRepository repo;
	
	@Autowired
	ChannelsRepository channelsRepo;
	
	@Autowired
	CustomerRepository customerrepo;
	
	
	public List<ResidentModal> getAllResident(long custID)
	{
		List<ResidentModal> listResident =repo.findBycustomerid(custID);
		
		return listResident;
	}

	public ResponseEntity<Object> createNewResident(@Valid ResidentModal modal, long custid, long siteid) throws Exception 
	{
		
		ResidentModal oldResident= repo.findBypersonName(modal.getPersonName());
		Customer customerName= customerrepo.findById(custid);
		if(oldResident!=null)
		{
			throw new Exception("The Resident with " +oldResident.getPersonName()+" name already exists");
		}
		else
		{
		    ChannelsModal flatnumber = channelsRepo.findByflat(modal.getFlatNumber());
		    if(flatnumber!=null)
		    {
		    	long flatvalue= flatnumber.getFlat();
			    if(modal.getFlatNumber()==flatvalue)
			    {
			    	
			    	modal.setCustomerid(custid);
					modal.setSiteid(siteid);
					modal.setCreatedBy(customerName.getFirstname()+"  "+ customerName.getLastname());
					ResidentModal savedValues =repo.save(modal);
					if(repo.findById(savedValues.getResidentid()).isPresent())
						return ResponseEntity.ok("Resident created successfully");
					else
						return ResponseEntity.unprocessableEntity().body("Failed to create the resident");
			    }
			    else
			    {
			    	return ResponseEntity.unprocessableEntity().body("Flat number does not exites");
			    }
		    }
		    else
		    {
		    	return ResponseEntity.unprocessableEntity().body("Flat number does not exites Failed to create the resident");
		    }
		    
			
		}
		
		
		
	}

	

	public ResidentModal getResident(long residentid) {
		if(repo.findById(residentid).isPresent())
			return repo.findById(residentid).get();
		
		else return null;
	}

	public ResponseEntity<Object> deleteResident(long residentid) {
		if(repo.findById(residentid).isPresent())
		{
			repo.deleteById(residentid);
        if (repo.findById(residentid).isPresent())
            return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Schedule");
        else return ResponseEntity.ok().body("Successfully deleted the specified Schedule");
    }
	 return ResponseEntity.ok().body("Failed to find the resident");
}

	public ResponseEntity<Object> updateResident(long residentid, ResidentModal residentUpdate) {
		
		ResidentModal oldResident = repo.findByresidentid(residentid);
		if(oldResident!=null)
		{
			oldResident.setCreatedDate(residentUpdate.getCreatedDate());
			oldResident.setEmial(residentUpdate.getEmial());
			oldResident.setFlatNumber(residentUpdate.getFlatNumber());
			oldResident.setHomeTelephone(residentUpdate.getHomeTelephone());
			oldResident.setMobileNumber(residentUpdate.getMobileNumber());
			oldResident.setPersonName(residentUpdate.getPersonName());
			oldResident.setSipurl(residentUpdate.getSipurl());
			oldResident.setTagCode(residentUpdate.getTagCode());
			oldResident.setTagNumber(residentUpdate.getTagNumber());
			
			ResidentModal updatedVales = repo.save(oldResident);
			if(repo.findById(updatedVales.getResidentid()).isPresent())
				return ResponseEntity.ok("Updated successfully");
			else ResponseEntity.unprocessableEntity().body("Faile to Update  the resident");
		}
		return ResponseEntity.unprocessableEntity().body("Specified resident not found");
	}

}
