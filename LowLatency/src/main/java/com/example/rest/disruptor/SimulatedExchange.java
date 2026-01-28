


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Comparator;
import java.util.Map;

public class SimulatedExchange {
    private final String name;
    private final WebSocketHandlerImpl wsHandler;
    private final Map<String, PriorityBlockingQueue<Order>> buyBook = new ConcurrentHashMap<>();
    private final Map<String, PriorityBlockingQueue<Order>> sellBook = new ConcurrentHashMap<>();

    public SimulatedExchange(String name, WebSocketHandlerImpl wsHandler){
        this.name = name;
        this.wsHandler = wsHandler;
    }

    public void submitOrder(Order order){
        var book = order.getSide().equalsIgnoreCase("BUY") ? buyBook : sellBook;
        book.computeIfAbsent(order.getInstrument().getSymbol(), k -> 
            new PriorityBlockingQueue<>(11, order.getSide().equalsIgnoreCase("BUY") ?
                Comparator.comparingDouble(Order::getPrice).reversed() :
                Comparator.comparingDouble(Order::getPrice)
            )
        ).add(order);

        new Thread(() -> matchOrders(order.getInstrument().getSymbol())).start();
    }

    private void matchOrders(String symbol){
        var buys = buyBook.getOrDefault(symbol, new PriorityBlockingQueue<>());
        var sells = sellBook.getOrDefault(symbol, new PriorityBlockingQueue<>());

        while(!buys.isEmpty() && !sells.isEmpty()){
            Order buy = buys.peek();
            Order sell = sells.peek();
            if(buy.getPrice() >= sell.getPrice()){
                int qty = Math.min(buy.getQty(), sell.getQty());
                ExecutionReport buyExec = new ExecutionReport(buy.getOrderId(), buy.getClientOrderId(),"FILLED", qty, sell.getPrice(), System.currentTimeMillis());
                ExecutionReport sellExec = new ExecutionReport(sell.getOrderId(), sell.getClientOrderId(),"FILLED", qty, sell.getPrice(), System.currentTimeMillis());
                wsHandler.broadcastExecution(buyExec);
                wsHandler.broadcastExecution(sellExec);

                if(buy.getQty() <= qty) buys.poll(); else buy.setQty(buy.getQty()-qty);
                if(sell.getQty() <= qty) sells.poll(); else sell.setQty(sell.getQty()-qty);
            } else break;
        }
    }
}
