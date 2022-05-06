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

    @Select("select * from tb_goods where id = #{id}")
    List<Goods> findById(int id);

    @Select("select * from tb_goods where f_id = #{f_id}")
    List<Goods> findByF_id(int f_id);

    @Select("select * from tb_goods where price = #{price}")
    List<Goods> findByPrice(double price);
}
