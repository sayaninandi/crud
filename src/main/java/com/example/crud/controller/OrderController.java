package com.example.crud.controller;

import com.example.crud.enums.Type;
import com.example.crud.model.OrderDetail;
import com.example.crud.model.OrderInput;
import com.example.crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public String singleOrder(@RequestBody OrderInput orderInput) {

        Type type = Enum.valueOf(Type.class,orderInput.getType());

        if(type.equals(Type.SINGLE)){
            OrderService.Status status =  orderService.executeOrder(orderInput);
            return status.toString();
        }

        return OrderService.Status.FAILURE.toString();
    }

}
