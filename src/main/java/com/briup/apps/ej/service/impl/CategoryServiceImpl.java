package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lishanshan on 2019/6/12
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
@Resource
    private CategoryMapper categoryMapper;
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Category category) throws Exception {
        if(category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        } else {
          //  category.setStatus("正常");
            categoryMapper.insert(category);
        }
    }


    @Override
    public void deleteById(long id) throws Exception {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if(category == null){
            throw new Exception("要删除的用户信息不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
}