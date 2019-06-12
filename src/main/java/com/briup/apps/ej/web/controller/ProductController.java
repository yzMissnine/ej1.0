package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.service.impl.ProductService;
import com.briup.apps.ej.service.impl.ProductServiceImpl;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }
    @GetMapping("/insert")
    public Message insert(Product record){

        try {
            return MessageUtil.success("success", productService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/delectById")
    public Message delectById(Long id){
        try {
            return MessageUtil.success("success", productService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }
    @GetMapping("/updateById")
    public Message updateById(Product record){

        try {
            return MessageUtil.success("success", productService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/findById")
    public Message findById(Long id) {


        return MessageUtil.success("success", productService.findById(id));

    }
}
