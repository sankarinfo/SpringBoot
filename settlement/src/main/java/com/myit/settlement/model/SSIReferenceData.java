package com.myit.settlement.model;

/*
 * This model is used for SSI Reference data
 */
public class SSIReferenceData {
	public String ssiCode;
	public PayerParty payerParty;
	public ReceiverParty receiverParty;
	public String supportingInformation;

	public String getSsiCode() {
		return ssiCode;
	}
	public void setSsiCode(String ssiCode) {
		this.ssiCode = ssiCode;
	}
	public String getSupportingInformation() {
		return supportingInformation;
	}
	public void setSupportingInformation(String supportingInformation) {
		this.supportingInformation = supportingInformation;
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
}