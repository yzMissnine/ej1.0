package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by lishanshan on 2019/6/12
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public List<Address> selectByExample(){
        AddressExample addressExample = new AddressExample();
        return addressMapper.selectByExample(addressExample);
    }
    @Override
    public Address selectByPrimaryKey(Long id){
        return addressMapper.selectByPrimaryKey(id);
    }
    @Override
    public int deleteByPrimaryKey(Long id){
        return addressMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(Address address){
        return addressMapper.insert(address);
    }
    @Override
    public int updateByPrimaryKey(Address address){
        return addressMapper.updateByPrimaryKey(address);
    }
}
