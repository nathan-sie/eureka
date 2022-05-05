package com.neu.provider.dao;

import com.neu.provider.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select * from tb_goods")
    List<Goods> findAll();

    @Select("select * from tb_goods where name = #{name}")
    List<Goods> findByName(String name);
}
