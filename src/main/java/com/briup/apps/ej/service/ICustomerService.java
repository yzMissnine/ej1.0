package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    int insert(Customer record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Customer record) throws Exception;
    Customer findById(Long id);
}
