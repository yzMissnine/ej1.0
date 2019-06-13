package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Customer customer) throws Exception {
        if(customer.getId()!=null){
            customerMapper.updateByPrimaryKey(customer);
        } else {
            customer.setStatus("正常");
            customerMapper.insert(customer);
        }
    }


    @Override
    public void deleteById(long id) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            throw new Exception("要删除的用户信息不存在");
        }
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            customerMapper.deleteByPrimaryKey(id);
        }
    }
}







/*package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }
    //插入数据
    @Override
    public int insert(Customer record) throws Exception{
        return customerMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if (customer == null){
            throw new Exception("删除的客户不存在");

        }
        else {
            return customerMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(Customer record) throws Exception{
        return customerMapper.updateByPrimaryKey(record);
    }
    @Override
    public Customer findById(Long id){
        return customerMapper.selectByPrimaryKey(id);
    }
}
*/