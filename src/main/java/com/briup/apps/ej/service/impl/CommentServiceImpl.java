package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.bean.CommentExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lishanshan on 2019/6/12
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;



    @Override
    public List<Comment> findAll(){
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);

    }
    //插入数据
    @Override
    public int insert(Comment record) throws Exception{
        return commentMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        Comment order = commentMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new Exception("删除的订单不存在");

        }
        else {
            return commentMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(Comment record) throws Exception{
        return commentMapper.updateByPrimaryKey(record);
    }
    @Override
    public Comment findById(Long id){
        return commentMapper.selectByPrimaryKey(id);
    }

}


   /* @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

   @Override
    public Comment findById(Long id) {

        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment comment) throws Exception {
        return commentMapper.insert(comment);
    }

    @Override
    public int saveOrUpdate(Comment comment) throws Exception {
        return commentMapper.updateByPrimaryKey(comment);
    }
   }
*/


