package com.example.rest.disruptor;


import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

public class DisruptorService {
    private final Disruptor<OrderEvent> disruptor;

    public DisruptorService(SmartOrderRouter sor){
    	disruptor = new Disruptor<OrderEvent>(
                (EventFactory<OrderEvent>) new OrderEventFactory(),
                1024,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy()
        );

        disruptor.handleEventsWith((orderEvent, sequence, endOfBatch) -> {
            Order order = orderEvent.getOrder();
            sor.routeOrder(order); // send to SOR
        });

        disruptor.start();
    }

    public void publish(Order order){
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        try{
            OrderEvent event = ringBuffer.get(sequence);
            event.setOrder(order);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

