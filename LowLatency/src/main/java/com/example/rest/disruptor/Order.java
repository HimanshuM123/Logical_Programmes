package com.example.rest.disruptor;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private final String orderId;
    private final String clientOrderId;
    private Instrument instrument;
    private String side; // BUY/SELL
    private int qty;
    private Double price;
    private String ordType; // LMT/MKT
    private long timestamp;
    private String status;

    public Order(String clientOrderId, Instrument instrument, String side, int qty, Double price, String ordType, long timestamp){
        this.orderId = "O-" + counter.getAndIncrement();
        this.clientOrderId = clientOrderId;
        this.instrument = instrument;
        this.side = side;
        this.qty = qty;
        this.price = price;
        this.ordType = ordType;
        this.timestamp = timestamp;
        this.status = "NEW";
    }

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static AtomicInteger getCounter() {
		return counter;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

   
}
