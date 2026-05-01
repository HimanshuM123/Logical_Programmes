package com.example.rest.disruptor;


public class RiskLimits {
    private int maxOrderQty;
    private int maxPositionQty;
    private double maxNotional;   // USD value
    private double maxDelta;      // Options portfolio delta
    private double maxVega;       // Options vega
    private double maxGamma;      // Options gamma
    private double maxTheta;      // Options theta
	public int getMaxOrderQty() {
		return maxOrderQty;
	}
	public void setMaxOrderQty(int maxOrderQty) {
		this.maxOrderQty = maxOrderQty;
	}
	public int getMaxPositionQty() {
		return maxPositionQty;
	}
	public void setMaxPositionQty(int maxPositionQty) {
		this.maxPositionQty = maxPositionQty;
	}
	public double getMaxNotional() {
		return maxNotional;
	}
	public void setMaxNotional(double maxNotional) {
		this.maxNotional = maxNotional;
	}
	public double getMaxDelta() {
		return maxDelta;
	}
	public void setMaxDelta(double maxDelta) {
		this.maxDelta = maxDelta;
	}
	public double getMaxVega() {
		return maxVega;
	}
	public void setMaxVega(double maxVega) {
		this.maxVega = maxVega;
	}
	public double getMaxGamma() {
		return maxGamma;
	}
	public void setMaxGamma(double maxGamma) {
		this.maxGamma = maxGamma;
	}
	public double getMaxTheta() {
		return maxTheta;
	}
	public void setMaxTheta(double maxTheta) {
		this.maxTheta = maxTheta;
	}
	
	public RiskLimits() {
		super();
	}
	public RiskLimits(int maxOrderQty, int maxPositionQty, double maxNotional, double maxDelta, double maxVega,
			double maxGamma, double maxTheta) {
		super();
		this.maxOrderQty = maxOrderQty;
		this.maxPositionQty = maxPositionQty;
		this.maxNotional = maxNotional;
		this.maxDelta = maxDelta;
		this.maxVega = maxVega;
		this.maxGamma = maxGamma;
		this.maxTheta = maxTheta;
	}

    
}
