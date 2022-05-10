package com.neu.provider.dao;

import com.neu.provider.bean.Goods;
import org.apache.ibatis.annotations.*;

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


    /**
     * 插入数据获取主键
     */
    @Insert("insert into tb_goods(name ,f_id ,price ,num) "
            + "values (#{name},#{f_id},#{price},#{num})")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    public void insertGetKey(Goods goods);


    @Delete("delete from tb_goods where id=#{id}")
    public int delete(final Integer id);

    @Update("update tb_goods set name=#{name}, f_id=#{f_id}, price=#{price}, num=#{num} where id=#{id}")
    public int update(Goods goods);

    @Select("select * from tb_goods where f_id=#{f_id} and price=#{price}")
//    @ResultMap("userResult")
    List<Goods> multiFind(int f_id, double price);
}
