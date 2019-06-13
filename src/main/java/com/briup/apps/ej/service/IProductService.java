package com.briup.apps.ej.service;
import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void saveOrUpdate(Product product) throws Exception;

    void deleteById(long id) throws Exception;

    void batchDelete(long[] ids) throws Exception;

   /* int insert(Product record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Product record) throws Exception;
    Product findById(Long id);
*/
}


