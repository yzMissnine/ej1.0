package com.briup.apps.ej.web.controller;

import javax.annotation.Resource;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lishanshan on 2019/6/11
 */
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("/findAll")
    public  Message findAll(){
        return MessageUtil.success("success",commentService.findAll());

    }
    @GetMapping("/findById")
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
    @PostMapping("/svaeOrUpdate")
    public Message saveOrUpdate(Comment comment){
        try{
            commentService.saveOrUpdate(comment);
            return MessageUtil.success("success");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }
}

