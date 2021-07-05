package com.ncs.doorsystem.service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.ChannelTag;
import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.Door;
import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.PersonManagementPersonClassModal;
import com.ncs.doorsystem.entity.PersonManagementPersonGroup;
import com.ncs.doorsystem.entity.PersonManagementProperty;
import com.ncs.doorsystem.entity.PersonMangementPersonModal;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.entity.Property;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.ChannelsRepository;
import com.ncs.doorsystem.repository.ChannelsTagsRepository;
import com.ncs.doorsystem.repository.ChannnelsDoorsRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;
import com.ncs.doorsystem.repository.DoorGroupRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.PersonClassRepository;
import com.ncs.doorsystem.repository.PersonGroupRepository;
import com.ncs.doorsystem.repository.PersonManagementGroupRepository;
import com.ncs.doorsystem.repository.PersonManagementRepository;
import com.ncs.doorsystem.repository.PersonMangementClassRepository;
import com.ncs.doorsystem.repository.PersonRepository;
import com.ncs.doorsystem.repository.PersonTagsRepository;
import com.ncs.doorsystem.repository.ScheduleMainRepository;
import com.ncs.doorsystem.repository.TagRepository;
import com.ncs.doorsystem.repository.TotalDoorRepository;

@Service
@Transactional
public class PersonManagementService extends MQTTConfig {
	@Autowired
	PersonManagementRepository repo;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	TagRepository tagRepo;

	@Autowired
	ChannelsTagsRepository chTagsRepo;

	@Autowired
	ChannelsRepository chRepo;

	@Autowired
	ChannnelsDoorsRepository chDoorRepo;

	@Autowired
	MQTTPublisherBase publisher;

	List<ChannelTag> tags;

	List<Door> doors;

	@Autowired
	TotalDoorRepository doorRepo;

	@Autowired
	DoorGroupRepository doorGroupRepo;

	@Autowired
	PersonManagementGroupRepository personGrouprepo;

	@Autowired
	PersonTagsRepository personTags;

	@Autowired
	ScheduleMainRepository schRepo;
	
	@Autowired
	BackTasksRepository backTaskRepo;

	ArrayList<String> staff_mqtt_array;
	@Autowired
	DashBoardRepository dashRepo;
	
	@Autowired
	PersonMangementClassRepository personClassRepo;

	public List<PersonMangementPersonModal> getAllPerson(long custID) {
		List<PersonMangementPersonModal> perosn = repo.findBywebappPerosnId(custID);
//		List<PersonDTO> pDTO = new ArrayList<>();
//		for (int i = 0; i < perosn.size(); i++)
//		{
//			PersonDTO pRes = new PersonDTO();
//			pRes.setAddress1(perosn.get(i).getAddress1());
//			pRes.setCity(perosn.get(i).getCity());
//			pRes.setCountry(perosn.get(i).getCountry());
//			pRes.setExpiraydate(perosn.get(i).getExpiraydate());
//			pRes.setFirstName(perosn.get(i).getFirstName());
//			pRes.setLastName(perosn.get(i).getLastName());
//			pRes.setMobileNumber(perosn.get(i).getMobileNumber());
//			pRes.setPersonid(perosn.get(i).getPersonid());
//			pRes.setState(perosn.get(i).getState());
//			pRes.setSiteid(perosn.get(i).getSiteid());
//			pRes.setWebappPerosnId(perosn.get(i).getWebappPerosnId());
//			pRes.setTradeCode(perosn.get(i).getTradeCode());
//			pRes.setPropery(perosn.get(i).getPropery());
//			//pRes.setPersonclass(getPersonClass(perosn.get(i)));
//		//	pRes.setPersongroup(getPersonGroup(perosn.get(i)));
//			pDTO.add(pRes);
//			
//		}
		return perosn;
	}

//	private List<PersonGroupDTO> getPersonGroup(PersonModal personModal)
//	{
//		List<PersonGroupDTO> pgDTO = new ArrayList<>();
//		for (int i = 0; i < personModal.getPersongroup().size(); i++)
//		{
//			PersonGroupDTO pgRes = new PersonGroupDTO();
//			pgRes.setCreateddate(personModal.getPersongroup().get(i).getCreateddate());
//			pgRes.setExpirydate(personModal.getPersongroup().get(i).getExpirydate());
//			pgRes.setPersongroupid(personModal.getPersongroup().get(i).getPersongroupid());
//			pgRes.setPersonGroupName(personModal.getPersongroup().get(i).getPersonGroupName());
//			pgDTO.add(pgRes);
//			
//			
//		}
//		
//		
//		return pgDTO;
//	}

//	private PersonClassDTO  getPersonClass(PersonModal personModal) {
//		List<PersonClassDTO> pcDTO = new ArrayList<>();
//		for (int i = 0; i < personModal.getPersonclassone().size(); i++) 
//		{
//			PersonClassDTO pcRes = new PersonClassDTO();
//			pcRes.setCreateddate(personModal.getPersonclassone().get(i).getCreateddate());
//			pcRes.setExpirydate(personModal.getPersonclassone().get(i).getExpirydate());
//			pcRes.setPersonclassid(personModal.getPersonclassone().get(i).getPersonclassid());
//			pcRes.setPersonClassName(personModal.getPersonclassone().get(i).getPersonClassName());
//			pcRes.setSiteid(personModal.getPersonclassone().get(i).getSiteid());
//			pcRes.setWebAppPersonClassid(personModal.getPersonclassone().get(i).getWebAppPersonClassid());
//			pcDTO.add(pcRes);
//			
//			
//			
//		}
//		return pcDTO;
//	}

	public List<PersonMangementPersonModal> getAllPersonsOfSite(long custID, long siteid) {
		List<PersonMangementPersonModal> perosn = repo.findBywebappPerosnIdAndsiteid(custID, siteid);
//		List<PersonDTO> pDTO = new ArrayList<>();
//		for (int i = 0; i < perosn.size(); i++)
//		{
//			PersonDTO pRes = new PersonDTO();
//			pRes.setAddress1(perosn.get(i).getAddress1());
//			pRes.setCity(perosn.get(i).getCity());
//			pRes.setCountry(perosn.get(i).getCountry());
//			pRes.setExpiraydate(perosn.get(i).getExpiraydate());
//			pRes.setFirstName(perosn.get(i).getFirstName());
//			pRes.setLastName(perosn.get(i).getLastName());
//			pRes.setMobileNumber(perosn.get(i).getMobileNumber());
//			pRes.setPersonid(perosn.get(i).getPersonid());
//			pRes.setState(perosn.get(i).getState());
//			pRes.setSiteid(perosn.get(i).getSiteid());
//			pRes.setWebappPerosnId(perosn.get(i).getWebappPerosnId());
//			pRes.setTradeCode(perosn.get(i).getTradeCode());
//			pRes.setPropery(perosn.get(i).getPropery());
//		//	pRes.setPersonclass(getPersonClass(perosn.get(i)));
//			//pRes.setPersongroup(getPersonGroup(perosn.get(i)));
//			pDTO.add(pRes);
//			
//		}
		return perosn;
		// return perosn;
	}

	public PersonMangementPersonModal createNewPerson(@Valid PersonMangementPersonModal modal, long custid, long siteid) throws Exception {
		System.out.println("The person modal is " + modal.toString());
		
		PersonMangementPersonModal mobile = repo.findmobileNumber(modal.getMobileNumber(),custid);
		System.out.println("the person class is " + modal.getPersonclassone().getPclassid());

		System.out.println("the tags are " + modal.getPropery());

		ArrayList<PersonManagementProperty> tagList = new ArrayList<>();
		HashSet<ScheduleMainModal> scheduleList = new HashSet<>();
		List<PersonManagementProperty> flats = modal.getPropery();

		for (int i = 0; i < modal.getSchedule().size(); i++) {
			scheduleList.addAll(modal.getSchedule());

		}
		for (int i = 0; i < flats.size(); i++) {
			long flatNumber = modal.getPropery().get(i).getFlatnumber();
			ChannelsModal flat = chRepo.findbyflat(flatNumber,custid,siteid);

			if (flat != null) {
				System.out.println("The tags are" + flat.getChannelid());

				tags = chTagsRepo.findTags(flat.getChannelid());

				doors = chDoorRepo.findDoor(flat.getChannelid());
				System.out.println("the channels respose is " + tags.toString());
				System.out.println("doors are " + doors.toString());

				// long channelId = tagRepo.find

			}

			tagList.addAll(modal.getPropery());

		}
//		PersonClassModal classmodal= new PersonClassModal();
//		classmodal.setWebAppPersonClassid(custid);
//		classmodal.setSiteid(siteid);

//		ArrayList<PersonClassModal> classlist= new ArrayList<>();
//		classlist.add(classmodal);
		if (mobile != null) {
			throw new Exception("The person is alreadt exists");
		} else {

			// modal.setPersonclass(modal.getPersonclass());
//			classmodal.setWebAppPersonClassid(custid);
//			classmodal.setSiteid(siteid);
			modal.setWebappPerosnId(custid);
			modal.setSiteid(siteid);
			modal.setPropery(tagList);
			System.out.println("the res " + tagList);
			modal.setSchedule(scheduleList);

			PersonMangementPersonModal saved = repo.save(modal);
			if (repo.findById(saved.getPersonid()).isPresent()) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
//				String exipre_date = formatter.format(saved.getExpiraydate());
//				String personDetails = saved.getPersonid() + "_" + saved.getFirstName() + " " + saved.getLastName()
//						+ "_" + exipre_date + "_" + saved.getTradeCode() + "_" + tags + "_" + doors;

				// publisher.publishMessage("personid", personDetails);
				return saved;

			}

			else
				return null;
		}

	}

	public PersonMangementPersonModal getPerson(long personid) {
		if (repo.findById(personid).isPresent()) {
			PersonMangementPersonModal personRes = repo.findById(personid).get();
//			PersonDTO pRes = new PersonDTO();
//			pRes.setAddress1(personRes.getAddress1());
//			pRes.setCity(personRes.getCity());
//			pRes.setCountry(personRes.getCountry());
//			pRes.setExpiraydate(personRes.getExpiraydate());
//			pRes.setFirstName(personRes.getFirstName());
//			pRes.setLastName(personRes.getLastName());
//			pRes.setMobileNumber(personRes.getMobileNumber());
//			pRes.setPersonid(personRes.getPersonid());
//			pRes.setState(personRes.getState());
//			pRes.setSiteid(personRes.getSiteid());
//			pRes.setWebappPerosnId(personRes.getWebappPerosnId());
//			pRes.setTradeCode(personRes.getTradeCode());
//			pRes.setPropery(personRes.getPropery());
			// pRes.setPersonclass(getPersonClass(personRes));
			// pRes.setPersongroup(getPersonGroup(personRes));
			return personRes;

		}
		return null;

	}

	public ResponseEntity<Object> deletePerson(long personid) {
		if (repo.findById(personid).isPresent()) {
			repo.deleteMappedPersonGroup(personid);
			repo.deleteMappedDoorGroup(personid);
			repo.deleteMappedDoor(personid);
			repo.deleteMappedSchedule(personid);
			repo.deleteById(personid);
			if (repo.findById(personid).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified person");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified person");
		}
		return null;
	}

	public PersonMangementPersonModal updatePesron(long personid, PersonMangementPersonModal personUpdate) {
		PersonMangementPersonModal oldValues = repo.findBypid(personid);
		// PersonClassModal classmodal= new PersonClassModal();
		System.out.println("The value is " + personUpdate.toString());
		System.out.println("The old value is " + oldValues.toString());
		HashSet<ScheduleMainModal> scheduleList = new HashSet<>();
		if (oldValues != null) {
			
			for (int i = 0; i < personUpdate.getSchedule().size(); i++) {
				ScheduleMainModal schedule = personUpdate.getSchedule().iterator().next();

				ScheduleMainModal existingschedule = schRepo.findByscheduleId(schedule.getScheduleId());
				if (existingschedule != null) {
//				existingDoorGroup.setCreatedDate(personUpdate.getDoorGroup().get(i).getCreatedDate());
//				existingDoorGroup.setDoorgroupid(personUpdate.getDoorGroup().get(i).getDoorgroupid());
//				existingDoorGroup.setDoorGroupName(personUpdate.getDoorGroup().get(i).getDoorGroupName());
//				existingDoorGroup.setExpiraydate(personUpdate.getDoorGroup().get(i).getExpiraydate());
					scheduleList.add(existingschedule);

				}

			}

			PersonManagementPersonClassModal personclass = personClassRepo.findBypclassid(personUpdate.getPersonclassone().getPclassid());
			System.out.println("the person class object is "+personclass.toString());
			if(personclass!=null)
			{
				personclass.setCreateddate(personclass.getCreateddate());
				personclass.setExpirydate(personclass.getExpirydate());
				personclass.setPclassid(personclass.getPclassid());
				personclass.setPersonClassName(personclass.getPersonClassName());
				personclass.setSiteid(personclass.getSiteid());
				personclass.setWebAppPersonClassid(personclass.getWebAppPersonClassid());
				System.out.println("the person class object is "+personclass.toString());
				
			}
			oldValues.setAddress1(personUpdate.getAddress1());
			oldValues.setPropery(personUpdate.getPropery());
			oldValues.setAddress2(personUpdate.getAddress2());
			oldValues.setCity(personUpdate.getCity());
			oldValues.setCountry(personUpdate.getCountry());
			oldValues.setFirstName(personUpdate.getFirstName());
			oldValues.setLastName(personUpdate.getLastName());
			oldValues.setPersonclassone(personclass);
			oldValues.setEmail(personUpdate.getEmail());
			oldValues.setTelnumber(personUpdate.getTelnumber());
			oldValues.setSipurl(personUpdate.getSipurl());
			oldValues.setAreaCode(personUpdate.getAreaCode());
			// oldValues.setGender(personUpdate.getGender());
			oldValues.setMobileNumber(personUpdate.getMobileNumber());
			oldValues.setState(personUpdate.getState());
			oldValues.setExpiraydate(personUpdate.getExpiraydate());
			oldValues.setTradeCode(personUpdate.getTradeCode());
			// oldValues.setZipcode(personUpdate.getZipcode());
			// oldValues.setPersonclass(personUpdate.getPersonclass());
			oldValues.setSchedule(scheduleList);
			PersonMangementPersonModal updated = repo.save(oldValues);
			if (repo.findById(updated.getPersonid()).isPresent())
				return updated;
			else
				return null;

		}
		return personUpdate;
	}

	public List<ChannelsModal> getflatnumber(long custid, long siteid) {
		return chRepo.findAllBasedOnCustIdAndSiteid(custid,siteid);
	}

	public PersonMangementPersonModal updatePesronWithGroups(long personid, PersonMangementPersonModal personUpdate, long custid, long siteid) {

		System.out.println("the object is " + personUpdate.toString());

		HashSet<TotalDoorsModal> doorsList = new HashSet<>();
		ArrayList<DoorGroupModal> doorGroupList = new ArrayList<>();
		ArrayList<PersonManagementPersonGroup> personGroup = new ArrayList<>();
		HashSet<ScheduleMainModal> scheduleList = new HashSet<>();

		PersonMangementPersonModal updatePerson = repo.findBypid(personid);
		if (updatePerson != null) {

			for (int i = 0; i < personUpdate.getPersongroup().size(); i++) {
				PersonManagementPersonGroup personGrouplist = personUpdate.getPersongroup().get(i);
				//System.out.println("the person group "+personGrouplist.to);

				PersonManagementPersonGroup existingPersonGroup = personGrouprepo
						.findBypersonGroupName(personGrouplist.getPersonGroupName());

				if (existingPersonGroup != null) {
					System.out.println("The person groups are " + existingPersonGroup.toString());
//				existingPersonGroup.setPersonGroupName(personUpdate.getPersongroup().get(i).getPersonGroupName());
//				existingPersonGroup.setPersongroupid(personUpdate.getPersongroup().get(i).getPersongroupid());
//				existingPersonGroup.setCreateddate(personUpdate.getPersongroup().get(i).getCreateddate());
//				existingPersonGroup.setExpirydate(personUpdate.getPersongroup().get(i).getExpirydate());
					// personGrouplist.setSiteid(personUpdate.getPersongroup().get(i).getSiteid());
					personGroup.add(existingPersonGroup);
				}

			}

			for (int i = 0; i < personUpdate.getDoors().size(); i++) {
				TotalDoorsModal allDoors = personUpdate.getDoors().iterator().next();

				TotalDoorsModal existingDoor = doorRepo.findBydoorId(allDoors.getDoorId());
				if (existingDoor != null) {
//				existingDoor.setDoorName(personUpdate.getDoors().get(i).getDoorName());
//				existingDoor.setDoorId(personUpdate.getDoors().get(i).getDoorId());
					doorsList.add(existingDoor);
				}

			}

			for (int i = 0; i < personUpdate.getDoorGroup().size(); i++) {
				DoorGroupModal doorGroup = personUpdate.getDoorGroup().get(i);

				DoorGroupModal existingDoorGroup = doorGroupRepo.findBydoorgroupid(doorGroup.getDoorgroupid());
				if (existingDoorGroup != null) {
					System.out.println("The door groups groups are " + existingDoorGroup.toString());
//				existingDoorGroup.setCreatedDate(personUpdate.getDoorGroup().get(i).getCreatedDate());
//				existingDoorGroup.setDoorgroupid(personUpdate.getDoorGroup().get(i).getDoorgroupid());
//				existingDoorGroup.setDoorGroupName(personUpdate.getDoorGroup().get(i).getDoorGroupName());
//				existingDoorGroup.setExpiraydate(personUpdate.getDoorGroup().get(i).getExpiraydate());
					doorGroupList.add(existingDoorGroup);

				}

			}

			for (int i = 0; i < personUpdate.getSchedule().size(); i++) {
				ScheduleMainModal schedule = personUpdate.getSchedule().iterator().next();

				ScheduleMainModal existingschedule = schRepo.findByscheduleId(schedule.getScheduleId());
				if (existingschedule != null) {
//				existingDoorGroup.setCreatedDate(personUpdate.getDoorGroup().get(i).getCreatedDate());
//				existingDoorGroup.setDoorgroupid(personUpdate.getDoorGroup().get(i).getDoorgroupid());
//				existingDoorGroup.setDoorGroupName(personUpdate.getDoorGroup().get(i).getDoorGroupName());
//				existingDoorGroup.setExpiraydate(personUpdate.getDoorGroup().get(i).getExpiraydate());
					scheduleList.add(existingschedule);

				}

			}
			
			System.out.println("person calass id"+personUpdate.getPersonclassone().getPclassid());
			PersonManagementPersonClassModal personclass = personClassRepo.findBypclassid(personUpdate.getPersonclassone().getPclassid());
			System.out.println("the person class object is "+personclass.toString());
			if(personclass!=null)
			{
				personclass.setCreateddate(personclass.getCreateddate());
				personclass.setExpirydate(personclass.getExpirydate());
				personclass.setPclassid(personclass.getPclassid());
				personclass.setPersonClassName(personclass.getPersonClassName());
				personclass.setSiteid(siteid);
				personclass.setWebAppPersonClassid(custid);
				System.out.println("the person class object is "+personclass.toString());
				
			}
			
			
			updatePerson.setAddress1(personUpdate.getAddress1());
			updatePerson.setPropery(personUpdate.getPropery());
			updatePerson.setAddress2(personUpdate.getAddress2());
			updatePerson.setCity(personUpdate.getCity());
			updatePerson.setCountry(personUpdate.getCountry());
			updatePerson.setFirstName(personUpdate.getFirstName());
			updatePerson.setLastName(personUpdate.getLastName());
			updatePerson.setPersonclassone(personUpdate.getPersonclassone());
			updatePerson.setEmail(personUpdate.getEmail());
			updatePerson.setTelnumber(personUpdate.getTelnumber());
			updatePerson.setSipurl(personUpdate.getSipurl());
			updatePerson.setAreaCode(personUpdate.getAreaCode());
			// oldValues.setGender(personUpdate.getGender());
			updatePerson.setMobileNumber(personUpdate.getMobileNumber());
			updatePerson.setState(personUpdate.getState());
			updatePerson.setExpiraydate(personUpdate.getExpiraydate());
			updatePerson.setTradeCode(personUpdate.getTradeCode());
			// oldValues.setZipcode(personUpdate.getZipcode());
			// oldValues.setPersonclass(personUpdate.getPersonclass());
			updatePerson.setSchedule(scheduleList);

			updatePerson.setDoorGroup(doorGroupList);
			updatePerson.setDoors(doorsList);
			updatePerson.setPersongroup(personGroup);

			System.out.println("the object is " + updatePerson.toString());
			PersonMangementPersonModal saved = repo.save(updatePerson);
			//PersonMangementPersonModal saved1 = new PersonMangementPersonModal();
			System.out.println("the person id is " + saved.getPersonid());

			List<PersonTagsModal> persontags = personTags.findBypersonid(saved.getPersonid());
			System.out.println("thw tags are" + persontags.toString());

			Set<ScheduleMainModal> schedulemodal = saved.getSchedule();
			List<Long> sch = new ArrayList<>();
			for (int j = 0; j < schedulemodal.size(); j++) {
				long schduleid = schRepo.findscheduleId(schedulemodal.iterator().next().getScheduleId());
				sch.add(schduleid);
				System.out.println("schedule is " + schduleid);

			}

			SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
			String exipre_date = formatter.format(saved.getExpiraydate());
			String personDetails = saved.getPersonid() + "_" + saved.getFirstName() + " " + saved.getLastName() + "_"
					+ exipre_date + "_" + saved.getTradeCode() + "_" + persontags + "_" + saved.getDoors() + "_" + sch;

			System.out.println("the mqtt response is " + personDetails);
			
			try {
				InetAddress address = InetAddress.getByName(this.clientIp);
//				boolean reachable = address.isReachable(1000);
//				if (reachable) {
//					publisher.publishMessage("personid", personDetails);
//					subscriber.subscribeMessage("personid");
//				} else {
				CreateSiteModal site=dashRepo.findById(siteid).get();
					String personID = "person ID" + saved.getPersonid();
					BackTasksModal personmodal =backTaskRepo.getBackTaskWithPersonID(personID);
					if(personmodal!=null)
					{
						System.err.println("The person information alreday in Backtask");
					}
					else
					{
						Calendar cal = Calendar.getInstance();
						System.out.println("The time is    " + cal.getTime());
						Date date = new Date();
						SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
						String stringDate = DateFor.format(date);
						BackTasksModal modal = new BackTasksModal();
						modal.setDateAndTime(stringDate);
						modal.setPriority(1);
						modal.setTaskDescription("Person creation  pending with id " + saved.getPersonid());
						modal.setTaskNo("person ID" + saved.getPersonid());
						modal.setTaskStatus("pending");
						modal.setDeviceid(Long.parseLong(site.getDeviceId()));
						// String time =java.time.LocalTime.now().toString();
						// System.out.println(java.time.LocalTime.now());
						String time = String.valueOf(date.getHours() + ":" + date.getMinutes());
						modal.setTaskTime(time);
						backTaskRepo.save(modal);
					}
					
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return saved;
		} else

		{
			return personUpdate;
		}

		// return saved;
	}

	public long getflat(long flat) {

		return chRepo.getflat(flat);
	}

	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub

	}

}
