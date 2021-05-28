package com.myit.settlement.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.myit.settlement.exception.SettlementException;
import com.myit.settlement.model.PayerParty;
import com.myit.settlement.model.ReceiverParty;
import com.myit.settlement.model.SSIReferenceData;
import com.myit.settlement.request.TradeRequest;
import com.myit.settlement.response.MarketSettlementMessage;
import com.myit.settlement.service.MarketSettlementService;

/* Service class serves creation of new market settlement message
 * and fetch existing settlement  
 */

@Service
public class MarketSettlementServiceImpl implements MarketSettlementService {

	/* Creates new market settlement message for the requested trade 
	 * after successful 
	 * 
	 * @param tr Trade information 
	 * 
	 */
	public MarketSettlementMessage createNewMarketSettlement(TradeRequest tr) throws SettlementException {
		MarketSettlementMessage msm = new MarketSettlementMessage();

		Optional<SSIReferenceData> ssiRefData = this.getListOfReferenceData().stream().filter(a -> a.getSsiCode().equals(tr.getSsiCode())).findFirst();

		if(!ssiRefData.isPresent()) {
			throw new SettlementException("S0002","Reference data is not found for SSI Code :"+tr.getSsiCode());
		}
		
	    UUID uniqueKey = UUID.randomUUID();

		msm.setTradeId(tr.tradeId);
		msm.setCurrency(tr.getCurrency());
		msm.setMessageId(uniqueKey.toString());
		msm.setAmount(tr.getAmount().setScale(2, RoundingMode.HALF_UP));
		msm.setSupportingInformation(ssiRefData.get().getSupportingInformation());
		msm.setValueDate(tr.getValueDate());
		PayerParty pp = new PayerParty();
		pp.setAccountNumber(ssiRefData.get().getPayerParty().getAccountNumber());
		pp.setBankCode(ssiRefData.get().getPayerParty().getBankCode());
		msm.setPayerParty(pp);
		ReceiverParty rp = new ReceiverParty();
		rp.setAccountNumber(ssiRefData.get().getReceiverParty().getAccountNumber());
		rp.setBankCode(ssiRefData.get().getReceiverParty().getBankCode());
		msm.setReceiverParty(rp);
		
		return msm;
	}
	
	/* Returns market settlement message for the specific trade 
	 * 
	 * @param tradeId  Trade id to get market settlement message
	 * 
	 */
	public MarketSettlementMessage fetchSettlementDetails(long tradeId) throws SettlementException {

		Optional<MarketSettlementMessage> msm = this.getListOfSettlements().stream().filter(a -> a.tradeId==tradeId).findFirst();

		if(!msm.isPresent()) 
			throw new SettlementException("S145000","Settlement not found for the trade : "+tradeId);
			
		return msm.get();				
	}	
	
	/* Returns list of market settlement data for the trade submitted 
	 * Its contains ssi code, payer party, receiver party,
	 * bank details and ssi information
	 */	
	private List<MarketSettlementMessage> getListOfSettlements() {
		
		List<MarketSettlementMessage> ssiData = new ArrayList<MarketSettlementMessage>();
		MarketSettlementMessage msm = new MarketSettlementMessage();
		msm.setTradeId(16800001);
		msm.setCurrency("USD");
		msm.setMessageId("e8a57dc0-2119-49a4-85fe-5e94415b2cad");
		msm.setAmount(new BigDecimal(99989.96).setScale(2, RoundingMode.HALF_UP));
		msm.setSupportingInformation("/BNF/FFC-4697132");
		msm.setValueDate(20022020);
		PayerParty pp = new PayerParty();
		pp.setAccountNumber("438421");
		pp.setBankCode("OCBCSGSGXXX");
		msm.setPayerParty(pp);
		ReceiverParty rp = new ReceiverParty();
		rp.setAccountNumber("05461368");
		rp.setBankCode("DBSSGB2LXXX");
		msm.setReceiverParty(rp);
		
		ssiData.add(msm);
		
		msm = new MarketSettlementMessage();
		msm.setTradeId(16800002);
		msm.setCurrency("USD");
		msm.setMessageId("e8a57dc0-2119-49a4-85fe-5e94415b2cad");
		msm.setAmount(new BigDecimal(99989.96).setScale(2, RoundingMode.HALF_UP));
		msm.setSupportingInformation("/BNF/FFC-4697132");
		msm.setValueDate(20022020);
		pp = new PayerParty();
		pp.setAccountNumber("438421");
		pp.setBankCode("OCBCSGSGXXX");
		msm.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("05461368");
		rp.setBankCode("DBSSGB2LXXX");
		msm.setReceiverParty(rp);
		
		ssiData.add(msm);
		
		msm = new MarketSettlementMessage();
		msm.setTradeId(16800003);
		msm.setCurrency("USD");
		msm.setMessageId("e8a57dc0-2119-49a4-85fe-5e94415b2cad");
		msm.setAmount(new BigDecimal(99989.96).setScale(2, RoundingMode.HALF_UP));
		msm.setSupportingInformation("/BNF/FFC-4697132");
		msm.setValueDate(20022020);
		pp = new PayerParty();
		pp.setAccountNumber("438421");
		pp.setBankCode("OCBCSGSGXXX");
		msm.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("05461368");
		rp.setBankCode("DBSSGB2LXXX");
		msm.setReceiverParty(rp);

		return ssiData;
	}
	
	/* Returns list of SSI reference data static data 
	 * Its contains ssi code, payer party, receiver party,
	 * bank details and ssi information
	 */
	private List<SSIReferenceData> getListOfReferenceData() {
		
		List<SSIReferenceData> ssiRefDataList = new ArrayList<SSIReferenceData>();
		
		SSIReferenceData ssiRefData = new SSIReferenceData();
		ssiRefData.setSsiCode("DBS_OCBC_1");
		PayerParty pp = new PayerParty();
		pp.setAccountNumber("05461368");
		pp.setBankCode("DBSSGB2LXXX");
		ssiRefData.setPayerParty(pp);
		ReceiverParty rp = new ReceiverParty();
		rp.setAccountNumber("438421");
		rp.setBankCode("OCBCSGSGXXX");
		ssiRefData.setReceiverParty(rp);
		ssiRefData.setSupportingInformation("BNF:PAY CLIENT");
		
		ssiRefDataList.add(ssiRefData);
		
		ssiRefData = new SSIReferenceData();
		ssiRefData.setSsiCode("OCBC_DBS_1");
		pp = new PayerParty();
		pp.setAccountNumber("438421");
		pp.setBankCode("OCBCSGSGXXX");
		ssiRefData.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("05461368");
		rp.setBankCode("DBSSGB2LXXX");
		ssiRefData.setReceiverParty(rp);
		ssiRefData.setSupportingInformation("BNF:FFC-4697132");
		
		ssiRefDataList.add(ssiRefData);

		ssiRefData = new SSIReferenceData();
		ssiRefData.setSsiCode("OCBC_DBS_2");
		pp = new PayerParty();
		pp.setAccountNumber("438421");
		pp.setBankCode("OCBCSGSGXXX");
		ssiRefData.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("05461369");
		rp.setBankCode("DBSSSGSGXXX");
		ssiRefData.setReceiverParty(rp);
		ssiRefData.setSupportingInformation("BNF:FFC-482315");
		
		ssiRefDataList.add(ssiRefData);
		
		
		ssiRefData = new SSIReferenceData();
		ssiRefData.setSsiCode("DBS_SCB");
		pp = new PayerParty();
		pp.setAccountNumber("185586");
		pp.setBankCode("DBSSSGSGXXX");
		ssiRefData.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("1868422");
		rp.setBankCode("SCBLAU2SXXX");
		ssiRefData.setReceiverParty(rp);
		ssiRefData.setSupportingInformation("RFB:Test payment");
		
		ssiRefDataList.add(ssiRefData);
		
		
		ssiRefData = new SSIReferenceData();
		ssiRefData.setSsiCode("CITI_GS");
		pp = new PayerParty();
		pp.setAccountNumber("00454983");
		pp.setBankCode("CITIGB2LXXX");
		ssiRefData.setPayerParty(pp);
		rp = new ReceiverParty();
		rp.setAccountNumber("48486414");
		rp.setBankCode("GSCMUS33XXX");
		ssiRefData.setReceiverParty(rp);
		ssiRefData.setSupportingInformation("RFB:Test payment");
		
		ssiRefDataList.add(ssiRefData);
		
		return ssiRefDataList;
	}
}