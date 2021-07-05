package com.ncs.doorsystem.service;

import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.net.InetAddresses;
import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.dto.EmbeddedStaffInformation;
import com.ncs.doorsystem.dto.StaffGroupMainModal;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;
import com.ncs.doorsystem.entity.StaffGroupTags;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.CreateSiteRepository;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.StaffGroupManytomanyRepository;
import com.ncs.doorsystem.repository.StaffGroupTagsRepository;
import com.ncs.doorsystem.repository.StaffManytoManyRepository;
import com.ncs.doorsystem.repository.TotalDoorRepository;

@Service
@Transactional
public class StaffGroupManytoManyService extends MQTTConfig {

	@Autowired
	CustomerRepository custRepo;
	@Autowired
	StaffGroupManytomanyRepository staffGroupRepo;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	StaffManytoManyRepository staffRepo;

	@Autowired
	CreateSiteRepository siterepo;

	@Autowired
	TotalDoorRepository doorRepo;

	@Autowired
	StaffGroupTagsRepository tagsRepo;

	@Autowired
	MQTTPublisherBase publisher;

	MQTTConfig config;
	@Autowired
	BackTasksRepository backTaskRepo;

	ArrayList<String> staff_mqtt_array;

	public ResponseEntity<Object> createStaffGroup(StaffGroupManytoMany staffgroup, long custid) throws Exception {

		Customer customerName = custRepo.findById(custid);
		StaffGroupManytoMany newStaffGroup = new StaffGroupManytoMany();
		System.out.println("the request is " + staffgroup.toString());

		// StaffManyToMany newStaffValues = new StaffManyToMany();
		StaffGroupManytoMany oldStaffGroupName = staffGroupRepo.findstaffGroupName(staffgroup.getStaffGroupName(),
				custid);
		// System.out.println("The staff group "+oldStaffGroupName.getStaffGroupName());
		if (oldStaffGroupName != null) {
			// oldStaffGroupName.setStaffGroupName(staffgroup.getStaffGroupName());
			throw new Exception("The Staff Group already exists");
		}

//		newStaffGroup.setStaffGroupId(staffgroup.getStaffGroupId());
////		newStaffValues.setCustomerId(custid);
////		newStaffValues.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
//
//		newStaffGroup.setCustomerid(custid);
//
//		newStaffGroup.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
//		newStaffGroup.setStaffGroupName(staffgroup.getStaffGroupName());
//		newStaffGroup.setCreatedDate(staffgroup.getCreatedDate());

		List<CreateSiteModal> groupSite = new ArrayList<>();
		List<CreateSiteModal> sitevalues = staffgroup.getSites();
//		 System.out.println("sites are "+staffgroup.getSites().isEmpty());
//		 System.out.println("staff are "+staffgroup.getStaff().isEmpty());
		if ((staffgroup.getSites().isEmpty() || staffgroup.getStaffManyToMany().isEmpty())
				|| staffgroup.getDoors().isEmpty() || staffgroup.getTags().isEmpty()) {

			newStaffGroup.setStaffGroupName(staffgroup.getStaffGroupName());
			newStaffGroup.setCustomerid(custid);

			newStaffGroup.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());

			newStaffGroup.setCreatedDate(staffgroup.getCreatedDate());

			newStaffGroup.setStaffGroupName(staffgroup.getStaffGroupName());
			newStaffGroup.setStaffManyToMany(staffgroup.getStaffManyToMany());
			// newStaffGroup.setStaff(staffList);
			newStaffGroup.setSites(staffgroup.getSites());
			newStaffGroup.setDoors(staffgroup.getDoors());
			newStaffGroup.setTags(staffgroup.getTags());
			StaffGroupManytoMany savedValues = staffGroupRepo.save(newStaffGroup);
			if (staffGroupRepo.findById(savedValues.getGroupid()).isPresent())
				return ResponseEntity.ok("Staff Group is created success fully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create Staff group with the staff");

		}
//		 for (int i=0; i< staffgroup.getSites().size(); i++) {
//			CreateSiteModal createSiteModal = staffgroup.getSites().get(i);
//			String siteName= createSiteModal.getSiteName();
//			System.out.println("The site Name is "+siteName);
//			CreateSiteModal checkSite =siterepo.findBysiteName(siteName);
//			if(checkSite!=null)
//			{
//				checkSite.setAddress2(staffgroup.getSites().get(i).getAddress2());
//				checkSite.setArea(staffgroup.getSites().get(i).getArea());
//				checkSite.setCity(staffgroup.getSites().get(i).getCity());
//				checkSite.setCountry(staffgroup.getSites().get(i).getCountry());
//				checkSite.setCustomerAddress(staffgroup.getSites().get(i).getCustomerAddress());
//				checkSite.setCustomerName(staffgroup.getSites().get(i).getCustomerName());
//				checkSite.setCustomerPhone(staffgroup.getSites().get(i).getCustomerPhone());
//				checkSite.setDeviceId(staffgroup.getSites().get(i).getDeviceId());
//				checkSite.setSiteReference(staffgroup.getSites().get(i).getSiteReference());
//				checkSite.setAddress2(staffgroup.getSites().get(i).getAddress2());
//				groupSite.add(checkSite);
//			}	
//		}
//		 List<StaffManyToMany> staff= staffgroup.getStaff();
//		 List<StaffManyToMany> staffList = new ArrayList();
//		 
//		 for (int i=0; i< staffgroup.getStaff().size(); i++) 
//		 {
//			 StaffManyToMany oldValues = staffgroup.getStaff().get(i);
//			 String payrollValue= oldValues.getPayrollno();
//			 System.out.println("The payroll is "+payrollValue);
//			StaffManyToMany oldPayrollValues = staffRepo.findBypayrollno(payrollValue);
//			 if(oldPayrollValues!=null)
//			 {
//				 oldPayrollValues.setCreatedBy(customerName.getFirstname()+" "+customerName.getLastname());
//				 oldPayrollValues.setCreatedDate(staffgroup.getStaff().get(i).getCreatedDate());
//				 oldPayrollValues.setExpiraydate(staffgroup.getStaff().get(i).getExpiraydate());
//				 oldPayrollValues.setCustomerId(custid);
//				 oldPayrollValues.setFirstname(staffgroup.getStaff().get(i).getFirstname());
//				 oldPayrollValues.setLastname(staffgroup.getStaff().get(i).getLastname());
//				 oldPayrollValues.setPayrollno(staffgroup.getStaff().get(i).getPayrollno());
//				 staffList.add(oldPayrollValues);
//				 
//				 
//			 }
//			 
//			 
//			 
//			 
//		 }
////		 
//		// List<E>
////		 //sitevalues.add(arg0)
//
//		List<StaffGroupManytoMany> groupList = new ArrayList<>();
//		
//		groupList.add(newStaffGroup);
//		
//		System.out.println("The staff group is" + staffgroup.getStaff());
//
////		if (staffgroup.getStaff() == null) {
//			System.out.println("entwaskjlasdkj");
//			newStaffGroup.setStaffGroupName(staffgroup.getStaffGroupName());
//			newStaffGroup.setCustomerid(custid);
//
//			newStaffGroup.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
//
//			newStaffGroup.setCreatedDate(staffgroup.getCreatedDate());
//
//			newStaffGroup.setStaffGroupName(staffgroup.getStaffGroupName());
//			newStaffGroup.setStaffManyToMany(staffgroup.getStaff());
//			newStaffGroup.setStaff(staffList);
//			newStaffGroup.setSites(groupSite);
//			
//			// newStaffGroup.setSites(staffgroup.getSites().get(0));
//
//			StaffGroupManytoMany savedValues=	staffGroupRepo.save(newStaffGroup);
//			if(staffGroupRepo.findById(savedValues.getGroupid()).isPresent())
//				return ResponseEntity.ok("Staff Group is created success fully");
//			else
//				return ResponseEntity.unprocessableEntity().body("Failed to create Staff group with the staff");
//				
//	//	}
//		
//
////		} else {
////			for (int i = 0; i < staffgroup.getStaff().size(); i++) {
////				if (!staffRepo.findBypayrollno(staffgroup.getStaff().get(i).getPayrollno()).isPresent()) {
////					StaffManyToMany newStaff = staffgroup.getStaff().get(i);
////					newStaff.setStaffgroup(groupList);
////					//newStaff.setStaffgroup(groupList);
////					newStaff.setCreatedDate(staffgroup.getCreatedDate());
////					newStaff.setExpiraydate(staffgroup.getStaff().get(i).getExpiraydate());
////					newStaff.setCustomerId(custid);
////					newStaff.setCreatedBy(customerName.getFirstname() + "  " + customerName.getLastname());
////					StaffManyToMany savedUser = staffRepo.save(newStaff);
////					if (!staffRepo.findById(savedUser.getStaffid()).isPresent())
////						return ResponseEntity.unprocessableEntity().body("staff group Creation Failed");
////				} else
////					return ResponseEntity.unprocessableEntity().body("staff with payrollno is already Present");
////			}
////		}
//
//		// System.out.println("id is"+custid);
//		//return ResponseEntity.ok("Successfully created Staff group");
		return null;

	}

	public StaffGroupMainModal getStaffGroup(long id) {

		if (staffGroupRepo.findById(id).isPresent()) {
			StaffGroupManytoMany result = staffGroupRepo.findById(id).get();
			StaffGroupMainModal modal = new StaffGroupMainModal();
			modal.setCreatedBy(result.getCreatedBy());
			modal.setCreatedDate(result.getCreatedDate());
			modal.setCustomerid(result.getCustomerid());
			modal.setGroupid(result.getGroupid());
			modal.setStaffGroupName(result.getStaffGroupName());
			modal.setSites(result.getSites());
			modal.setStaffManyToMany(getstaffG(result));
			modal.setDoors(result.getDoors());
			modal.setTags(result.getTags());
			return modal;
		}

		else
			return null;

	}

	public List<StaffGroupMainModal> findAllSatffGroup(long custId) {

		List<StaffGroupManytoMany> result = staffGroupRepo.findBycustomerid(custId);
		List<StaffGroupMainModal> allmodal = new ArrayList<>();
		for (int i = 0; i < result.size(); i++) {
			StaffGroupMainModal modal = new StaffGroupMainModal();
			modal.setCreatedBy(result.get(i).getCreatedBy());
			modal.setCreatedDate(result.get(i).getCreatedDate());
			modal.setCustomerid(result.get(i).getCustomerid());
			modal.setGroupid(result.get(i).getGroupid());
			modal.setStaffGroupName(result.get(i).getStaffGroupName());
			modal.setSites(result.get(i).getSites());
			modal.setStaffManyToMany(getstaffG(result.get(i)));
			modal.setDoors(result.get(i).getDoors());
			modal.setTags(result.get(i).getTags());
			allmodal.add(modal);

		}
		// modal.setCreatedBy(result.get);
		System.out.println("all staff group " + result.toString());
		return allmodal;
	}

	private List<StaffModal> getstaffG(StaffGroupManytoMany staffGroupManytoMany) {
		List<StaffModal> roleList = new ArrayList<>();
		for (int i = 0; i < staffGroupManytoMany.getStaffManyToMany().size(); i++) {
			StaffModal roleModel = new StaffModal();
			roleModel.setCreatedBy(staffGroupManytoMany.getStaffManyToMany().get(i).getCreatedBy());
			roleModel.setCreatedDate(staffGroupManytoMany.getStaffManyToMany().get(i).getCreatedDate());
			roleModel.setCustomerid(staffGroupManytoMany.getStaffManyToMany().get(i).getCustomerId());
			roleModel.setExpiraydate(staffGroupManytoMany.getStaffManyToMany().get(i).getExpiraydate());
			roleModel.setFirstname(staffGroupManytoMany.getStaffManyToMany().get(i).getFirstname());
			roleModel.setLastname(staffGroupManytoMany.getStaffManyToMany().get(i).getLastname());
			roleModel.setPayrollno(staffGroupManytoMany.getStaffManyToMany().get(i).getPayrollno());
			roleModel.setStaffid(staffGroupManytoMany.getStaffManyToMany().get(i).getStaffid());

			roleList.add(roleModel);
		}
		return roleList;
	}

	public StaffGroupManytoMany updateStaffGroup(long id, StaffGroupManytoMany staffGroupUpdate, long custid)
			throws Exception {
		System.out.println("the object is " + staffGroupUpdate.toString());
		// Customer customerName = custRepo.findById(custid);

		if (staffGroupRepo.findById(id).isPresent()) {

			List<CreateSiteModal> groupSite = new ArrayList<>();
			List<StaffManyToMany> staffList = new ArrayList();
			List<TotalDoorsModal> doorslist = new ArrayList<>();
			List<StaffGroupTags> taglist = new ArrayList();

			List<CreateSiteModal> sitevalues = staffGroupUpdate.getSites();

			StaffGroupManytoMany newStaffGroup = staffGroupRepo.findById(id).get();

			for (int i = 0; i < staffGroupUpdate.getSites().size(); i++) {
				CreateSiteModal createSiteModal = staffGroupUpdate.getSites().get(i);
				String siteName = createSiteModal.getSiteName();
				System.out.println("The site Name is " + siteName);
				CreateSiteModal checkSite = siterepo.findBysiteName(siteName);
				if (checkSite != null) {
					checkSite.setAddress2(staffGroupUpdate.getSites().get(i).getAddress2());
					checkSite.setArea(staffGroupUpdate.getSites().get(i).getArea());
					checkSite.setCity(staffGroupUpdate.getSites().get(i).getCity());
					checkSite.setCountry(staffGroupUpdate.getSites().get(i).getCountry());
					checkSite.setCustomerAddress(staffGroupUpdate.getSites().get(i).getCustomerAddress());
					checkSite.setCustomerName(staffGroupUpdate.getSites().get(i).getCustomerName());
					checkSite.setCustomerPhone(staffGroupUpdate.getSites().get(i).getCustomerPhone());
					checkSite.setDeviceId(staffGroupUpdate.getSites().get(i).getDeviceId());
					checkSite.setSiteReference(staffGroupUpdate.getSites().get(i).getSiteReference());
					checkSite.setAddress2(staffGroupUpdate.getSites().get(i).getAddress2());
					groupSite.add(checkSite);
				}
			}
			List<StaffManyToMany> staff = staffGroupUpdate.getStaffManyToMany();

			System.out.println("the staff size is " + staffGroupUpdate.getStaffManyToMany().size());
			for (int i = 0; i < staffGroupUpdate.getStaffManyToMany().size(); i++) {
				StaffManyToMany oldValues = staffGroupUpdate.getStaffManyToMany().get(i);
				String payrollValue = oldValues.getPayrollno();
				System.out.println("The payroll is " + payrollValue);
				StaffManyToMany oldPayrollValues = staffRepo.getstaff(payrollValue, custid);
				if (oldPayrollValues != null) {
					System.out.println("entered if part");
					// oldPayrollValues.setCreatedBy(customerName.getFirstname()+"
					// "+customerName.getLastname());
					oldPayrollValues.setCreatedDate(staffGroupUpdate.getStaffManyToMany().get(i).getCreatedDate());
					oldPayrollValues.setExpiraydate(staffGroupUpdate.getStaffManyToMany().get(i).getExpiraydate());
					// oldPayrollValues.setCustomerId(custid);
					oldPayrollValues.setFirstname(staffGroupUpdate.getStaffManyToMany().get(i).getFirstname());
					oldPayrollValues.setLastname(staffGroupUpdate.getStaffManyToMany().get(i).getLastname());
					oldPayrollValues.setPayrollno(staffGroupUpdate.getStaffManyToMany().get(i).getPayrollno());
					staffList.add(oldPayrollValues);

				}

			}

			for (int i = 0; i < staffGroupUpdate.getDoors().size(); i++) {
				TotalDoorsModal oldValues = staffGroupUpdate.getDoors().get(i);
				long doorname = oldValues.getDoorName();
				System.out.println("The payroll is " + doorname);
				TotalDoorsModal oldDoorValues = doorRepo.findBydoorName(doorname);
				if (oldDoorValues != null) {
					oldDoorValues.setDoorName(staffGroupUpdate.getDoors().get(i).getDoorName());
					doorslist.add(oldDoorValues);
				}

			}

			System.out.println("the tags size is " + staffGroupUpdate.getTags().size());
			for (int i = 0; i < staffGroupUpdate.getTags().size(); i++) {
				StaffGroupTags oldValues = staffGroupUpdate.getTags().get(i);
				System.out.println("the tags are " + staffGroupUpdate.getTags().toString());
				oldValues.setStaffid(staffGroupUpdate.getStaffManyToMany().get(i).getStaffid());

				StaffGroupTags staffid = tagsRepo
						.findBystaffid(staffGroupUpdate.getStaffManyToMany().get(i).getStaffid());
				if (staffid != null) {
					staffid.setStaffid(staffGroupUpdate.getStaffManyToMany().get(i).getStaffid());
					staffid.setTagNumber(staffGroupUpdate.getTags().get(i).getTagNumber());
					taglist.add(staffid);
					tagsRepo.save(staffid);

				} else {
					taglist.add(oldValues);
					tagsRepo.save(oldValues);
				}
//				 if(tagnumber==null)
//				 {

//				 }
//				 else
//				 {
//					 throw new Exception("The tag is already used");
//				 }
//				
				// oldDoorValues.setDoorName(staffGroupUpdate.getDoors().get(i).getDoorName());

			}

			System.out.println("entwaskjlasdkj");
			// newStaffGroup.setStaffGroupName(staffGroupUpdate.getStaffGroupName());
			newStaffGroup.setCreatedDate(staffGroupUpdate.getCreatedDate());
			newStaffGroup.setStaffGroupName(staffGroupUpdate.getStaffGroupName());
			newStaffGroup.setStaffManyToMany(staffList);
			newStaffGroup.setSites(groupSite);
			newStaffGroup.setDoors(doorslist);
			newStaffGroup.setTags(taglist);

			// newStaffGroup.setSites(staffgroup.getSites().get(0));

			StaffGroupManytoMany savedValues = staffGroupRepo.save(newStaffGroup);
			if (staffGroupRepo.findById(savedValues.getGroupid()).isPresent()) {
				List<StaffManyToMany> embeddedstaff = savedValues.getStaffManyToMany();
				for (int i = 0; i <embeddedstaff.size(); i++) {
					long staffid = embeddedstaff.get(i).getStaffid();
					String staffName = embeddedstaff.get(i).getFirstname() + embeddedstaff.get(i).getLastname();
					
					
					

					List<Long> schedulemodal = staffRepo.getSchedules(staffid);
					System.out.println("the staffs are " + schedulemodal.toString());
					String expireDate = embeddedstaff.get(i).getExpiraydate().toString();
					long tagCode = savedValues.getTags().iterator().next().getTagNumber();
					List<TotalDoorsModal> doorlist = new ArrayList();
					List<TotalDoorsModal> door = savedValues.getDoors();
					for (int j = 0; j < door.size(); j++) {
						TotalDoorsModal doorListvalue = doorRepo.findBydoorName(door.iterator().next().getDoorName());
						doorlist.add(doorListvalue);

					}
					EmbeddedStaffInformation result = new EmbeddedStaffInformation();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
					String exipre_date = formatter.format(embeddedstaff.get(i).getExpiraydate());
//				
					System.out.println("The staff information is " + result.toString());

					String staff_mqtt = staffid + "_" + staffName + "_" + exipre_date + "_" + tagCode + "_" + doorlist
							+ "_" + schedulemodal.toString();
					System.out.println("the staff information " + staff_mqtt);
					// staff_mqtt_array.add(staff_mqtt);
					InetAddress address = InetAddress.getByName(this.clientIp);
					boolean reachable = address.isReachable(1000);

					System.out.println("Is host reachable? " + reachable);
					// boolean res=serverListening(this.clientIp, 139);

//					boolean res =isRemotePortInUse(this.clientIp,4200);
//					System.out.println("Is host result is? " + res);
//					// String output = exec('ping 127.0.0.1');
//					if (reachable) {
					//
//						publisher.publishMessage("staffid", staff_mqtt);
//						subscriber.subscribeMessage("staffid");
					
					List<CreateSiteModal> sites = savedValues.getSites();
					for (int j = 0; j < sites.size(); j++)
					{
						String deviceid = savedValues.getSites().get(j).getDeviceId();
						System.out.println("the device id" + deviceid);
						String StaffID = "Staff ID" + staffid;
						BackTasksModal staffmodal = backTaskRepo.getBackTaskWithStaffID1(StaffID,deviceid);
						
						if (staffmodal != null) {
							System.out.println("The Staff information already present");
						} else {
							Calendar cal = Calendar.getInstance();
							System.out.println("The time is    " + cal.getTime());
							Date date = new Date();
							SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
							String stringDate = DateFor.format(date);
							BackTasksModal modal = new BackTasksModal();
							modal.setDateAndTime(stringDate);
							modal.setPriority(1);
							modal.setTaskDescription("Staff creation  with id " + staffid);
							modal.setTaskNo("Staff ID" + staffid);
							modal.setTaskStatus("pending");
//							for (int j = 0; j < savedValues.getSites().size(); j++) {
//								String deviceid = savedValues.getSites().get(j).getDeviceId();
//								System.out.println("the device id" + deviceid);
								modal.setDeviceid(Long.parseLong(deviceid));
							//}
							
							// String time =java.time.LocalTime.now().toString();
							// System.out.println(java.time.LocalTime.now());
							String time = String.valueOf(date.getHours() + ":" + date.getMinutes());
							modal.setTaskTime(time);
							backTaskRepo.save(modal);
						
					}
//						
//					} else {
//					String StaffID = "Staff ID" + staffid;
//					BackTasksModal staffmodal = backTaskRepo.getBackTaskWithStaffID1(StaffID);
//					
						// staff_mqtt_array.add(staff_mqtt);
					}

				}
				return savedValues;

				//
			}

			//

			// }

		} else {
			return null;
		}

		return staffGroupUpdate;
	}

	public ResponseEntity<Object> deleteStaffGroup(long id) {
		if (staffGroupRepo.findById(id).isPresent()) {

			staffGroupRepo.deleteMappedDoor(id);
			staffGroupRepo.deleteMappedTag(id);

			staffGroupRepo.deleteMappedStaff(id);
			staffGroupRepo.deleteMappedSite(id);

			staffGroupRepo.deleteById(id);

			if (staffGroupRepo.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
			} else
				return ResponseEntity.ok().body("Successfully deleted specified record");

		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found");
	}

	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub

	}

	public static boolean serverListening(String host, int port) {
		Socket s = null;
		try {
			s = new Socket(host, port);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (Exception e) {
				}
		}
	}

	private boolean isRemotePortInUse(String hostName, int portNumber) {
		try {
			// Socket try to open a REMOTE port
			new Socket(hostName, portNumber).close();
			// remote port can be opened, this is a listening port on remote machine
			// this port is in use on the remote machine !
			return true;
		} catch (Exception e) {
			// remote port is closed, nothing is running on
			return false;
		}
	}

}
