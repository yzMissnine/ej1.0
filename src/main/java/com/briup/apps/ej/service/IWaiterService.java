package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> findAll();
    int insert(Waiter record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Waiter record) throws Exception;
    Waiter findById(Long id);

}
