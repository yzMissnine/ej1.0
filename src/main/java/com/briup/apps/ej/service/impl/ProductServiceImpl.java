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
    @Override
    public void saveOrUpdate(Product product) throws Exception {
        if(product.getId()!=null){
            productMapper.updateByPrimaryKey(product);
        } else {
            product.setStatus("正常");
            productMapper.insert(product);
        }
    }


    @Override
    public void deleteById(long id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);
        if(product == null){
            throw new Exception("要删除的产品                          不存在");
        }
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            productMapper.deleteByPrimaryKey(id);
        }
    }
    //插入数据
    /*@Override
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
    }*/

}
