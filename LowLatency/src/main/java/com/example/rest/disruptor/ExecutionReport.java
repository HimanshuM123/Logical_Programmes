package com.example.rest.disruptor;

public class ExecutionReport {
	private String orderId;
    private String clientId;
    private String status; // NEW / FILLED / REJECTED
    private int filledQty;
    private double fillPrice;
    private long timestamp;
	public ExecutionReport(String orderId, String clientId, String status, int filledQty, double fillPrice,
			long timestamp) {
		super();
		this.orderId = orderId;
		this.clientId = clientId;
		this.status = status;
		this.filledQty = filledQty;
		this.fillPrice = fillPrice;
		this.timestamp = timestamp;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFilledQty() {
		return filledQty;
	}
	public void setFilledQty(int filledQty) {
		this.filledQty = filledQty;
	}
	public double getFillPrice() {
		return fillPrice;
	}
	public void setFillPrice(double fillPrice) {
		this.fillPrice = fillPrice;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
    
    

}
