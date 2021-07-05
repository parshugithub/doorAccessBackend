package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.DoorDescriptionModal;
import com.ncs.doorsystem.entity.ResidentModal;
import com.ncs.doorsystem.repository.DoorDescriptionRepository;

@Service
@Transactional
public class DoorDescriptionService {
	@Autowired
	DoorDescriptionRepository repo;

	public List<DoorDescriptionModal> findAll(long siteid) {
		List<DoorDescriptionModal> list = repo.findBysiteid(siteid);

		return list;
	}

	public ResponseEntity<Object> createDoorDescription(DoorDescriptionModal modal, long siteid) throws Exception {
		DoorDescriptionModal doorcheck = repo.findBydoor(modal.getDoor());
		if (doorcheck != null) {
			doorcheck.setCameraStream(modal.getCameraStream());
			doorcheck.setDescription(modal.getDescription());
			doorcheck.setDoor(modal.getDoor());
			doorcheck.setDtmf(modal.getDtmf());
			doorcheck.setSip_url(modal.getSip_url());
			doorcheck.setTelephoneNUmber(modal.getTelephoneNUmber());
			doorcheck.setSiteid(siteid);
			DoorDescriptionModal saved = repo.save(doorcheck);
			if (repo.findById(saved.getDoorDesId()).isPresent())
				return ResponseEntity.ok("Door description created successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create the Door description ");

		} else {
			modal.setSiteid(siteid);
			DoorDescriptionModal saved = repo.save(modal);
			if (repo.findById(saved.getDoorDesId()).isPresent())
				return ResponseEntity.ok("Door description created successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create the Door description ");
		}

	}

	public ResponseEntity<Object> deleteDoorDes(long doorDesId, long siteid) {
		DoorDescriptionModal result = repo.finddoorDesId(doorDesId);
		if (result != null) {
			int res = repo.deleteDoorDescription(doorDesId, siteid);
			System.out.println("The res is" + res);
			if (repo.findById(doorDesId).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Door description ");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified Door description ");
		}
		return ResponseEntity.ok().body("Failed to find the Door description ");
	}

	public ResponseEntity<Object> updateDoorDesc(long doorDesId, DoorDescriptionModal update) {
		DoorDescriptionModal oldValues = repo.findBydoorDesId(doorDesId);
		if (oldValues != null) {
			oldValues.setCameraStream(update.getCameraStream());
			oldValues.setDescription(update.getDescription());
			oldValues.setDoor(update.getDoor());
			oldValues.setDtmf(update.getDtmf());
			oldValues.setSip_url(update.getSip_url());
			oldValues.setTelephoneNUmber(update.getTelephoneNUmber());
			DoorDescriptionModal updatedVales = repo.save(oldValues);

			if (repo.findById(updatedVales.getDoorDesId()).isPresent())
				return ResponseEntity.ok("Updated successfully");
			else
				ResponseEntity.unprocessableEntity().body("Failed to Update  the resident");

		}

		return ResponseEntity.unprocessableEntity().body("Specified resident not found");

	}

	public List<DoorDescriptionModal> createDoorDescriptionAll(List<DoorDescriptionModal> modal, long siteid) {
		System.out.println("the size is " + modal.size());
		System.out.println("the object is " + modal.toString());
		List<DoorDescriptionModal> res;
		for (int i = 0; i < modal.size(); i++) {
			DoorDescriptionModal doorcheck = repo.findBydoor(modal.get(i).getDoor());
			if (doorcheck != null) {
				System.out.println("cmg");
				doorcheck.setCameraStream(modal.get(i).getCameraStream());
				doorcheck.setDescription(modal.get(i).getDescription());
				doorcheck.setDoor(modal.get(i).getDoor());
				doorcheck.setDtmf(modal.get(i).getDtmf());
				doorcheck.setSip_url(modal.get(i).getSip_url());
				doorcheck.setTelephoneNUmber(modal.get(i).getTelephoneNUmber());
				doorcheck.setSiteid(siteid);
				// res.add(doorcheck);
				DoorDescriptionModal saved = repo.save(doorcheck);
				// return modal;

			}

			else {
				List<DoorDescriptionModal> doorDesc = modal;
				for (int j = i; j < doorDesc.size(); j++) {
					DoorDescriptionModal doorval= new DoorDescriptionModal();
					doorval.setSiteid(siteid);	
					doorval.setCameraStream(doorDesc.get(j).getCameraStream());
					doorval.setDescription(doorDesc.get(j).getDescription());
					doorval.setDoor(doorDesc.get(j).getDoor());
					doorval.setDtmf(doorDesc.get(j).getDtmf());
					doorval.setSip_url(doorDesc.get(j).getSip_url());
					doorval.setTelephoneNUmber(doorDesc.get(j).getTelephoneNUmber());
					DoorDescriptionModal saved = repo.save(doorval);
					
				}
				
				
				
			//	modal.get(i).setSiteid(siteid);
				//DoorDescriptionModal saved = repo.save(doorDesc);
				
			}

		}
		return modal;

	}

	public ResponseEntity<Object> deleteDoorDesAll(List<DoorDescriptionModal> doorDesId, long siteid)
	{
		int res;
		for (int i = 0; i < doorDesId.size(); i++) 
		{
			DoorDescriptionModal result = repo.finddoorDesId(doorDesId.get(i).getDoor());
			if (result != null) {
				 res = repo.deleteDoorDescription(doorDesId.get(i).getDoor(), siteid);
				System.out.println("The res is" + res);
			}

		}
		return  ResponseEntity.ok().body("Successfully deleted the specified Door description ");
	}

	public DoorDescriptionModal findOne(long door) {
		DoorDescriptionModal result = repo.finddoorDesId(door);
		return result;
	}

}