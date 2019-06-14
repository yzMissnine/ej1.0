package com.briup.apps.ej.service.impl;


import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 * Created by lishanshan on 2019/6/12
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAllAddress() {
        AddressExample example = new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Address address) throws Exception {
        if(address.getId()!=null){
            addressMapper.updateByPrimaryKey(address);
        } else {
//            address.setStatus("正常");
            addressMapper.insert(address);
        }
    }


    @Override
    public void deleteAddressById(long id) throws Exception {
        Address address = addressMapper.selectByPrimaryKey(id);
        if(address == null){
            throw new Exception("要删除的地址信息不存在");
        }
        addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDeleteAddress(long[] ids) throws Exception {
        for(long id :ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
