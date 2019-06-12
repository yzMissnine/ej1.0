package com.briup.apps.ej.service.impl;


import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
 public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll(){
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);

    }
    //插入数据
    @Override
    public int insert(Product record) throws Exception{
        return productMapper.insert(record);
    }
    @Override
    public int deleteById(Long id) throws Exception{
        Product product = productMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new Exception("删除的商品不存在");

        }
        else {
            return productMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public int updateById(Product record) throws Exception{
        return productMapper.updateByPrimaryKey(record);
    }
    @Override
    public Product findById(Long id){
        return productMapper.selectByPrimaryKey(id);
    }

}
