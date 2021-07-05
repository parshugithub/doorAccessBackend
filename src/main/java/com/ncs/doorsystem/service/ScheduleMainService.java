package com.ncs.doorsystem.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.ScheduleDays;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.ScheduleMainRepository;
import com.ncs.doorsystem.repository.SchedulesRepository;

@Transactional
@Service
public class ScheduleMainService {
	@Autowired
	ScheduleMainRepository schMainRepo;
	@Autowired
	CustomerRepository custRepo;

	@Autowired
	SchedulesRepository repo;

	public List<ScheduleMainModal> getAllSchedules(long custId, long siteid) {
		List<ScheduleMainModal> result = schMainRepo.findbycustomeridAndSite(custId,siteid);
		return result;
	}

	public ScheduleMainModal createSchedule(ScheduleMainModal modal, long custid, long siteid, long scheduleid) {

		ScheduleMainModal existingvalues = schMainRepo.findscheduleIdForClientAndSite(modal.getSchedule(),custid,siteid);
		if (existingvalues != null) 
		{
			System.out.println(" if the comming");
			Calendar calendar = Calendar.getInstance();
			System.out.println("object is" + existingvalues.toString());
			Customer customerName = custRepo.findById(custid);

			List<Object> obj = repo.getDays();
			existingvalues.setCustomerid(custid);
			existingvalues.setSiteid(siteid);
			existingvalues.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
			existingvalues.setDays(modal.getDays());
			existingvalues.setCreatedDate(modal.getCreatedDate());
			existingvalues.setEndTime(modal.getEndTime());
			existingvalues.setStartTime(modal.getStartTime());
			existingvalues.setSchedule(modal.getSchedule());
			
//			for (int i = 0; i < modal.getDays().size(); i++)
//			{
//				List<ScheduleDays> res = schMainRepo.findScheduleDays(modal.getDays().get(i).getDay(),existingvalues.getScheduleId());
//				System.out.println("the res is "+res);
//				
//				
//			}
			// modal.setDays(obj);
			ScheduleMainModal saved = schMainRepo.save(existingvalues);
			return saved;
		} 
		else
		{
			System.out.println(" else the comming");
			Calendar calendar = Calendar.getInstance();
			System.out.println("object is" + modal.toString());
			Customer customerName = custRepo.findById(custid);

			List<Object> obj = repo.getDays();
			modal.setCustomerid(custid);
			modal.setSiteid(siteid);
			modal.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
			modal.setDays(modal.getDays());
			// modal.setDays(obj);
			ScheduleMainModal saved = schMainRepo.save(modal);
			return saved;
		}
		
	}

	public ResponseEntity<Object> updateSchedule(ScheduleMainModal modal, long scheduleId) {
		if (schMainRepo.findById(scheduleId).isPresent()) {
			ScheduleMainModal UpdateSchedule = schMainRepo.findById(scheduleId).get();

			UpdateSchedule.setStartTime(modal.getStartTime());
			UpdateSchedule.setEndTime(modal.getEndTime());
			UpdateSchedule.setCreatedDate(modal.getCreatedDate());
			ScheduleMainModal saved = schMainRepo.save(UpdateSchedule);
			if (schMainRepo.findById(saved.getScheduleId()).isPresent())
				return ResponseEntity.accepted().body("Schedule updated successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed updating the Schedule specified");
		} else
			return ResponseEntity.unprocessableEntity().body("Cannot find the Schedule specified");
	}

	public ResponseEntity<Object> deleteSchedule(long scheduleId) {
		if (schMainRepo.findById(scheduleId).isPresent()) {
			schMainRepo.deleteById(scheduleId);
			if (schMainRepo.findById(scheduleId).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Schedule");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified Schedule");
		}
		return null;
	}

	public ScheduleMainModal getSchedules(long scheduleId) {
		// TODO Auto-generated method stub
		return schMainRepo.findByscheduleId(scheduleId);
	}

	public List<ScheduleMainModal> getAllSchedulesForStaff(long custId) {
		List<ScheduleMainModal> result = schMainRepo.findbycustomerid(custId);
		return result;
	}

}
