package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;

import java.util.List;

/**
 * Created by lishanshan on 2019/6/11
 */
public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category) throws Exception;

    void deleteById(long id) throws Exception;

    void batchDelete(long[] ids) throws Exception;
}
