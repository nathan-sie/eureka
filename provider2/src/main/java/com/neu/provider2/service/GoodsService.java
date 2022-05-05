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
}
