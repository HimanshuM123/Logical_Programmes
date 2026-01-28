package com.example.rest.disruptor;


public class Instrument {
    private String type; // EQUITY/OPTION
    private String symbol;
    private String expiry;
    private Double strike;
    private String callPut;
	public Instrument(String type, String symbol, String expiry, Double strike, String callPut) {
		super();
		this.type = type;
		this.symbol = symbol;
		this.expiry = expiry;
		this.strike = strike;
		this.callPut = callPut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Double getStrike() {
		return strike;
	}
	public void setStrike(Double strike) {
		this.strike = strike;
	}
	public String getCallPut() {
		return callPut;
	}
	public void setCallPut(String callPut) {
		this.callPut = callPut;
	}

    
}
