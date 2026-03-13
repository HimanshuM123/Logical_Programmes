//package com.example.rest.disruptor;
//
//
//
//
//class SimulatedExchangeTest {
//
//    private SimulatedExchange exchange;
//    private WebSocketHandlerImpl wsHandler;
//
//    @BeforeEach
//    void setup() {
//        wsHandler = mock(WebSocketHandlerImpl.class);
//        exchange = new SimulatedExchange("SIM", wsHandler);
//    }
//
//    @Test
//    void testFullMatch() throws Exception {
//
//        Order buy = new Order(1L, "C1", "BUY", 
//                new Instrument("AAPL"), 100, 105.0);
//
//        Order sell = new Order(2L, "C2", "SELL", 
//                new Instrument("AAPL"), 100, 100.0);
//
//        exchange.submitOrder(buy);
//        exchange.submitOrder(sell);
//
//        // Wait briefly because matching runs in new thread
//        TimeUnit.MILLISECONDS.sleep(200);
//
//        verify(wsHandler, times(2))
//                .broadcastExecution(any(ExecutionReport.class));
//
//        assertTrue(exchange.buyBook.get("AAPL").isEmpty());
//        assertTrue(exchange.sellBook.get("AAPL").isEmpty());
//    }
//
//    @Test
//    void testPartialMatch() throws Exception {
//
//        Order buy = new Order(1L, "C1", "BUY",
//                new Instrument("AAPL"), 100, 105.0);
//
//        Order sell = new Order(2L, "C2", "SELL",
//                new Instrument("AAPL"), 50, 100.0);
//
//        exchange.submitOrder(buy);
//        exchange.submitOrder(sell);
//
//        TimeUnit.MILLISECONDS.sleep(200);
//
//        verify(wsHandler, times(2))
//                .broadcastExecution(any(ExecutionReport.class));
//
//        // Buy should have 50 remaining
//        Order remainingBuy = exchange.buyBook.get("AAPL").peek();
//        assertEquals(50, remainingBuy.getQty());
//
//        assertTrue(exchange.sellBook.get("AAPL").isEmpty());
//    }
//
//    @Test
//    void testNoMatch() throws Exception {
//
//        Order buy = new Order(1L, "C1", "BUY",
//                new Instrument("AAPL"), 100, 90.0);
//
//        Order sell = new Order(2L, "C2", "SELL",
//                new Instrument("AAPL"), 100, 100.0);
//
//        exchange.submitOrder(buy);
//        exchange.submitOrder(sell);
//
//        TimeUnit.MILLISECONDS.sleep(200);
//
//        verify(wsHandler, never())
//                .broadcastExecution(any());
//
//        assertEquals(1, exchange.buyBook.get("AAPL").size());
//        assertEquals(1, exchange.sellBook.get("AAPL").size());
//    }
//
//    @Test
//    void testMultiLevelMatching() throws Exception {
//
//        Order buy1 = new Order(1L, "C1", "BUY",
//                new Instrument("AAPL"), 50, 105.0);
//
//        Order buy2 = new Order(2L, "C2", "BUY",
//                new Instrument("AAPL"), 50, 100.0);
//
//        Order sell = new Order(3L, "C3", "SELL",
//                new Instrument("AAPL"), 70, 100.0);
//
//        exchange.submitOrder(buy1);
//        exchange.submitOrder(buy2);
//        exchange.submitOrder(sell);
//
//        TimeUnit.MILLISECONDS.sleep(300);
//
//        verify(wsHandler, atLeast(2))
//                .broadcastExecution(any());
//
//        // buy1 fully consumed (50)
//        // sell left 20 → matched with buy2
//        Order remainingBuy = exchange.buyBook.get("AAPL").peek();
//        assertEquals(30, remainingBuy.getQty());
//    }
//}
