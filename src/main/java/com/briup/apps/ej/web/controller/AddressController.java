package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
public class AddressController{
    @Autowired
    private IAddressService addressService;


    @GetMapping("findAll")
    @ApiOperation("查询所有地址信息")
    public Message findAllAddress(){
        List<Address> list = addressService.findAllAddress();
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("通过ID查询")
    public Message query(@ApiParam(value = "主键",required = true)@RequestParam("customer_id")@NotNull @ModelAttribute("customer_id") Long customer_id) throws Exception{
        Address address = addressService.query(customer_id);
        return MessageUtil.success("success",address);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新地址信息")
    public Message saveOrUpdate(Address address) throws Exception{
        addressService.saveOrUpdate(address);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteAddressById(@NotNull @ModelAttribute("id") Long id) throws Exception{
        addressService.deleteAddressById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除地址信息")
    public Message batchDeleteAddress(long[] ids) throws Exception{
        addressService.batchDeleteAddress(ids);
        return MessageUtil.success("批量删除成功");
    }

}


