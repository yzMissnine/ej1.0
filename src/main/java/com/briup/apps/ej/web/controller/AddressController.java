package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lishanshan on 2019/6/11
 *
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;


    @GetMapping("/selectByExample")
    public Message selectByExample() {
        List<Address> addresses = addressService.selectByExample();
        return MessageUtil.success("查询成功！", addresses);
    }

    @GetMapping("/selectByPrimaryKey")
    public Message selectByPrimaryKey(Long id) {
        Address address = addressService.selectByPrimaryKey(id);
        if (address == null) {
            return MessageUtil.error("查询用户不存在");
        }
        return MessageUtil.success("查询用户成功", address);
    }

    @RequestMapping("/insert")
    public Message insert(Address address) {
        try {
            addressService.insert(address);
            return MessageUtil.success("插入成功！");
        }catch (Exception e){
            return  MessageUtil.error("插入失败!"+e.getMessage());
        }


    }

   @RequestMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(Long id) {
        try{
            addressService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            return MessageUtil.error("删除失败!"+e.getMessage());
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    public Message updateByPrimaryKey(Address address) {
        try{
            addressService.updateByPrimaryKey(address);
            return MessageUtil.success("更新成功！");
        }catch (Exception e){
            return MessageUtil.error("更新失败!");
        }
    }

}

