package com.myit.settlement.response;

import java.math.BigDecimal;

import com.myit.settlement.model.PayerParty;
import com.myit.settlement.model.ReceiverParty;

public class MarketSettlementMessage {

	public long tradeId;
	public String messageId;
	public BigDecimal amount;
	public int valueDate;
	public String currency;
	public PayerParty payerParty;
	public ReceiverParty receiverParty;
	public String supportingInformation;

	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getValueDate() {
		return valueDate;
	}
	public void setValueDate(int valueDate) {
		this.valueDate = valueDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public PayerParty getPayerParty() {
		return payerParty;
	}
	public void setPayerParty(PayerParty payerParty) {
		this.payerParty = payerParty;
	}
	public ReceiverParty getReceiverParty() {
		return receiverParty;
	}
	public void setReceiverParty(ReceiverParty receiverParty) {
		this.receiverParty = receiverParty;
	}
	public String getSupportingInformation() {
		return supportingInformation;
	}
	public void setSupportingInformation(String supportingInformation) {
		this.supportingInformation = supportingInformation;
	}
}