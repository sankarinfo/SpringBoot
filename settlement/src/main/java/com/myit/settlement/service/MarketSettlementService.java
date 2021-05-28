package com.myit.settlement.service;

import com.myit.settlement.exception.SettlementException;
import com.myit.settlement.request.TradeRequest;
import com.myit.settlement.response.MarketSettlementMessage;

public interface MarketSettlementService {

	/* Creates new market settlement message for the requested trade 
	 * after successful 
	 * 
	 * param TradeRequest Trade information 
	 * 
	 */
	public MarketSettlementMessage createNewMarketSettlement(TradeRequest tr) throws SettlementException;	
	
	public MarketSettlementMessage fetchSettlementDetails(long tradeId) throws SettlementException;	

}
