package com.example.rest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.example.rest.disruptor.Instrument;
import com.example.rest.disruptor.Order;
import com.example.rest.disruptor.SimulatedExchange;
import com.example.rest.disruptor.WebSocketHandlerImpl;
import com.example.rest.disruptor.ExecutionReport;

import java.util.concurrent.PriorityBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SimulatedExchangeTest {

    private SimulatedExchange exchange;
    private WebSocketHandlerImpl wsHandler;

    @BeforeEach
    void setUp() {
        wsHandler = mock(WebSocketHandlerImpl.class);
        exchange = new SimulatedExchange("TestExchange", wsHandler);
    }

//    @Test
//    void testSubmitOrder_AddsToBuyBook() {
//        Order buyOrder = mock(Order.class);
//        when(buyOrder.getSide()).thenReturn("BUY");
//        when(buyOrder.getInstrument()).thenReturn(new Instrument("AAPL"));
//        when(buyOrder.getPrice()).thenReturn(150.0);
//
//        exchange.submitOrder(buyOrder);
//
//        PriorityBlockingQueue<Order> buyQueue = exchange.buyBook.get("AAPL");
//        assertNotNull(buyQueue);
//        assertEquals(1, buyQueue.size());
//        assertEquals(buyOrder, buyQueue.peek());
//    }
//
//    @Test
//    void testSubmitOrder_AddsToSellBook() {
//        Order sellOrder = mock(Order.class);
//        when(sellOrder.getSide()).thenReturn("SELL");
//        when(sellOrder.getInstrument()).thenReturn(new Instrument("AAPL"));
//        when(sellOrder.getPrice()).thenReturn(155.0);
//
//        exchange.submitOrder(sellOrder);
//
//        PriorityBlockingQueue<Order> sellQueue = exchange.sellBook.get("AAPL");
//        assertNotNull(sellQueue);
//        assertEquals(1, sellQueue.size());
//        assertEquals(sellOrder, sellQueue.peek());
//    }
//
    @Test
    void testMatchOrders_ExecutesTrades() throws InterruptedException {
        Order buyOrder = mock(Order.class);
        Order sellOrder = mock(Order.class);
        Order buyOrder1 = new  Order("C1" , new Instrument("AAPL"),"BUY", 10, 150.0, "", 1L);
        Order sellOrder1 = new  Order("C2" , new Instrument("AAPL"),"SELL", 10, 150.0, "", 1L);

        when(buyOrder.getSide()).thenReturn("BUY");
        when(buyOrder.getInstrument()).thenReturn(new Instrument("AAPL"));
        when(buyOrder.getPrice()).thenReturn(150.0);
        when(buyOrder.getQty()).thenReturn(10);
        when(buyOrder.getOrderId()).thenReturn("B1");
        when(buyOrder.getClientOrderId()).thenReturn("C1");

        when(sellOrder.getSide()).thenReturn("SELL");
        when(sellOrder.getInstrument()).thenReturn(new Instrument("AAPL"));
        when(sellOrder.getPrice()).thenReturn(150.0);
        when(sellOrder.getQty()).thenReturn(10);
        when(sellOrder.getOrderId()).thenReturn("S1");
        when(sellOrder.getClientOrderId()).thenReturn("C2");

//        exchange.submitOrder(buyOrder);
        exchange.submitOrder(buyOrder1);
     //   exchange.submitOrder(sellOrder);
        exchange.submitOrder(sellOrder1);

        // Allow time for the matching thread to execute
        Thread.sleep(100);

        ArgumentCaptor<ExecutionReport> captor = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(wsHandler, times(2)).broadcastExecution(captor.capture());

        ExecutionReport buyExec = captor.getAllValues().get(0);
        ExecutionReport sellExec = captor.getAllValues().get(1);

        assertEquals("FILLED", buyExec.getStatus());
        assertEquals("FILLED", sellExec.getStatus());
        assertEquals(10, buyExec.getFilledQty());
        assertEquals(10, sellExec.getFilledQty());
        assertEquals(150.0, buyExec.getFillPrice());
        assertEquals(150.0, sellExec.getFillPrice());
    }
}
