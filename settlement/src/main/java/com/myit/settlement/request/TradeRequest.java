package com.myit.settlement.request;

import java.math.BigDecimal;

public class TradeRequest {

	public int tradeId;
	public String  ssiCode;
	public BigDecimal amount; 
	public String currency;
	public int valueDate;
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getSsiCode() {
		return ssiCode;
	}
	public void setSsiCode(String ssiCode) {
		this.ssiCode = ssiCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getValueDate() {
		return valueDate;
	}
	public void setValueDate(int valueDate) {
		this.valueDate = valueDate;
	}
	
}