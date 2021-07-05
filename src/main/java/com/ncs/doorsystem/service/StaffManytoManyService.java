package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.dto.StaffGroupMainModal;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.dto.StaffSchedulemodal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;

import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.StaffGroupManytomanyRepository;
import com.ncs.doorsystem.repository.StaffManytoManyRepository;

@Service
@Transactional
public class StaffManytoManyService {

	@Autowired
	StaffManytoManyRepository repo;

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	StaffGroupManytomanyRepository staffGroupRepo;
	
	

	 
//	 public StaffManytoManyService(EntityManager entityManager) {
//	        this.entityManager = entityManager;
//	    }

	public List<StaffManyToMany> getAllStaffs() {

		return null;
	}

	public ResponseEntity<Object> createStaff(StaffManyToMany staffManyToMany,long custid ) 
	{
		StaffGroupManytoMany staffGroupManytoMany = new StaffGroupManytoMany();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = DateFor.format(date);
		DateFor = new SimpleDateFormat("yyyy-MM-D hh:mm:ss");
		stringDate = DateFor.format(date);
	    String formattedDate = myDateObj.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);
		//Staff newStaff = new Staff(staff);
		System.out.println(staffManyToMany.toString());

		Calendar calendar = Calendar.getInstance();
		Customer customerName= custRepo.findById(custid);
		StaffManyToMany oldPayrollValues = repo.getstaff(staffManyToMany.getPayrollno(),custid);
		if (oldPayrollValues!=null) {
			return ResponseEntity.badRequest().body("The Payrollno is already Present, Failed to Create new Staff");
		} else {
			staffManyToMany.setCustomerId(custid);
			staffManyToMany.setCreatedBy(customerName.getFirstname()+"  "+customerName.getLastname());
			staffManyToMany.setPayrollno(staffManyToMany.getPayrollno());
			staffManyToMany.setSchedule(staffManyToMany.getSchedule());
			//staffManyToMany.setStaffgroup(staffgroup);
			staffGroupManytoMany.setCustomerid(custid);
			staffGroupManytoMany.setCreatedBy(customerName.getFirstname()+"  "+customerName.getLastname());
			staffGroupManytoMany.setCreatedDate(new Date(calendar.getTime().getTime()));
			StaffManyToMany savedStaff = repo.save(staffManyToMany);
			if (repo.findById(savedStaff.getStaffid()).isPresent())
				return ResponseEntity.ok("Staff  Created Successfully");
			else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
		}
	}

	public StaffModal findStaff(Long staffid) {
		if(repo.findById(staffid).isPresent()) 
		{
			StaffManyToMany result = repo.findById(staffid).get();
			StaffModal modal = new StaffModal();
			modal.setCreatedBy(result.getCreatedBy());
			modal.setCreatedDate(result.getCreatedDate());
			modal.setCustomerid(result.getCustomerId());
			modal.setStaffid(result.getStaffid());
			modal.setExpiraydate(result.getExpiraydate());
			modal.setFirstname(result.getFirstname());
			modal.setLastname(result.getLastname());
			modal.setPayrollno(result.getPayrollno());
			modal.setStaffgroup(getstaffGroups(result));
			modal.setStaffschedule(getSchedule(result));
			
			return modal;
		}
			
        else return  null;
		
	}

	

	public List<StaffModal> findAllStaff(Long custId) {
		
		List<StaffManyToMany> result = repo.findBycustomerId(custId);
		List<StaffModal> returnStaff = new ArrayList<>();
		for (int i = 0; i < result.size(); i++) 
		{
			StaffModal modal = new StaffModal();
			modal.setExpiraydate(result.get(i).getExpiraydate());
			modal.setFirstname(result.get(i).getFirstname());
			modal.setLastname(result.get(i).getLastname());
			modal.setStaffid(result.get(i).getStaffid());
			modal.setPayrollno(result.get(i).getPayrollno());
			modal.setStaffgroup(getstaffGroups(result.get(i)));
			modal.setStaffschedule(getSchedule(result.get(i)));
			modal.setCreatedDate(result.get(i).getCreatedDate());
			modal.setCreatedBy(result.get(i).getCreatedBy());
			returnStaff.add(modal);
			
			
		}
		return returnStaff;
	}

	private List<StaffSchedulemodal> getSchedule(StaffManyToMany staffManyToMany) {
		List<StaffSchedulemodal> roleList = new ArrayList<>();
        for(int i=0; i< staffManyToMany.getSchedule().size(); i++) {
        	StaffSchedulemodal roleModel = new StaffSchedulemodal();
        	roleModel.setScheduleId(staffManyToMany.getSchedule().get(i).getScheduleId());
        	roleModel.setCreatedBy(staffManyToMany.getSchedule().get(i).getCreatedBy());
        	roleModel.setCreatedDate(staffManyToMany.getSchedule().get(i).getCreatedDate());
        	roleModel.setDays(staffManyToMany.getSchedule().get(i).getDays());
        	roleModel.setStartTime(staffManyToMany.getSchedule().get(i).getStartTime());
        	roleModel.setEndTime(staffManyToMany.getSchedule().get(i).getEndTime());
        	//roleModel.set
            roleList.add(roleModel);
        }
        return roleList;
	}
	

	public StaffManyToMany updateStaff(StaffManyToMany staffManyToMany, Long staffid, long custId) {
		
		if(repo.findById(staffid).isPresent()) {
            StaffManyToMany newUser = repo.findById(staffid).get();
            
            newUser.setFirstname(staffManyToMany.getFirstname());
            newUser.setLastname(staffManyToMany.getLastname());
            newUser.setStaffgroup(staffManyToMany.getStaffgroup());
            newUser.setExpiraydate(staffManyToMany.getExpiraydate());
            newUser.setStaffgroup(staffManyToMany.getStaffgroup());
            newUser.setSchedule(staffManyToMany.getSchedule());
            
//            newUser.setMobile(staff.getMobile());
//            newUser.setEmail(staff.getEmail());
//            newUser.setRoles(staff.getRoles());
            StaffManyToMany savedUser = repo.save(newUser);
            if(repo.findById(savedUser.getStaffid()).isPresent())
                return  savedUser;
            else return null ;
        } else return staffManyToMany ;
	}

	public ResponseEntity<Object> deleteStaff(long staffid) throws Exception
	{
//		StaffManyToMany staff = repo.findById(staffid).get();
//		StaffGroupManytoMany staffgroup = new StaffGroupManytoMany();
		
		if (repo.findById(staffid).isPresent()) {
			//entityManager.getTransaction().begin();
			
            // Remove all references to this movie by superheroes
//			staff.getStaffgroup().forEach(staffgroup1 -> {
//				staffgroup1.getStaffManyToMany().remove(staff);
//            });
//
//            // Now remove the movie
//            entityManager.remove(staff);
//            EntityManager em = emf.createEntityManager();
//            EntityTransaction tx = em.getTransaction();
//            
//            tx.begin();
            
//            StaffManyToMany staff1 = em.find(StaffManyToMany.class, staffid);
//            for (StaffGroupManytoMany group : staff1.getStaffgroup()) {
//            	staff1.removeStaffGroup(group);
//            }
//            em.remove(staff1);
//          //  em.remove(em.merge(staff));
//            tx.commit();
//            em.close();

            // Commit the transaction
           // entityManager.getTransaction().commit();
			repo.deleteStaff(staffid);
			repo.deleteById(staffid);
            if (repo.findById(staffid).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified staff");
            else return ResponseEntity.ok().body("Successfully deleted the specified staff");
        }
		return null; 
	}
	
private List<StaffGroupMainModal> getstaffGroups(StaffManyToMany staffManytoMany) {
		
		List<StaffGroupMainModal> roleList = new ArrayList<>();
        for(int i=0; i< staffManytoMany.getStaffgroup().size(); i++) {
        	StaffGroupMainModal roleModel = new StaffGroupMainModal();
        	roleModel.setStaffGroupName(staffManytoMany.getStaffgroup().get(i).getStaffGroupName());
        	roleModel.setCreatedBy(staffManytoMany.getStaffgroup().get(i).getCreatedBy());
        	roleModel.setCreatedDate(staffManytoMany.getStaffgroup().get(i).getCreatedDate());
        	roleModel.setCustomerid(staffManytoMany.getStaffgroup().get(i).getCustomerid());
        	roleModel.setGroupid(staffManytoMany.getStaffgroup().get(i).getGroupid());
        	roleModel.setDoors(staffManytoMany.getStaffgroup().get(i).getDoors());
        	roleModel.setTags(staffManytoMany.getStaffgroup().get(i).getTags());
            roleList.add(roleModel);
        }
        return roleList;
	}

}
