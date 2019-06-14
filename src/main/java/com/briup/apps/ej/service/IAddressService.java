package com.briup.apps.ej.service;
import com.briup.apps.ej.bean.Address;

import java.util.List;
/**
 * Created by lishanshan on 2019/6/11
 */
public interface IAddressService {
    List<Address> findAllAddress();

    void saveOrUpdate(Address address) throws Exception;

    void deleteAddressById(long id) throws Exception;

    void batchDeleteAddress(long[] ids) throws Exception;
}
