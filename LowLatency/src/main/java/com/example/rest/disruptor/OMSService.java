package com.example.rest.disruptor;


import org.springframework.stereotype.Service;

@Service
public class OMSService {
    private final RiskEngine riskEngine;
    private final CacheService cacheService;
    private final PersistenceService persistenceService;
    private final DisruptorService disruptorService;

    public OMSService(RiskEngine riskEngine, CacheService cacheService, PersistenceService persistenceService, DisruptorService disruptorService){
        this.riskEngine = riskEngine;
        this.cacheService = cacheService;
        this.persistenceService = persistenceService;
        this.disruptorService = disruptorService;
    }

    public ExecutionReport submitOrder(Order order){
        if(!riskEngine.validate(order)){
            return new ExecutionReport(order.getOrderId(), order.getClientOrderId(),"REJECTED",0,0.0,System.currentTimeMillis());
        }

        cacheService.put(order);

        // Publish order to Disruptor → SOR → Exchange asynchronously
        disruptorService.publish(order);

        // Async persistence
        new Thread(() -> persistenceService.persistExecution(
                new ExecutionReport(order.getOrderId(), order.getClientOrderId(), "NEW", 0, 0.0, System.currentTimeMillis())
        )).start();

        return new ExecutionReport(order.getOrderId(), order.getClientOrderId(),"NEW",0,0.0,System.currentTimeMillis());
    }
}
