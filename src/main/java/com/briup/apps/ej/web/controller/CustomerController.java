package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping("findAll")
    @ApiOperation("查询所有顾客信息")
    public Message findAll(){
        List<Customer> list = customerService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(Customer customer) throws Exception{
        customerService.saveOrUpdate(customer);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(@NotNull @ModelAttribute("id") Long id) throws Exception{
        customerService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(long[] ids) throws Exception{
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}

















/*package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Customer> list = customerService.findAll();
        return MessageUtil.success("查找成功",list);
    }
    @GetMapping("/insert")
    public Message insert(Customer record){
        try
        {
            return MessageUtil.success("插入成功",customerService.insert(record));
        } catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error("插入失败");
        }
    }
    @GetMapping("/deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id") long id){
        try{
            return MessageUtil.success("删除成功",customerService.deleteById(id));
        } catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }
    @GetMapping("/updateById")
    public Message updateById(Customer record){
        try {
            return MessageUtil.success("修改成功", customerService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }


    @GetMapping("/findById")
    public Message findById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        Customer customer = customerService.findById(id);
        return MessageUtil.success("success",customer);
    }
}

*/