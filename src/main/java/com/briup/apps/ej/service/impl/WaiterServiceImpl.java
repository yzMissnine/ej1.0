package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaiterServiceImpl implements IWaiterService{
    @Resource
    public WaiterMapper waiterMapper;
    @Override
    public List<Waiter> findAll(){
        WaiterExample example = new WaiterExample();
        return waiterMapper.selectByExample(example);

    }
    //插入数据
    @Override
    public void saveOrUpdate(Waiter waiter) throws Exception {
        if(waiter.getId()!=null){
            waiterMapper.updateByPrimaryKey(waiter);
        } else {
            waiter.setStatus("正常");
            waiterMapper.insert(waiter);
        }
    }


   @Override
    public void deleteById(long id) throws Exception {
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if(waiter == null){
            throw new Exception("要删除的用户信息不存在");
        }
        waiterMapper.deleteByPrimaryKey(id);
    }

  /* @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            waiterMapper.deleteByPrimaryKey(id);
        }
}*/
}

 /*   public int insert(Waiter record) throws Exception{
        return waiterMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new Exception("删除的人员不存在");

        }
        else {
            return waiterMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(Waiter record) throws Exception{
        return waiterMapper.updateByPrimaryKey(record);
    }
    @Override
    public Waiter findById(Long id){
        return waiterMapper.selectByPrimaryKey(id);
    }


}*/
