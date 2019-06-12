package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    int insert(Order record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Order record) throws Exception;
    Order findById(Long id);
}
