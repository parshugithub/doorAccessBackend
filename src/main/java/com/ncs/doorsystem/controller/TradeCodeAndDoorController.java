package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.service.TradeCodeAndDoorService;

@RestController
@RequestMapping("/tradecodeanddoor")
public class TradeCodeAndDoorController 
{
	
	@Autowired
	TradeCodeAndDoorService tradeService;
	
	
	@GetMapping("/getTrades")
	public List<TradeCodesAndDoorModal> getAllTrades(@RequestParam("custid") long custId,@RequestParam("siteid") long siteid) {
		System.out.println("entered");
		List<TradeCodesAndDoorModal> getAllTrades =tradeService.findAllTrades(custId,siteid);
		if(getAllTrades!=null)
		{
			return getAllTrades;
		}
		return null;


	}
	
	@PostMapping(path = "/createTrade", produces = "application/json")
	public TradeCodesAndDoorModal createTreadeCodeAndDoor(@RequestBody TradeCodesAndDoorModal tradeModal,@RequestParam("custid") long custid,@RequestParam("siteid") long siteid,@RequestParam("tradeid") long tradeid) throws Exception
	{
		return tradeService.createTradeCodeAndDooe(tradeModal,custid,siteid,tradeid);
	}
	
	@PutMapping("/update")
    public ResponseEntity<Object> updateTrade(@RequestParam("tradeid") long tradeid, @RequestBody TradeCodesAndDoorModal trade) {
        return tradeService.updateTrade(trade, tradeid);
    }
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteTrade(@RequestParam("tradeid") long tradeid) {
	        return tradeService.deleteTrade(tradeid);
	    }

}
