package com.briup.apps.ej.service;
import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    int insert(Product record) throws  Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Product record) throws Exception;
    Product findById(Long id);

}


