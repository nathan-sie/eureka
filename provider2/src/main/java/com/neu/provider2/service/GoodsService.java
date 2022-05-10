package com.neu.provider2.service;

import com.neu.provider2.bean.Goods;
import com.neu.provider2.dao.GoodsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsDao dao;

    public List<Goods> findAll(){
        return dao.findAll();
    }

    public List<Goods> findByName(String name){
        return dao.findByName(name);
    }

    public List<Goods> findById(int id){return  dao.findById(id);}

    public List<Goods> findByF_id(int f_id){return  dao.findByF_id(f_id);}

    public List<Goods> findByPrice(double price){return  dao.findByPrice(price);}

    public void insertGetKey(Goods goods) {
        // 数据插入成功以后，Mybatis框架会将插入成功的数据主键存入到user对象中去
        dao.insertGetKey(goods);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int update(Goods goods) {
        return dao.update(goods);
    }

    public List<Goods> multiFind(int f_id, double price) {
        return dao.multiFind(f_id, price);
    }
}
