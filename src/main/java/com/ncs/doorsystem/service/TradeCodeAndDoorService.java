package com.ncs.doorsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.ExecutionError;
import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.repository.ScheduleMainRepository;
import com.ncs.doorsystem.repository.SchedulesRepository;
import com.ncs.doorsystem.repository.TradeCodeAndDoorRepository;

@Service
@Transactional
public class TradeCodeAndDoorService {
	@Autowired
	TradeCodeAndDoorRepository tradeRepo;

	@Autowired
	ScheduleMainRepository scheduleRepo;

	public TradeCodesAndDoorModal createTradeCodeAndDooe(TradeCodesAndDoorModal tradeModal, long custid, long siteid,
			long tradeid) throws Exception {
		ScheduleMainModal schmain = scheduleRepo.findbyscheduleIdForCustAndsite(tradeModal.getScheduleno(),custid,siteid);
		if (schmain != null) {
			TradeCodesAndDoorModal modalTradeExisting = tradeRepo.findbytradeNoAndCustomerAndSite(tradeid,custid,siteid);
			if (modalTradeExisting != null) {

				modalTradeExisting.setCreatedDate(tradeModal.getCreatedDate());
				modalTradeExisting.setCustomerid(custid);
				modalTradeExisting.setSiteid(siteid);
				modalTradeExisting.setTradecode(tradeModal.getTradecode());
				modalTradeExisting.setScheduleno(tradeModal.getScheduleno());
				modalTradeExisting.setTradeNo(tradeid);
				TradeCodesAndDoorModal modal = tradeRepo.save(modalTradeExisting);
				return modal;

			} else {
//				TradeCodesAndDoorModal modalTradeSchedule = tradeRepo.findByscheduleno(tradeModal.getScheduleno());
//				if (modalTradeSchedule != null) {
//					throw new Exception("The Schedule with trade code is already created");
//				} else {
					tradeModal.setCustomerid(custid);
					tradeModal.setSiteid(siteid);
					tradeModal.setTradeNo(tradeid);
					TradeCodesAndDoorModal modal = tradeRepo.save(tradeModal);
					return modal;

				//}

			}

		} else {
			 throw new Exception("Schedule is not created");

		}

	}

	public List<TradeCodesAndDoorModal> findAllTrades(long custId, long siteid) {
		List<TradeCodesAndDoorModal> tradeResult = tradeRepo.findbycustomerid(custId,siteid);
		return tradeResult;
	}

	public ResponseEntity<Object> updateTrade(TradeCodesAndDoorModal trade, long tradeid) {

		TradeCodesAndDoorModal upadteTradevalues = tradeRepo.findBytradid(tradeid);
		if (upadteTradevalues != null) {
			ScheduleMainModal schmain = scheduleRepo.findByscheduleId(trade.getScheduleno());
			if (schmain != null) {
				// TradeCodesAndDoorModal upadteTradevalues = new TradeCodesAndDoorModal();
				upadteTradevalues.setTradecode(trade.getTradecode());
				upadteTradevalues.setCreatedDate(trade.getCreatedDate());
				// upadteTradevalues.setLocktime(trade.getLocktime());

				upadteTradevalues.setScheduleno(trade.getScheduleno());
				// upadteTradevalues.setDoorNumber(trade.getDoorNumber());
				TradeCodesAndDoorModal update = tradeRepo.save(upadteTradevalues);
				if (tradeRepo.findById(update.getTradid()).isPresent())
					return ResponseEntity.accepted().body("Trade updated successfully");
				else
					return ResponseEntity.unprocessableEntity().body("Failed updating the Trade specified");
			} else
				return ResponseEntity.unprocessableEntity().body("Cannot find the schedule specified");
		}
		return ResponseEntity.unprocessableEntity().body("Cannot find the Trade specified");
	}

	public ResponseEntity<Object> deleteTrade(long tradeid) {
		if (tradeRepo.findById(tradeid).isPresent()) {
			tradeRepo.deleteById(tradeid);
		}
		if (tradeRepo.findById(tradeid).isPresent())
			return ResponseEntity.unprocessableEntity().body("Failed to delete the Trade");
		else
			return ResponseEntity.ok("Trade deleted successfully");
	}

}
