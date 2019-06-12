package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLineExample;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.service.IOrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderLineServiceImpI implements IOrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Override
    public List<OrderLine> findAll(){
        OrderLineExample example = new OrderLineExample();
        return orderLineMapper.selectByExample(example);

    }
    //插入数据
    @Override
    public int insert(OrderLine record) throws Exception{
        return orderLineMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new Exception("删除的商品不存在");

        }
        else {
            return orderLineMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(OrderLine record) throws Exception{
        return orderLineMapper.updateByPrimaryKey(record);
    }
    @Override
    public OrderLine findById(Long id){
        return orderLineMapper.selectByPrimaryKey(id);
    }

}
