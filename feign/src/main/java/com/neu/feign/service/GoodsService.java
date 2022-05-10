package com.neu.feign.service;

import com.neu.feign.bean.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient("provider")
public interface   GoodsService {
    @RequestMapping("/goods/findAll")
    List<Goods> findAll();

    @RequestMapping("/goods/findByName/{name}")
    List<Goods> findByName(@PathVariable String name);

    @RequestMapping("/goods/findById/{id}")
    List<Goods> findById(@PathVariable int id);

    @RequestMapping("/goods/findByF_id/{f_id}")
    List<Goods> findByF_Id(@PathVariable int f_id);

    @RequestMapping("/goods/findByPrice/{price}")
    List<Goods> findByPrice(@PathVariable double price);

    @RequestMapping("/goods/insert/{name}/{f_id}/{price}/{num}")
    public int insert(@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num);

    @RequestMapping("/goods/delete/{id}")
    public int delete(@PathVariable("id") int id);

    @RequestMapping("/goods/update/{id}/{name}/{f_id}/{price}/{num}")
    public int update(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num);

    @RequestMapping("/goods/multiFind/{f_id}/{price}")
    public List<Goods>  multiFind(@PathVariable("f_id") int f_id,@PathVariable("price")double price);



}
