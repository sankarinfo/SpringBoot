package com.myit.settlement.exception;

public class SettlementException extends Exception {
	
    private static final long serialVersionUID = 1L;

    public String errorCode;
    public String errorDesc;
    
    public SettlementException(String errorCode, String errorDesc) {
		this.errorCode = errorCode; 
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
