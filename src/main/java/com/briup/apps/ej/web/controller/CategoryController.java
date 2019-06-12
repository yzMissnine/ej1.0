package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lishanshan on 2019/6/11
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired

    private ICategoryService categoryService;

    @GetMapping("/insert")
    public Message insert(Category category){
        try{
            categoryService.insert(category);
            return MessageUtil.success("插入成功！");
        }catch (Exception e){
            return  MessageUtil.error("插入失败！"+e.getMessage());
        }
    }
    @GetMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(Long id){
        try{
            categoryService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            return MessageUtil.error("删除失败！");
        }

    }
    @GetMapping("/updateByPrimaryKey")
    public Message updateByPrimaryKey(Category category){
        try{
            categoryService.updateByPrimaryKey(category);
            return MessageUtil.success("更新成功！");
        }catch (Exception e){
            return MessageUtil.error("更新失败！");
        }
    }
    @GetMapping("/selectByExample")
    public Message selectByExample(){
        List<Category> categories =categoryService.selectByExample(new CategoryExample());
        return MessageUtil.success("查询成功！",categories);
    }
}

