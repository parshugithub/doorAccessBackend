package com.ncs.doorsystem.controller;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.dto.CreateSiteDto;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.DashBoardmodal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.CreateSiteRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.MQTTSubscriberBase;
import com.ncs.doorsystem.repository.TotalDoorRepository;
import com.ncs.doorsystem.service.DashboardSerive;
import com.ncs.doorsystem.service.MQTTSubscriber;

//@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController

@RequestMapping("/dashboard")
public class DashboardController  extends MQTTConfig
{
	
	@Autowired
	DashboardSerive dashboardService;
	
	@Autowired
	TotalDoorRepository dRepo;
	@Autowired
	BackTasksRepository backTasksRepository;
	@Autowired
	MQTTPublisherBase publisher;
	@Autowired
	MQTTSubscriberBase subscriber;
	@Autowired
	CreateSiteRepository siterepo;
	MQTTSubscriber sub;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/createsite")
	public @ResponseBody CreateSiteModal crateSite(@RequestBody CreateSiteModal createSite,@RequestParam("custId") long custid) throws Exception
	{
		System.out.println("Method called"+createSite.toString());
		CreateSiteModal site= dashboardService.createsite(createSite,custid);
		
		long id = site.getSiteid();
		 System.out.println("The id is "+ id);
		
		return site;
		
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allsites")
	public @ResponseBody List<CreateSiteModal> getAllSites(@RequestParam("custId") long custId)
	{	
	List<CreateSiteModal> list=dashboardService.findAllSitesOfCustomer(custId);
		
		return list;
		
	}
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search")
	public  List<CreateSiteModal> searchSite(@RequestParam("keyword") String keyword)
	{
		List<CreateSiteModal> listProducts = dashboardService.searchSite(keyword);
		return listProducts;
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getsite")
	public @ResponseBody CreateSiteModal getSite(@RequestParam("sitename") String siteName)
	{	
		CreateSiteModal list=dashboardService.findSites(siteName);
		
		return list;
		
	}
	// update the site
	//@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateSite")
	public ResponseEntity<CreateSiteModal> updatesite(@RequestBody CreateSiteModal modal,@RequestParam("sitename") String siteName)
	{
		CreateSiteModal userupdate = dashboardService.updateSite(modal,siteName);
		
		if(userupdate!=null)
		{
			return new ResponseEntity<CreateSiteModal>(HttpStatus.OK);
		}
		return new ResponseEntity<CreateSiteModal>(HttpStatus.BAD_REQUEST);
	}
	
	//To delete site
	//@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletesite")
	public String deleteSite(@RequestParam("sitename") String siteName) throws Exception
	{
		System.out.println("username "+siteName);
		int result = dashboardService.deleteSite(siteName);
		if(result!=0)
		{
			return "user deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/mqtt/send", method = RequestMethod.POST)
	public String index(@RequestBody CreateSiteModal data) 
	{
		String mqttDate = data.getSiteid()+"_"+data.getSiteName()+"_"+data.getDeviceId();
		System.out.println("cmg");
		
		int res=sub.online;
		try {
			InetAddress address = InetAddress.getByName(this.clientIp);
			boolean reachable = address.isReachable(1000);
			System.out.println("the result is "+reachable);
			if (res==1) {
				publisher.publishMessage("siteid", mqttDate);
				subscriber.subscribeMessage("siteid");
				
				return "Site Infromation Shared Successfully";
				
				//subscriber.subscribeMessage("doorgroupid");
			} else {
				return "Device is Offline";
//				Calendar cal = Calendar.getInstance();
//				System.out.println("The time is    " + cal.getTime());
//				Date date = new Date();
//				SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
//				String stringDate = DateFor.format(date);
//				BackTasksModal modal = new BackTasksModal();
//				modal.setDateAndTime(stringDate);
//				modal.setPriority(1);
//				modal.setTaskDescription("Site pending with id " +data.getSiteid());
//				modal.setTaskNo("Site ID" + data.getSiteid());
//				modal.setTaskStatus("pending");
//				modal.setDeviceid(Long.parseLong(data.getDeviceId()));
//				// String time =java.time.LocalTime.now().toString();
//				// System.out.println(java.time.LocalTime.now());
//				String time = String.valueOf(date.getHours() + ":" + date.getMinutes());
//				modal.setTaskTime(time);
//				backTasksRepository.save(modal);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Message sent to Broker";
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
