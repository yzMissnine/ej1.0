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
@Override
    public int insert(Category category){
    return categoryMapper.insert(category);
}
@Override
    public int deleteByPrimaryKey(Long id){
    return categoryMapper.deleteByPrimaryKey(id);
}
@Override
    public int updateByPrimaryKey(Category category){
    return categoryMapper.updateByPrimaryKey(category);
}
@Override
    public List<Category> selectByExample(CategoryExample categoryExample){
    return categoryMapper.selectByExample(new CategoryExample());
}
@Override
    public Category selectByPrimaryKey(Long id){
    return categoryMapper.selectByPrimaryKey(id);
}
}
