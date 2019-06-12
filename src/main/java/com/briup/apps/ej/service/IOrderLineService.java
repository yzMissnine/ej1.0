package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> findAll();
    int insert(OrderLine record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(OrderLine record) throws Exception;
    OrderLine findById(Long id);
}
