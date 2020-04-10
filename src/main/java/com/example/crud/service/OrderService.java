package com.example.crud.service;

import com.example.crud.enums.Type;
import com.example.crud.exception.OutOfStockException;
import com.example.crud.model.*;
import com.example.crud.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class OrderService {

    private Logger log =LoggerFactory.getLogger(OrderService .class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private OrderRepository orderRepository;

    public Status executeOrder(OrderInput orderInput) {

        OrderDetail orderDetail = new OrderDetail();
        Order order = new Order();

        try {
            Date date = new Date();
            Item requestedItem = orderInput.getItemOrdered().getItem();

            Customer customer = customerService.getCustomerById(orderInput.getCustomer().getId());

            order.setCustomer(customer);
            order.setDate(new Timestamp(date.getTime()));

            orderDetail.setType(Type.SINGLE.toString());
            orderDetail.setOrder(order);
            orderDetail.setQuantity(orderInput.getItemOrdered().getQuantity());
            orderDetail.setPrice(requestedItem.getUnitPrice() * orderInput.getItemOrdered().getQuantity());

            boolean canBeServed = isRequiredQuantityIsInStock(orderInput.getItemOrdered().getItem(), orderInput.getItemOrdered().getQuantity());
            if (canBeServed) {
                itemService.buyItem(orderInput.getItemOrdered().getItem().getId(), orderInput.getItemOrdered().getQuantity());
                order.setStatus(Status.SUCCESS.toString());
                return Status.SUCCESS;
            }
        } catch (OutOfStockException e) {
            log.error("Error seerving order. Stacktrace: {}" ,e.getStackTrace());
            order.setStatus(Status.NOT_SERVED_DUE_TO_OUT_OF_STOCK.toString());
            return Status.NOT_SERVED_DUE_TO_OUT_OF_STOCK;
        } catch (Exception e) {
            log.error("Error seerving order. Stacktrace: {}" ,e.getStackTrace());
            order.setStatus(Status.FAILURE.toString());
            return Status.FAILURE;
        } finally {
            log.info("Saving order details to table");
            orderRepository.save(order);
            orderDetailsService.saveOrderDetail(orderDetail);
        }

        order.setStatus(Status.NOT_SERVED.toString());

        log.info("Saving order details to table");
        orderRepository.save(order);
        orderDetailsService.saveOrderDetail(orderDetail);

        return Status.NOT_SERVED;
    }


    public boolean isRequiredQuantityIsInStock(Item item, int quantity) throws OutOfStockException {
        return itemService.canQuantityBeServed(item.getId(), quantity);
    }

    /*public Status executeOrders(List<OrderInput> orderInputs) {

        OrderDetail orderDetail = new OrderDetail();
        Order order = new Order();

        //check if all requested items can be served
        for(OrderInput orderInput: orderInputs){
            try {
                if(!isRequiredQuantityIsInStock(orderInput.getItem(),orderInput.getQuantity())){
                    return Status.NOT_SERVED_DUE_TO_OUT_OF_STOCK;
                }
            } catch (OutOfStockException e) {
                return Status.NOT_SERVED_DUE_TO_OUT_OF_STOCK;
            }catch (Exception e){
                return Status.FAILURE;
            }finally {

            }
            return Status.NOT_SERVED;
        }


    }
*/
    public enum Status {
        SUCCESS,
        FAILURE,
        NOT_SERVED,
        NOT_SERVED_DUE_TO_OUT_OF_STOCK
    }
}
