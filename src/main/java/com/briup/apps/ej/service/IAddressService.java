package com.briup.apps.ej.service;
import com.briup.apps.ej.bean.Address;
import java.util.List;
/**
 * Created by lishanshan on 2019/6/11
 */
public interface IAddressService {
    List<Address> selectByExample();

    Address selectByPrimaryKey(Long id);
    int deleteByPrimaryKey(Long id) throws Exception;
    int insert(Address address)throws Exception;
    int updateByPrimaryKey(Address address) throws Exception;
}
