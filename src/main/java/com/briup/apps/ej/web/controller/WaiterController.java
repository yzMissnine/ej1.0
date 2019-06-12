package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.IWaiterService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private IWaiterService waiterService;
    @GetMapping("findAll")
    public Message findAll(){
        List<Waiter> list = waiterService.findAll();
        return MessageUtil.success("success",list);
    }
    @GetMapping("/insert")
    public Message insert(Waiter record){

        try {
            return MessageUtil.success("success", waiterService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/delectById")
    public Message delectById(Long id){
        try {
            return MessageUtil.success("success", waiterService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }
    @GetMapping("/updateById")
    public Message updateById(Waiter record){

        try {
            return MessageUtil.success("success", waiterService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/findById")
    public Message findById(Long id) {


        return MessageUtil.success("success", waiterService.findById(id));

    }
}
