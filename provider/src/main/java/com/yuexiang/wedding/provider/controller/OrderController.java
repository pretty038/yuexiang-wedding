package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.Order;
import com.yuexiang.wedding.domain.vo.OrderVO;
import com.yuexiang.wedding.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/addorder")
    public long addOrder(Order order){

        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/getorderlistbyuser")
    public List<OrderVO> getOrderListByUser(int userId){
       return orderService.getOrderByUser(userId);
    };

    @RequestMapping(value = "/updateorderstatus")
    public String updateOrderStatus(@RequestParam(value = "id") long id,@RequestParam(value = "status") int status){
        return orderService.updateOrderStatus(id,status)==true?"update order status success！":"update order status fail!";
    }
}
