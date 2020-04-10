package com.example.crud.service;

import com.example.crud.model.OrderDetail;
import com.example.crud.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public void saveOrderDetail(OrderDetail orderDetail){
        orderDetailsRepository.save(orderDetail);
    }

    public void saveOrderDetail(List<OrderDetail> orderDetails){
        orderDetailsRepository.saveAll(orderDetails);
    }
}
