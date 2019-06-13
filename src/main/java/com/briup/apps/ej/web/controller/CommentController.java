package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.service.impl.CommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by lishanshan on 2019/6/11
 */
public class CommentController{

    @Autowired
    private ICommentService commentService;
    @GetMapping("findAll")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(Comment  comment) throws Exception{
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(@NotNull @ModelAttribute("id") Long id) throws Exception{
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }









 /*   @GetMapping("/insert")
    public Message insert(Comment record){

        try {
            return MessageUtil.success("success", commentService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/deleteById")
    public Message deleteById(Long id){
        try {
            return MessageUtil.success("success", commentService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }
    @GetMapping("/updateById")
    public Message updateById(Comment record){

        try {
            return MessageUtil.success("success", commentService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("/findById")
    public Message findById(Long id) {


        return MessageUtil.success("success", commentService.findById(id));

    }
   /* @PostMapping("/findAll")
    public  Message findAll(){
        return MessageUtil.success("success",commentService.findAll());

    }

    @PostMapping("/findById")
    public Message finById(Long id){
        return MessageUtil.success("success",commentService.findById(id));

    }
    @PostMapping("/deleteById")
    public Message deleteById(Long id){
        try{
            commentService.deleteById(id);
            return MessageUtil.success("success");
        }catch (Exception e){
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("/insert")
    public Message insert(Comment comment){
        try{
            commentService.insert(comment);
            return MessageUtil.success("success");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Comment comment){
        try{
            commentService.saveOrUpdate(comment);
            return MessageUtil.success("success");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }*/
}

