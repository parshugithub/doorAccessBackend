package com.ncs.doorsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.doorsystem.dto.PersonClassDTO;
import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonManagementPersonClassModal;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.repository.PersonClassRepository;
import com.ncs.doorsystem.repository.PersonManagementRepository;
import com.ncs.doorsystem.repository.PersonMangementClassRepository;
import com.ncs.doorsystem.repository.PersonRepository;

@Service
@Transactional
public class PersonManagementPersonClassService 
{
	@Autowired
	PersonMangementClassRepository repo;
	
	@Autowired
	PersonManagementRepository personRepo;

	public List<PersonClassDTO> getAllPersonClass(long custid) 
	{
		List<PersonManagementPersonClassModal> result = repo.findBywebAppPersonClassid(custid);
		
		List<PersonClassDTO> pcDTO = new ArrayList<>();
		
		for (int i = 0; i < result.size(); i++) 
		{
			PersonClassDTO pcRes = new PersonClassDTO();
			pcRes.setCreateddate(result.get(i).getCreateddate());
			pcRes.setExpirydate(result.get(i).getExpirydate());
			pcRes.setPersonclassid(result.get(i).getPclassid());
			pcRes.setPersonClassName(result.get(i).getPersonClassName());
			pcRes.setSiteid(result.get(i).getSiteid());
			pcRes.setWebAppPersonClassid(result.get(i).getWebAppPersonClassid());
		//	pcRes.setPerson(result.get(i).getp);
			pcDTO.add(pcRes);
			
			
		}
		
		

		return pcDTO;
	}

//	private List<PersonDTO> getPerson(PersonClassModal personClassModal) 
//	{
//		List<PersonDTO> pDTO = new ArrayList<>();
//		for (int i = 0; i < personClassModal.getPerson().size(); i++) 
//		{
//			PersonDTO res = new PersonDTO();
//			res.setAddress1(personClassModal.getPerson().get(i).getAddress1());
//			res.setCity(personClassModal.getPerson().get(i).getCity());
//			res.setCountry(personClassModal.getPerson().get(i).getCountry());
//			res.setExpiraydate(personClassModal.getPerson().get(i).getExpiraydate());
//			res.setFirstName(personClassModal.getPerson().get(i).getFirstName());
//			res.setLastName(personClassModal.getPerson().get(i).getLastName());
//			res.setMobileNumber(personClassModal.getPerson().get(i).getMobileNumber());
//			res.setPersonid(personClassModal.getPerson().get(i).getPersonid());
//			res.setState(personClassModal.getPerson().get(i).getState());
//			res.setSiteid(personClassModal.getPerson().get(i).getSiteid());
//			res.setWebappPerosnId(personClassModal.getPerson().get(i).getWebappPerosnId());
//			res.setTradeCode(personClassModal.getPerson().get(i).getTradeCode());
//			res.setPropery(personClassModal.getPerson().get(i).getPropery());
//			pDTO.add(res);
//			
//			
//			
//		}
//		
//		return pDTO;
//	}

	public PersonManagementPersonClassModal createNewPersonClass(@Valid PersonManagementPersonClassModal modal, long custid, long siteid) throws Exception 
	{
		PersonManagementPersonClassModal  mobile= repo.findBypersonClassName(modal.getPersonClassName());
		if(mobile!=null)
		{
			throw new Exception("The person class is alreadt exists");
		}
		else
		{
			PersonManagementPersonClassModal newclass= new PersonManagementPersonClassModal();
			newclass.setPersonClassName(modal.getPersonClassName());
			newclass.setWebAppPersonClassid(custid);
			newclass.setSiteid(siteid);
			newclass.setCreateddate(modal.getCreateddate());
			newclass.setExpirydate(modal.getExpirydate());
			PersonManagementPersonClassModal updated = repo.save(newclass);
			if(repo.findById(updated.getPclassid()).isPresent())
				return updated;
			else return null;
			//return ResponseEntity.ok("Person class created successfully");
	}
		
}

public PersonClassDTO getPersonClass(long personclassid) {
	if(repo.findById(personclassid).isPresent())
	{
		PersonManagementPersonClassModal classRes=repo.findById(personclassid).get();
		
			PersonClassDTO pcRes = new PersonClassDTO();
			pcRes.setCreateddate(classRes.getCreateddate());
			pcRes.setExpirydate(classRes.getExpirydate());
			pcRes.setPersonclassid(classRes.getPclassid());
			pcRes.setPersonClassName(classRes.getPersonClassName());
			pcRes.setSiteid(classRes.getSiteid());
			pcRes.setWebAppPersonClassid(classRes.getWebAppPersonClassid());
			//pcRes.setPerson(getPerson(classRes));
			
			
			return pcRes;
		
	}
	return null;
	

}

public ResponseEntity<Object> deletePersonClass(long personclassid) {
	if(repo.findById(personclassid).isPresent()){
       
//=        	repo.deleteById(personclassid);
	int person=   repo.findPersonclss(personclassid);
		if(person!=0)
		{
			repo.deleteMappedpersobclass(personclassid);
		}
		else
		{
			repo.deleteById(personclassid);
		}
	//	repo.deleteMappedpersobclass(personclassid);
        	
            if (repo.findById(personclassid).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else return ResponseEntity.unprocessableEntity().body("Failed to delete,  Please delete the person associated with this Group");
    
}

public @ResponseBody PersonManagementPersonClassModal updatePersonClass(long personclassid, PersonManagementPersonClassModal update) {
	PersonManagementPersonClassModal oldvalue= repo.findBypclassid(personclassid);

	if(oldvalue!=null)
	{
		
		ArrayList<PersonModal> personArry = new ArrayList<>();
		
//		for (int i = 0; i < update.getPerson().size(); i++) 
//		{
//			PersonModal existingPerson = personRepo.findBymobileNumber(update.getPerson().get(i).getMobileNumber());
//			if(existingPerson!=null)
//			{
//				personArry.add(existingPerson);
//				//existingPerson.setAddress1(address1);
//			}
//			
//		}
		System.err.println(" The person are "+ personArry.toString());
		oldvalue.setExpirydate(update.getExpirydate());
		oldvalue.setCreateddate(update.getCreateddate());
		oldvalue.setPersonClassName(update.getPersonClassName());
		//oldvalue.setPerson(personArry);
		
		PersonManagementPersonClassModal updated = repo.save(oldvalue);

		if(repo.findById(updated.getPclassid()).isPresent())
			return updated;
		else return null;

	}
	return null;
}

public List<PersonClassDTO> getAllPersonClassForSite(long custid, long siteid) {
	List<PersonManagementPersonClassModal> result = repo.findAllPersons(custid,siteid);
	
	List<PersonClassDTO> pcDTO = new ArrayList<>();
	
	for (int i = 0; i < result.size(); i++) 
	{
		PersonClassDTO pcRes = new PersonClassDTO();
		pcRes.setCreateddate(result.get(i).getCreateddate());
		pcRes.setExpirydate(result.get(i).getExpirydate());
		pcRes.setPersonclassid(result.get(i).getPclassid());
		pcRes.setPersonClassName(result.get(i).getPersonClassName());
		pcRes.setSiteid(result.get(i).getSiteid());
		pcRes.setWebAppPersonClassid(result.get(i).getWebAppPersonClassid());
	//	pcRes.setPerson(result.get(i).getp);
		pcDTO.add(pcRes);
		
		
	}
	
	

	return pcDTO;
}





}
