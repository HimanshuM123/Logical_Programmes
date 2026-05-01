package com.example.rest.disruptor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OMSService omsService;

    public OrderController(OMSService omsService){ this.omsService = omsService; }

    @PostMapping("/orders")
    public ExecutionReport submitOrder(@RequestBody Order order){
        return omsService.submitOrder(order);
    }
}
