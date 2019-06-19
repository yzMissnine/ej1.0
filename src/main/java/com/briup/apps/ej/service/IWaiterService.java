package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> findAll();
    void saveOrUpdate(Waiter waiter) throws Exception;

    void deleteById(long id) throws Exception;

    /*void batchDelete(long[] ids) throws Exception;
    int insert(Waiter record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Waiter record) throws Exception;
    Waiter findById(Long id);*/

}
