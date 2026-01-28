package com.example.rest.disruptor;

import java.io.IOException;

import net.openhft.chronicle.map.ChronicleMap;

public class CacheService {
    private final ChronicleMap<String, Order> orderCache;

    public CacheService()  {
        this.orderCache = ChronicleMap
            .of(String.class, Order.class)
            .name("order-cache")
            .entries(1_000_000)
            .averageValueSize(200)
            .create();
    }

    public void put(Order order){
        orderCache.put(order.getOrderId(), order);
    }

    public Order get(String orderId){
        return orderCache.get(orderId);
    }
}
