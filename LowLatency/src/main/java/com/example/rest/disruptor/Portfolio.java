package com.example.rest.disruptor;


import java.util.concurrent.atomic.AtomicReference;

public class Portfolio {
    private String clientId;
    private AtomicReference<Double> totalDelta = new AtomicReference<>(0.0);
    private AtomicReference<Double> totalGamma = new AtomicReference<>(0.0);
    private AtomicReference<Double> totalVega  = new AtomicReference<>(0.0);
    private AtomicReference<Double> totalTheta = new AtomicReference<>(0.0);

    // Add Greeks of a new order
    public void addGreeks(double delta, double gamma, double vega, double theta){
        totalDelta.updateAndGet(x -> x + delta);
        totalGamma.updateAndGet(x -> x + gamma);
        totalVega.updateAndGet(x -> x + vega);
        totalTheta.updateAndGet(x -> x + theta);
    }

    // Subtract Greeks if order canceled
    public void subtractGreeks(double delta, double gamma, double vega, double theta){
        totalDelta.updateAndGet(x -> x - delta);
        totalGamma.updateAndGet(x -> x - gamma);
        totalVega.updateAndGet(x -> x - vega);
        totalTheta.updateAndGet(x -> x - theta);
    }

    // Getters
    public double getTotalDelta(){ return totalDelta.get(); }
    public double getTotalGamma(){ return totalGamma.get(); }
    public double getTotalVega(){ return totalVega.get(); }
    public double getTotalTheta(){ return totalTheta.get(); }
}
