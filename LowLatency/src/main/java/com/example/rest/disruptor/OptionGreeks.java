package com.example.rest.disruptor;


import org.apache.commons.math3.distribution.NormalDistribution;

public class OptionGreeks {

    private static final NormalDistribution N = new NormalDistribution();

    public static double d1(double S, double K, double r, double sigma, double T){
        return (Math.log(S/K) + (r + 0.5*sigma*sigma)*T) / (sigma * Math.sqrt(T));
    }

    public static double d2(double S, double K, double r, double sigma, double T){
        return d1(S,K,r,sigma,T) - sigma * Math.sqrt(T);
    }

    // Delta
    public static double delta(String type, double S, double K, double r, double sigma, double T){
        double d1 = d1(S,K,r,sigma,T);
        return "CALL".equalsIgnoreCase(type) ? N.cumulativeProbability(d1) : N.cumulativeProbability(d1) - 1;
    }

    // Gamma
    public static double gamma(double S, double K, double r, double sigma, double T){
        double d1 = d1(S,K,r,sigma,T);
        return N.density(d1) / (S * sigma * Math.sqrt(T));
    }

    // Vega
    public static double vega(double S, double K, double r, double sigma, double T){
        double d1 = d1(S,K,r,sigma,T);
        return S * N.density(d1) * Math.sqrt(T);
    }

    // Theta
    public static double theta(String type, double S, double K, double r, double sigma, double T){
        double d1 = d1(S,K,r,sigma,T);
        double d2 = d2(S,K,r,sigma,T);
        if("CALL".equalsIgnoreCase(type)){
            return -(S * N.density(d1) * sigma / (2 * Math.sqrt(T))) - r * K * Math.exp(-r*T) * N.cumulativeProbability(d2);
        } else {
            return -(S * N.density(d1) * sigma / (2 * Math.sqrt(T))) + r * K * Math.exp(-r*T) * N.cumulativeProbability(-d2);
        }
    }
}
