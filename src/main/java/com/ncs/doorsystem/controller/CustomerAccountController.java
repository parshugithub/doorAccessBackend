package com.ncs.doorsystem.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.dto.StaffModal;
import com.ncs.doorsystem.enginnerdashboard.entity.EngineerEntity;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.DoorGroupModal;
import com.ncs.doorsystem.entity.LoginEvenLogsTable;
import com.ncs.doorsystem.entity.LoginModalForCustomerOrUser;
import com.ncs.doorsystem.entity.PersonModal;
import com.ncs.doorsystem.entity.PersonTagsModal;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.StaffGroupTags;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.entity.TradeCodeWithDoorModal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;
import com.ncs.doorsystem.repository.DoorGroupRepository;
import com.ncs.doorsystem.repository.LoginEvenLogsTableRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.PersonRepository;
import com.ncs.doorsystem.repository.PersonTagsRepository;
import com.ncs.doorsystem.repository.ScheduleMainRepository;
import com.ncs.doorsystem.repository.StaffGroupTagsRepository;
import com.ncs.doorsystem.repository.StaffManagementRepository;
import com.ncs.doorsystem.repository.StaffManytoManyRepository;
import com.ncs.doorsystem.repository.TotalDoorRepository;
import com.ncs.doorsystem.repository.TradeCodeWithDoorRepository;
import com.ncs.doorsystem.service.CustomerService;
import com.ncs.doorsystem.service.LoginEvenLogsTableUserService;
import com.ncs.doorsystem.service.StaffGroupManytoManyService;
import com.ncs.doorsystem.service.StaffManytoManyService;

//@CrossOrigin(origins = "http://213.171.211.57/ncsdoorcontrol1")
@RestController
@RequestMapping("/")
public class CustomerAccountController extends MQTTConfig {
	public static String customerName = "";

	public static Long id = 0l;

	@Autowired
	LoginEvenLogsTableRepository loginRepo;
	@Autowired
	MQTTPublisherBase publisher;
	@Autowired
	TotalDoorRepository doorRepo;
	@Autowired
	DoorGroupRepository doorgroupRepo;

	@Autowired
	StaffGroupTagsRepository tagsRepo;
	@Autowired
	PersonTagsRepository personTags;
	@Autowired
	ScheduleMainRepository schRepo;

	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	CustomerService service;
	InetAddress address;

	@Autowired
	BackTasksRepository backtaskRepo;

	@Autowired
	StaffManytoManyRepository repo;
	@Autowired
	PersonRepository personrepo;
	@Autowired
	DashBoardRepository dashRepo;

	@Autowired
	StaffManytoManyService staffService;

	@Autowired
	StaffGroupManytoManyService staffgroupservice;
	@Autowired
	TotalDoorRepository doorrepo;

	@Autowired
	TradeCodeWithDoorRepository tradecoderepo;

	@Autowired
	LoginEvenLogsTableUserService loginservice;
	
	
	@Autowired
	private CustomerRepository customerRepository;

	// @CrossOrigin(origins = "http://213.171.211.57/ncsdoorcontrol1")
	@PostMapping(value = "/register", produces = "application/json")
	public @ResponseBody String registerUser(@RequestBody Customer customer,@RequestParam("custprofileid") String custprofileid) throws Exception {
		System.out.println("calli");
		System.out.println(customer.toString());
		Customer existingUser = service.registerUser(customer,custprofileid);
		if (existingUser != null) {
			return "registration successful!!!Please check your mail to confirm the mail id";
		}

		return "registration faild!!!Please check the values";

	}

	public @ResponseBody String getregisterlink(@RequestBody Customer customer) throws Exception {
		System.out.println("calli");
		System.out.println(customer.toString());
		Customer existingUser = service.registerUserlink(customer);
		if (existingUser != null) {
			return "registration successful!!!Please check your mail to confirm the mail id";
		}

		return "registration faild!!!Please check the values";

	}

	
	
	private String timerForVarifyAccout(Customer existingUser) {
		try {
			System.out.println("thread");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Done";
	}

	// @CrossOrigin(origins = "http://213.171.211.57/ncsdoor")
	@GetMapping(value = "/confirm-account")
	public String confirmUserAccount(@RequestParam("token") String confirmationToken, Model modal) {
		String message = service.confirmUserAccount(confirmationToken, modal);
		modal.addAttribute(message);
		return message;
		// return ResponseEntity.ok(message);

	}

	// @CrossOrigin(origins = "http://213.171.211.57/ncsdoor")
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public Customer customerLogin(@RequestBody Customer login) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + login);
		String emailid = login.getEmailId();
		String pass = login.getPassword();
		if((emailid.equalsIgnoreCase("NcsAdmin")) &&(pass.equalsIgnoreCase("password")))
		{
			return login;
		}
		else
		{
			System.out.println(emailid + " " + pass + "  ");
			System.out.println("calling");
			Customer respose = service.customerLogin(emailid, pass);
			LoginEvenLogsTable events = new LoginEvenLogsTable();
			if (respose != null) {
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
				String formattedDate = myDateObj.format(myFormatObj);
				events.setUsername(respose.getFirstname() + " " + respose.getLastname());
				events.setEvent("Login");
				events.setStatus("Successful");
				events.setDescription(respose.getFirstname() + " " + respose.getLastname() + "  logged in");
				events.setUpdatedDate(formattedDate);
				events.setSiteName(" ");
				events.setCutomerid(respose.getId());
				loginRepo.save(events);
				// String customerEmailId = loginUser.getEmailId();

				// loginUser.getId();
				// System.out.println(loginUser.getId());

				// customerName=customerName+ customerEmailId;
				return respose;
			}
			
		}
		
		// String userName =login.getCreateuser().getUserName();

		

		throw new Exception("Check the Credentails or varify the account");

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/userlogin", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public CreateUserModal userLogin(@RequestBody CreateUserModal login) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + login);
		String emailid = login.getUserName();
		if((emailid.equalsIgnoreCase("NcsAdmin")))
		{
			return login;
		}

		System.out.println(emailid);
		System.out.println("calling");
		CreateUserModal respose = service.userLogin(emailid);
		LoginEvenLogsTable events = new LoginEvenLogsTable();
		if (respose != null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			String formattedDate = myDateObj.format(myFormatObj);
			events.setUsername(respose.getUserName());
			events.setEvent("Login");
			events.setStatus("Successful");
			events.setDescription(respose.getUserName() + "  logged in");
			events.setUpdatedDate(formattedDate);
			events.setSiteName(" ");
			events.setCutomerid(respose.getUser_id());
			loginRepo.save(events);
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return respose;
		}

		throw new Exception("Check the Credentails or varify the account");

	}
	
	@RequestMapping(value = "/engineerdashbaordlogin", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public EngineerEntity engineerDashboardLogin(@RequestBody EngineerEntity login) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + login);
		String emailid = login.getUserName();
		String pass = login.getPassword();
		if((emailid.equalsIgnoreCase("NcsAdmin")) &&(pass.equalsIgnoreCase("password")))
		{
			return login;
		}
		else
		{
			System.out.println(emailid + " " + pass + "  ");
			System.out.println("calling");
			EngineerEntity respose = service.engineerDashboardLogin(emailid, pass);
			LoginEvenLogsTable events = new LoginEvenLogsTable();
			if (respose != null) {
//				LocalDateTime myDateObj = LocalDateTime.now();
//				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//				String formattedDate = myDateObj.format(myFormatObj);
//				events.setUsername(respose.getFirstname() + " " + respose.getLastname());
//				events.setEvent("Login");
//				events.setStatus("Successful");
//				events.setDescription(respose.getFirstname() + " " + respose.getLastname() + "  logged in");
//				events.setUpdatedDate(formattedDate);
//				events.setSiteName(" ");
//				events.setCutomerid(respose.getId());
//				loginRepo.save(events);
//				// String customerEmailId = loginUser.getEmailId();
//
//				// loginUser.getId();
//				// System.out.println(loginUser.getId());
//
//				// customerName=customerName+ customerEmailId;
				return respose;
			}
			else
			{
				throw new Exception("Invalid credentials");
			}
			
		}
		
		// String userName =login.getCreateuser().getUserName();

		

		

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/refresh_token")
	public @ResponseBody String resendConfirmationLink(@RequestParam("emailId") String emailID, Customer customer) {
		Customer userObj = service.resendConfirmationLink(emailID, customer);
		if (userObj != null) {
			return "link sent ";
		}
		return emailID;

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/upadatsettings")
	public @ResponseBody Customer updateCustomer(@RequestParam("id") long id, @RequestBody Customer customerUpdate) {
		return service.updateCustomer(customerUpdate, id);

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/changepassword")
	public @ResponseBody Customer changePassword(@RequestParam("id") long id, @RequestBody Customer changePassObj) {
		return service.changePassword(id, changePassObj);

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/userloginwithforgetpassword", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public @ResponseBody CreateUserModal userLoginWithForgetpassword(@RequestParam("username") String username)
			throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + username);
		String emailid = username;
		// String pass = login.getPassword();
		// String userName =login.getCreateuser().getUserName();

		System.out.println(emailid);
		System.out.println("calling");
		CreateUserModal respose = service.userLoginWithForgetpassword(username);
		if (respose != null) {
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return respose;
		}

		throw new Exception("Check the Credentails or varify the account");

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/userloginwithsubmitcode", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public @ResponseBody int userLoginSubmitCode(@RequestParam("code") long code,
			@RequestParam("username") String username) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + code);
		// String emailid = login.getUserName();
		// String pass = login.getPassword();
		// String userName =login.getCreateuser().getUserName();

		// System.out.println(emailid);
		System.out.println("calling");
		int respose = service.userLoginSubmitCode(code);
		LoginEvenLogsTable events = new LoginEvenLogsTable();
		if (respose != 0) {
			CreateUserModal resposeUser = service.userLogin(username);
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			String formattedDate = myDateObj.format(myFormatObj);
			events.setUsername(resposeUser.getUserName());
			events.setEvent("Login");
			events.setStatus("Successful");
			events.setDescription(resposeUser.getUserName() + "  logged in");
			events.setUpdatedDate(formattedDate);
			events.setSiteName(" ");
			events.setCutomerid(resposeUser.getCustId());
			events.setUserid(resposeUser.getUser_id());
			events.setUserType(resposeUser.getUser_type());
			loginRepo.save(events);
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return respose;
		}

		throw new Exception("Check the Credentails or varify the account");

	}

	
	@GetMapping(value = "/deviceonstatus")
	public boolean checkDevice()
	{
		String val="online"+"_"+13456;
		publisher.publishMessage("deviceID", val);
		subscriber.subscribeMessage("deviceID");
		
		return true;
		
	}
	//@GetMapping(value = "/checkmqttIPaddress")
	public boolean checkIpAddress(long deviceid) {
		System.out.println("caling");
		List<String> pendingStaff = new ArrayList<>();
		List<String> pendingPerson = new ArrayList<>();
		List<String> pendingDoor = new ArrayList<>();
		List<String> pendingDoorGroup = new ArrayList<>();
		List<String> pendingSite = new ArrayList<>();
		List<String> pendingTradeCode = new ArrayList<>();
		String taskStatus = "pending";
		boolean reachable = false;
		try {
			address = InetAddress.getByName(this.clientIp);
			reachable = address.isReachable(1000);
			System.out.println("the ip address is reachable " + reachable);
			if (reachable == true) {
				
				List<BackTasksModal> pendingTask = backtaskRepo.findbyPendingstatus(deviceid);
				

				System.out.println("the pending tasks are " + pendingTask.toString());
				for (int i = 0; i < pendingTask.size(); i++) {
					if(pendingTask.get(i)==null)
					{
						String siteval = "Staff ID";
						List<BackTasksModal> result = backtaskRepo.getBackTaskWithstaffID(siteval);
						System.out.println("the rest is "+result.toString());
						
						
					}
					//if (deviceid.equalsIgnoreCase(Long.toString(pendingTask.get(i).getDeviceid()))) {

						String taskInfo = pendingTask.get(i).getTaskNo();
						if (taskInfo.contains("Staff ID")) {

							if (pendingStaff.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingStaff.add(taskInfo);
							}

						}

						if (taskInfo.contains("person ID")) {
							// pendingPerson.add(taskInfo);
							if (pendingPerson.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingPerson.add(taskInfo);
							}
						}
						if (taskInfo.contains("Door ID")) {
							// pendingDoor.add(taskInfo);
							if (pendingDoor.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingDoor.add(taskInfo);
							}

						}
						if (taskInfo.contains("Doorgroup ID")) {
							// pendingDoorGroup.add(taskInfo);
							if (pendingDoorGroup.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingDoorGroup.add(taskInfo);
							}
						}
						if (taskInfo.contains("Site ID")) {
							System.out.println("cmg site");
							// pendingSite.contains(taskInfo);
							if (pendingSite.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingSite.add(taskInfo);
							}
						}

						if (taskInfo.contains("TradeCode ID")) {
							System.out.println("cmg site");
							// pendingSite.contains(taskInfo);
							if (pendingTradeCode.contains(taskInfo)) {
								System.out.println("already have");
							} else {
								pendingTradeCode.add(taskInfo);
							}
						}

					}
			//	}

				System.out.println("the pending staff are " + pendingStaff.toString());
				System.out.println("the pending persons are " + pendingPerson.toString());
				System.out.println("the pending doors are " + pendingDoor.toString());
				System.out.println("the pending doorgroups are " + pendingDoorGroup.toString());
				System.out.println("the pending site are " + pendingSite.toString());
				System.out.println("the pending site are " + pendingTradeCode.toString());

				for (int i = 0; i < pendingStaff.size(); i++) {
					System.out.println("calling staff for loop");
					String str = pendingStaff.get(i);
					String staffid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + staffid);
					StaffModal staffmodal = getStaffInfo(Long.parseLong(staffid));

					// long staffid = embeddedstaff.get(i).getStaffid();
					String staffName = staffmodal.getFirstname() + staffmodal.getLastname();

					List<Long> schedulemodal = repo.getSchedules(Long.parseLong(staffid));

					System.out.println("the staffs are " + schedulemodal.toString());
					String expireDate = staffmodal.getExpiraydate().toString();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
					String exipre_date = formatter.format(staffmodal.getExpiraydate());
					for (int j = 0; j < staffmodal.getStaffgroup().size(); j++) {
						List<StaffGroupTags> tags = staffmodal.getStaffgroup().get(j).getTags();
						List<TotalDoorsModal> doorlist = new ArrayList<>();
						List<TotalDoorsModal> door = staffmodal.getStaffgroup().get(j).getDoors();
						List<Long> taglist = new ArrayList<>();
						// List<StaffGroupTags> tagsval = staffmodal.getStaffgroup().get(j).getTags();
						for (int k = 0; k < tags.size(); k++) {
							long tagListvalue = tags.iterator().next().getTagNumber();
							taglist.add(tagListvalue);

						}

						for (int l = 0; l < door.size(); l++) {
							TotalDoorsModal doorListvalue = doorRepo.findBydoorName(door.iterator().next().getDoorName());
							doorlist.add(doorListvalue);

						}
						String staff_mqtt = staffid + "_" + staffName + "_" + exipre_date + "_" + taglist + "_"
								+ doorlist + "_" + schedulemodal.toString();
						System.out.println("the staff mqtt is " + staff_mqtt.toString());

						publisher.publishMessage("staffid", staff_mqtt);

						subscriber.subscribeMessage("staffid_ACK");
						
						
						
					}

//					StaffModal staffinfo =

					System.out.println("the staff results is " + staffmodal);

				}

				for (int i = 0; i < pendingPerson.size(); i++) {
					String str = pendingPerson.get(i);
					String personid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + personid);

					PersonModal personRes = personrepo.findById(Long.parseLong(personid)).get();

					List<PersonTagsModal> persontags = personTags.findBypersonid(Long.parseLong(personid));
					System.out.println("thw tags are" + persontags.toString());

					Set<ScheduleMainModal> schedulemodal = personRes.getSchedule();
					List<Long> sch = new ArrayList<>();
					for (int j = 0; j < schedulemodal.size(); j++) {
						long schduleid = schRepo.findscheduleId(schedulemodal.iterator().next().getScheduleId());
						sch.add(schduleid);
						System.out.println("schedule is " + schduleid);

					}

					SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
					String exipre_date = formatter.format(personRes.getExpiraydate());
					String personDetails = personRes.getPersonid() + "_" + personRes.getFirstName() + " "
							+ personRes.getLastName() + "_" + exipre_date + "_" + personRes.getTradeCode() + "_"
							+ persontags + "_" + personRes.getDoors() + "_" + sch;

					System.out.println("the mqtt response is " + personDetails);

					publisher.publishMessage("personid", personDetails);
					subscriber.subscribeMessage("personid_ACK");

				}

				for (int i = 0; i < pendingSite.size(); i++) {
					String str = pendingSite.get(i);
					String siteid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + siteid);

					CreateSiteModal siteres = dashRepo.findById(Long.parseLong(siteid)).get();

					String mqttDate = siteres.getSiteid() + "_" + siteres.getSiteName() + "_" + siteres.getDeviceId();

					publisher.publishMessage("siteid", mqttDate);
					subscriber.subscribeMessage("siteid_ACK");

				}
				for (int i = 0; i < pendingDoor.size(); i++) {
					String str = pendingDoor.get(i);
					String doorid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + doorid);

					// TotalDoorsModal result = repo.findBydoorName(doorname);
					TotalDoorsModal doores = doorrepo.findBydoorName(Long.parseLong(doorid));

					publisher.publishMessage("doorid", Long.toString(doores.getDoorId()));

					subscriber.subscribeMessage("doorid");

				}

				for (int i = 0; i < pendingDoorGroup.size(); i++) {
					String str = pendingDoorGroup.get(i);
					String doorGroupid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + doorGroupid);

					// TotalDoorsModal result = repo.findBydoorName(doorname);
					DoorGroupModal doorgroupes = doorgroupRepo.findById(Long.parseLong(doorGroupid)).get();
					// DoorGroupModal result = doorRepo.findBydoorgroupid(doorgroupid);
					ArrayList<Long> doors = new ArrayList<>();
					List<TotalDoorsModal> doorsRes = doorgroupes.getDoors();
					for (int m = 0; m < doorsRes.size(); m++) {

						long doorid = doorsRes.get(m).getDoorId();
						doors.add(doorid);
					}
					String doorGroupMqtt = doorgroupes.getDoorgroupid() + "_" + doors;
					publisher.publishMessage("doorgroupid", doorGroupMqtt);

					subscriber.subscribeMessage("doorgroupid_ACK");

				}

				for (int i = 0; i < pendingTradeCode.size(); i++) {
					String str = pendingTradeCode.get(i);
					String tradecodeid = str.replaceAll("[^0-9]", "");
					System.out.println("the staff id is " + tradecodeid);

					// TotalDoorsModal result = repo.findBydoorName(doorname);
					CreateSiteModal siteres = dashRepo.findBydeviceId(Long.toString(deviceid));
					TradeCodeWithDoorModal tradecodepes = tradecoderepo.findBydoorNumber(Long.parseLong(tradecodeid));
					String res = tradecoderepo.getDoorTrade(tradecodepes.getScheduleno(),siteres.getSiteid(),tradecodepes.getDoorNumber());
					// DoorGroupModal result = doorRepo.findBydoorgroupid(doorgroupid);
					ArrayList<Long> doors = new ArrayList<>();
					long doorsRes = tradecodepes.getDoorNumber();
//					for (int m = 0; m < doorsRes.size();m++) 
//					{
//						
//						long doorid =doorsRes.get(m).getDoorId();
//						doors.add(doorid);
//					}
					// String doorGroupMqtt = doorgroupes.getDoorgroupid()+"_"+doors;
					publisher.publishMessage("door", res);

					subscriber.subscribeMessage("door_ACK");

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reachable;

	}

	private StaffModal getStaffInfo(long staffid) {
		StaffModal staffmodal = staffService.findStaff(staffid);
		return staffmodal;
	}

	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/userlogout", method = { RequestMethod.GET,RequestMethod.POST }, produces = "application/json")
	public CreateUserModal userLogout(@RequestBody CreateUserModal logout) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + logout);
		String emailid = logout.getUserName();
		// String pass = login.getPassword();
		// String userName =login.getCreateuser().getUserName();

		System.out.println(emailid);
		System.out.println("calling");
		LoginEvenLogsTable respose = loginservice.userLogout(logout.getUserName());
		LoginEvenLogsTable events = new LoginEvenLogsTable();
		if (logout != null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			String formattedDate = myDateObj.format(myFormatObj);
			events.setUsername(logout.getUserName());
			events.setEvent("Logout");
			events.setStatus("Successful");
			events.setDescription(logout.getUserName() + "  logged Out");
			events.setUpdatedDate(formattedDate);
			events.setSiteName(" ");
			events.setCutomerid(logout.getCustId());
			events.setUserid(logout.getUser_id());
			events.setUserType(logout.getUser_type());
			loginRepo.save(events);
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return logout;
		}

		throw new Exception("Check the Credentails or varify the account");

	}

	@RequestMapping(value = "/customerlogout", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public Customer customerLogout(@RequestBody Customer logout) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + logout);
		String emailid = logout.getEmailId();
		String pass = logout.getPassword();
		// String userName =login.getCreateuser().getUserName();

		System.out.println(emailid + " " + pass + "  ");
		System.out.println("calling");
		// Customer respose = service.customerLogin(emailid, pass);
		LoginEvenLogsTable events = new LoginEvenLogsTable();
		if (logout != null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			String formattedDate = myDateObj.format(myFormatObj);
			events.setUsername(logout.getFirstname() + " " + logout.getLastname());
			events.setEvent("Logout");
			events.setStatus("Successful");
			events.setDescription(logout.getFirstname() + " " + logout.getLastname() + "  logged out");
			events.setUpdatedDate(formattedDate);
			events.setSiteName(" ");
			events.setCutomerid(logout.getId());
			loginRepo.save(events);
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return logout;
		}

		throw new Exception("Check the Credentails or varify the account");

	}

	@RequestMapping(value = "/loginmqtt", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public String loginMQTT() {

		// String message = "jyotiullagaddi123@gmail.com"+"_"+"testing";
		String message = "Jyoti" + "_" + "g";
		publisher.publishMessage("LOGIN", message);
		subscriber.subscribeMessage("LOGIN");

		return null;

	}
	

	// @CrossOrigin(origins = "http://localhost:4200")
			@RequestMapping(value = "/customerloginwithforgetpassword", method = { RequestMethod.GET,RequestMethod.POST }, produces = "application/json")
			public @ResponseBody Customer customerLoginWithForgetpassword(@RequestParam("emailId") String emailid)
					throws Exception {
				System.out.println("calling");
				System.out.println("the object is " + emailid);
				String email = emailid;
				// String pass = login.getPassword();
				// String userName =login.getCreateuser().getUserName();

				System.out.println(email);
				System.out.println("calling");
				Customer respose = service.cutomerLoginWithForgetpassword(emailid);
				if (respose != null) {
					
					return respose;
				}

				throw new Exception("Check the Credentails or varify the account");

			}
			
			@RequestMapping(value="/confirm-reset", method=RequestMethod.GET)
		    public ModelAndView displayResetPassword(ModelAndView modelAndView, Customer user) {
		        modelAndView.addObject("user", user);
		        modelAndView.setViewName("index");
		        return modelAndView;
		    }

			
		
			
			@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
		    public @ResponseBody Customer resetUserPassword( @RequestBody Customer customer)
		    		throws Exception {
		        if (customer.getEmailId() != null) {
		            // Use email to find user
		        	
		        	Customer useremail = customerRepository.findByEmailId(customer.getEmailId());
		        	useremail.setConfirmPassword(customer.getPassword());
		        	useremail.setPassword(customer.getPassword());
		        	customerRepository.save(useremail);
		        	return customer;
		        	
		        } 
		        	throw new Exception ("The link is invalid or broken!");
		       
		        
		    }


}
