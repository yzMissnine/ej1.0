package com.briup.apps.ej.service;
import java.util.List;
import com.briup.apps.ej.bean.Comment;
/**
 * Created by lishanshan on 2019/6/11
 */
public interface ICommentService {
    List<Comment> findAll();
    int insert(Comment record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Comment record) throws Exception;
    Comment findById(Long id);

   /* List<Comment> findAll();
    Comment findById(Long id);
    int deleteById(Long id) throws Exception;
    int insert(Comment comment) throws Exception;
    int saveOrUpdate(Comment comment) throws Exception;*/





}
