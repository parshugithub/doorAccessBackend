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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.TradeCodeWithDoorModal;
import com.ncs.doorsystem.entity.TradeCodesAndDoorModal;
import com.ncs.doorsystem.service.TradeCodeWithDoorservice;

@RestController
@RequestMapping("/tradedoor")
public class TradeCodeWithDoorController 
{
	@Autowired
	TradeCodeWithDoorservice service;
	
	@GetMapping("/getall")
	public List<TradeCodeWithDoorModal> getAll(@RequestParam("custid") long custId,@RequestParam("siteid") long siteid) {
		System.out.println("entered");
		List<TradeCodeWithDoorModal> getAll =service.getAll(custId,siteid);
		if(getAll!=null)
		{
			return getAll;
		}
		return null;


	}
	
	@PostMapping(path = "/create", produces = "application/json")
	public @ResponseBody TradeCodeWithDoorModal createTreadeCodeWithDoor(@RequestBody TradeCodeWithDoorModal tradeModal,@RequestParam("custid") long custid,@RequestParam("siteid") long siteid,@RequestParam("tradedoorid") long tradedoorid) throws Exception
	{
		return service.createTreadeCodeWithDoor(tradeModal,custid,siteid,tradedoorid);
	}
	
	@PutMapping("/update")
    public ResponseEntity<Object> updateTradeWithDoor(@RequestParam("tradeid") long tradeid, @RequestBody TradeCodeWithDoorModal trade) {
        return service.updateTradeWithDoor(trade, tradeid);
    }
	
	 @DeleteMapping("/delete")
	    public ResponseEntity<Object> deleteTradewithDoor(@RequestParam("tradeid") long tradeid) {
	        return service.deleteTradewithDoor(tradeid);
	    }


}
