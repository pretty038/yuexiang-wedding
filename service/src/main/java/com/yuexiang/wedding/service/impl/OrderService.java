package com.yuexiang.wedding.service.impl;

import com.google.common.collect.Lists;
import com.yuexiang.wedding.dao.OrderDAO;
import com.yuexiang.wedding.domain.model.Order;
import com.yuexiang.wedding.domain.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    public long addOrder(Order order){
        System.out.println(order);
         if(orderDAO.addOrder(order)){
             return order.getId();
         }else {
             return -1;
         }
    }

    public List<OrderVO> getOrderByUser(int userId){
        List<Order> orderlist=orderDAO.getOrderListByUser(userId);
        List<OrderVO> orderVOList= Lists.newArrayList();
        orderVOList=orderlist.stream().map(order -> new OrderVO(order)).collect(Collectors.toList());

        return orderVOList;
    }

    public boolean updateOrderStatus(long id,int status){
        return orderDAO.updateOrderStatus(id,status);
    };

}
