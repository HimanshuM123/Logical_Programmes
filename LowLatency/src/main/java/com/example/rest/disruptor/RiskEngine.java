package com.example.rest.disruptor;



import java.io.IOException;

public class RiskEngine {
    private final RiskLimits limits;
    private final PortfolioCache portfolioCache;

    public RiskEngine() throws IOException {
        this.limits = new RiskLimits();
        limits.setMaxOrderQty(1000);
        limits.setMaxPositionQty(5000);
        limits.setMaxNotional(1_000_000);
        limits.setMaxDelta(1000);
        limits.setMaxVega(500);
        limits.setMaxGamma(200);
        limits.setMaxTheta(100);

        portfolioCache = new PortfolioCache();
    }

    public boolean validate(Order order){
        // Basic checks
        if(order.getQty() <= 0 || order.getQty() > limits.getMaxOrderQty()) return false;
        if(order.getPrice() <= 0) return false;

        Portfolio portfolio = portfolioCache.get(order.getClientOrderId());
        if(portfolio == null) portfolio = new Portfolio();

        // Update Greeks if OPTION
        if("OPTION".equalsIgnoreCase(order.getInstrument().getType())){
            double S = order.getPrice();
            double K = order.getInstrument().getStrike();
            double r = 0.05;
            double sigma = 0.25;
            double T = 30.0/365;
            String type = order.getInstrument().getCallPut();

            double delta = OptionGreeks.delta(type,S,K,r,sigma,T) * order.getQty();
            double gamma = OptionGreeks.gamma(S,K,r,sigma,T) * order.getQty();
            double vega  = OptionGreeks.vega(S,K,r,sigma,T) * order.getQty();
            double theta = OptionGreeks.theta(type,S,K,r,sigma,T) * order.getQty();

            // Portfolio-level limits
            if(portfolio.getTotalDelta() + delta > limits.getMaxDelta()) return false;
            if(portfolio.getTotalGamma() + gamma > limits.getMaxGamma()) return false;
            if(portfolio.getTotalVega()  + vega  > limits.getMaxVega()) return false;
            if(portfolio.getTotalTheta() + theta > limits.getMaxTheta()) return false;

            portfolio.addGreeks(delta,gamma,vega,theta);
        }

        portfolioCache.put(order.getClientOrderId(), portfolio);
        return true;
    }
}
