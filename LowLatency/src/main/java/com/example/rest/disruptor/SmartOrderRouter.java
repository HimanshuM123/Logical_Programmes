package com.example.rest.disruptor;


import java.util.concurrent.Executor;

import org.springframework.stereotype.Service;

@Service
public class SmartOrderRouter {
    private final SimulatedExchange nasdaq;
    private final SimulatedExchange cboe;

    public SmartOrderRouter(WebSocketHandlerImpl wsHandler){
        this.nasdaq = new SimulatedExchange("NASDAQ", wsHandler);
        this.cboe = new SimulatedExchange("CBOE", wsHandler);
    }

    public void routeOrder(Order order){
        if("OPTION".equalsIgnoreCase(order.getInstrument().getType()))
            cboe.submitOrder(order);
        else
            nasdaq.submitOrder(order);
    }
}
