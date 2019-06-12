package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpI implements IOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public List<Order> findAll(){
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);

    }
    //插入数据
    @Override
    public int insert(Order record) throws Exception{
        return orderMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        Order order = orderMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new Exception("删除的订单不存在");

        }
        else {
            return orderMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(Order record) throws Exception{
        return orderMapper.updateByPrimaryKey(record);
    }
    @Override
    public Order findById(Long id){
        return orderMapper.selectByPrimaryKey(id);
    }

}
