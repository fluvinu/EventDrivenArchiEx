package com.kafkaEx.order.controller;

import com.kafkaEx.domain.dto.Order;
import com.kafkaEx.domain.dto.OrderEvent;
import com.kafkaEx.order.kafka.OrderProduser;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/local/api")
public class OrderController {

    private OrderProduser orderProduser;

    public OrderController(OrderProduser order) {
        this.orderProduser = order;
    }
    @PostMapping
    public String placehilder(@RequestBody Order ord ){
        ord.setOrderId(UUID.randomUUID().toString());
        OrderEvent orEv=new OrderEvent();
        orEv.setStatus("Pending");
        orEv.setMsg("going to in penfing");
        orEv.setOrder(ord);

        orderProduser.sendMessage(orEv);
        return "order has been placed";
    }
    @GetMapping
    public String test(){
        return "all is runung ";
    }
}
