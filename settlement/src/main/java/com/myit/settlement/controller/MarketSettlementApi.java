package com.myit.settlement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myit.settlement.exception.SettlementException;
import com.myit.settlement.request.TradeRequest;
import com.myit.settlement.response.MarketSettlementMessage;
import com.myit.settlement.service.MarketSettlementService;

/*
 *  This controller has end points which are used to create 
 *  settlement message and retrieve existing settlement messages
 * 
 */
@RestController
public class MarketSettlementApi {
	
	  @Autowired
	  MarketSettlementService marketSettlementService;

	  /*
	   *  This end point, creates settlement message for the trade 
	   *  
	   *  @param TradeRequest Trade Id, ssi code, amount, currency, value date
	   *  @return settlement message
	   */
	  @PostMapping(path="/createNewMarketSettlement", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<MarketSettlementMessage> newMarketSettlement(@RequestBody TradeRequest tr) 
			  			throws SettlementException {
	    
	    MarketSettlementMessage msm = null;
	    
	    try {
	    	msm = marketSettlementService.createNewMarketSettlement(tr);

	    } catch (SettlementException cmse) {
	    	throw new SettlementException(cmse.getErrorCode(),cmse.getErrorDesc());
	    }
		return new ResponseEntity<MarketSettlementMessage>( msm, HttpStatus.OK);		
	  }
	  
	  /*
	   *  This end point, fetch settlement message for the specific trade 
	   *  
	   *  @param tradeId Trade id
	   *  @return settlement message
	   */
	  @GetMapping(path="/fetchMarketSettlement/{tradeId}", produces = "application/json")
	  public ResponseEntity<MarketSettlementMessage> fetchMarketSettlement(@PathVariable long tradeId) 
			  						throws SettlementException {	    

		 Optional<MarketSettlementMessage> msm = null;
		 
		 try {
			 msm = Optional.ofNullable(marketSettlementService.fetchSettlementDetails(tradeId));
		 } catch (SettlementException e) {
		    throw new SettlementException(e.getErrorCode(),e.getErrorDesc());
		 }
		 
		 return new ResponseEntity<MarketSettlementMessage>( msm.get(), HttpStatus.OK);  		
	  }
}