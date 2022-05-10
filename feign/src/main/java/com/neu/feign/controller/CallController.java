package com.neu.feign.controller;

import com.neu.feign.bean.Goods;
import com.neu.feign.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class CallController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findAll")
    public Object findAll(){
        return goodsService.findAll();
    }

    @RequestMapping("/findByName/{name}")
    public Object findByCode(@PathVariable String name){
        return goodsService.findByName(name);
    }

    @RequestMapping("/findById/{id}")
    public Object findById(@PathVariable int id){
        return goodsService.findById(id);
    }

    @RequestMapping("/findByF_id/{f_id}")
    public List<Goods> findByF_id(@PathVariable int f_id){
        return goodsService.findByF_Id(f_id);
    }

    @RequestMapping("/findByPrice/{price}")
    public List<Goods> findByPrice(@PathVariable double price){
        return goodsService.findByPrice(price);
    }

    @RequestMapping("/multiFind/{f_id}/{price}")
    public List<Goods>  multiFind(@PathVariable("f_id") int f_id,@PathVariable("price")double price){return goodsService.multiFind(f_id,price);}

    @RequestMapping("/insert/{name}/{f_id}/{price}/{num}")
    public int insert(@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num){
        return goodsService.insert(name, f_id, price, num);
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id){
        return goodsService.delete(id);
    }

    @RequestMapping("/update/{id}/{name}/{f_id}/{price}/{num}")
    public int update(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num){
        return goodsService.update(id, name, f_id, price, num);
    }
}
