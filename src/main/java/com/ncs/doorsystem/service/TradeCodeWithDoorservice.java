package com.ncs.doorsystem.service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.config.MQTTConfig;
import com.ncs.doorsystem.entity.BackTasksModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.TradeCodeWithDoorModal;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.repository.BackTasksRepository;
import com.ncs.doorsystem.repository.DashBoardRepository;
import com.ncs.doorsystem.repository.MQTTPublisherBase;
import com.ncs.doorsystem.repository.ScheduleMainRepository;
import com.ncs.doorsystem.repository.TradeCodeWithDoorRepository;

@Service
@Transactional
public class TradeCodeWithDoorservice extends MQTTConfig {
	@Autowired
	TradeCodeWithDoorRepository repo;
	@Autowired
	ScheduleMainRepository scheduleRepo;

	@Autowired
	MQTTPublisherBase publisher;
	
	@Autowired
	DashBoardRepository dashRepo;

	@Autowired
	MQTTSubscriber subscriber;
	@Autowired
	BackTasksRepository backTaskRepo;

	public List<TradeCodeWithDoorModal> getAll(long custId, long siteid) {
		List<TradeCodeWithDoorModal> tradeResult = repo.findbycustomerid(custId,siteid);
		return tradeResult;
	}

	public TradeCodeWithDoorModal createTreadeCodeWithDoor(TradeCodeWithDoorModal tradeModal, long custid, long siteid,
			long tradedoorid) throws Exception {
		ScheduleMainModal schmain = scheduleRepo.findbyscheduleIdForCustAndsite(tradeModal.getScheduleno(),custid,siteid);
		if (schmain != null) {
			TradeCodeWithDoorModal modalTrade = repo.finddoorNumberForClient(tradeModal.getDoorNumber(),custid);
			
			if (modalTrade != null) {
				modalTrade.setCreatedDate(tradeModal.getCreatedDate());
				modalTrade.setCustomerid(custid);
				modalTrade.setSiteid(siteid);
				modalTrade.setDoorNumber(tradeModal.getDoorNumber());
				modalTrade.setLockTime(tradeModal.getLockTime());
				modalTrade.setScheduleno(tradeModal.getScheduleno());

				TradeCodeWithDoorModal modal = repo.save(modalTrade);

			//	String res = repo.getDoorTrade(modal.getScheduleno());
				// publisher.publishMessage("door", res);
			//	System.out.println("The result is " + res.toString());

				InetAddress address = InetAddress.getByName(this.clientIp);
				boolean reachable = address.isReachable(1000);
				CreateSiteModal site = dashRepo.findSiteBySiteidAndCustomerid(custid,siteid);
//				if (reachable) {
//					publisher.publishMessage("door", res);
//					subscriber.subscribeMessage("door");
//				} else {
					Calendar cal = Calendar.getInstance();
					System.out.println("The time is    " + cal.getTime());
					Date date = new Date();
					SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
					String stringDate = DateFor.format(date);
					BackTasksModal backmodal = new BackTasksModal();
					backmodal.setDateAndTime(stringDate);
					backmodal.setPriority(1);
					backmodal.setTaskDescription("TradeCode creation  pending with id " + modal.getTdid());
					backmodal.setTaskNo("TradeCode ID" + modal.getDoorNumber());
					backmodal.setTaskStatus("pending");
					backmodal.setDeviceid(Long.parseLong(site.getDeviceId()));
					// String time =java.time.LocalTime.now().toString();
					// System.out.println(java.time.LocalTime.now());
					String time = String.valueOf(date.getHours() + ":" + date.getMinutes());
					backmodal.setTaskTime(time);
					backTaskRepo.save(backmodal);
					return modal;
				//}
			} else {

//				TradeCodeWithDoorModal modalTradeSchedule = repo.findByscheduleno(tradeModal.getScheduleno());
//				//System.out.println("the results is "+ modalTradeSchedule.toString());
//				if (modalTradeSchedule != null) {
//					throw new Exception("The Door With Schedule is allready created");
//				} else {
					tradeModal.setCustomerid(custid);
					tradeModal.setSiteid(siteid);
					TradeCodeWithDoorModal modal = repo.save(tradeModal);
					//String res = repo.getDoorTrade(modal.getScheduleno());
					InetAddress address = InetAddress.getByName(this.clientIp);
					boolean reachable = address.isReachable(1000);
//					if (reachable) {
//						publisher.publishMessage("door", res);
//						subscriber.subscribeMessage("door");
//					} else {
						Calendar cal = Calendar.getInstance();
						System.out.println("The time is    " + cal.getTime());
						Date date = new Date();
						SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
						String stringDate = DateFor.format(date);
						BackTasksModal backmodal = new BackTasksModal();
						backmodal.setDateAndTime(stringDate);
						backmodal.setPriority(1);
						backmodal.setTaskDescription("TradeCode creation  pending with id " + modal.getTdid());
						backmodal.setTaskNo("TradeCode ID" + modal.getDoorNumber());
						backmodal.setTaskStatus("pending");
						// String time =java.time.LocalTime.now().toString();
						// System.out.println(java.time.LocalTime.now());
						String time = String.valueOf(date.getHours() + ":" + date.getMinutes());
						backmodal.setTaskTime(time);
						backTaskRepo.save(backmodal);
						return modal;

					//}
			//	}

			}
		}

		else {
			throw new Exception("The Schedule is not created present");

		}
	}

	public ResponseEntity<Object> updateTradeWithDoor(TradeCodeWithDoorModal trade, long tradeid) {
		TradeCodeWithDoorModal upadteTradevalues = repo.findBytdid(tradeid);
		if (upadteTradevalues != null) {
			ScheduleMainModal schmain = scheduleRepo.findByscheduleId(trade.getScheduleno());
			if (schmain != null) {
				// TradeCodesAndDoorModal upadteTradevalues = new TradeCodesAndDoorModal();
				upadteTradevalues.setCreatedDate(trade.getCreatedDate());
				upadteTradevalues.setDoorNumber(trade.getDoorNumber());
				upadteTradevalues.setLockTime(trade.getLockTime());

				upadteTradevalues.setScheduleno(trade.getScheduleno());
				// upadteTradevalues.setDoorNumber(trade.getDoorNumber());
				TradeCodeWithDoorModal update = repo.save(upadteTradevalues);
				if (repo.findById(update.getTdid()).isPresent())
					return ResponseEntity.accepted().body("Door updated successfully");
				else
					return ResponseEntity.unprocessableEntity().body("Failed updating the Door specified");
			} else
				return ResponseEntity.unprocessableEntity().body("Cannot find the schedule specified");
		}
		return ResponseEntity.unprocessableEntity().body("Cannot find the Door specified");
	}

	public ResponseEntity<Object> deleteTradewithDoor(long tradeid) {
		if (repo.findById(tradeid).isPresent()) {
			repo.deleteById(tradeid);
		}
		if (repo.findById(tradeid).isPresent())
			return ResponseEntity.unprocessableEntity().body("Failed to delete the Trade");
		else
			return ResponseEntity.ok("Trade deleted successfully");
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
