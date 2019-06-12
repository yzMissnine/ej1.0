package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.service.IOrderLineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;
    @GetMapping("findAll")
    public Message findAll(){
        List<OrderLine> list = orderLineService.findAll();
        return MessageUtil.success("success",list);
    }
    @GetMapping("/insert")
    public Message insert(OrderLine record){

        try {
            return MessageUtil.success("success", orderLineService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/delectById")
    public Message delectById(Long id){
        try {
            return MessageUtil.success("success", orderLineService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }
    @GetMapping("/updateById")
    public Message updateById(OrderLine record){

        try {
            return MessageUtil.success("success", orderLineService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/findById")
    public Message findById(Long id) {


        return MessageUtil.success("success", orderLineService.findById(id));

    }
}
