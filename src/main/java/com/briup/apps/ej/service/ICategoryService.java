package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;

import java.util.List;

/**
 * Created by lishanshan on 2019/6/11
 */
public interface ICategoryService {
    int insert(Category category) throws Exception;

    int deleteByPrimaryKey(Long id) throws Exception;

    int updateByPrimaryKey(Category category) throws Exception;

    List<Category> selectByExample(CategoryExample categoryExample);
    Category selectByPrimaryKey(Long id);
}
