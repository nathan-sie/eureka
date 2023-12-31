package com.neu.provider.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.provider.bean.Goods;
import com.neu.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    @RequestMapping("/findAll")
    public List<Goods> findAll(){
        return service.findAll();
    }

    @HystrixCommand(fallbackMethod = "fallbackN")
    @RequestMapping("/findByName/{name}")
    public List<Goods> findByName(@PathVariable String name) throws Exception {
        List<Goods> list =  service.findByName(name);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallbackI")
    @RequestMapping("/findById/{id}")
    public List<Goods> findById(@PathVariable int id) throws Exception {
        List<Goods> list =  service.findById(id);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallbackF")
    @RequestMapping("/findByF_id/{f_id}")
    public List<Goods> findByF_Id(@PathVariable int f_id) throws Exception {
        List<Goods> list =  service.findByF_id(f_id);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallbackP")
    @RequestMapping("/findByPrice/{price}")
    public List<Goods> findByPrice(@PathVariable double price) throws Exception {
        List<Goods> list =  service.findByPrice(price);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }


    @RequestMapping("/insert/{name}/{f_id}/{price}/{num}")
    public int insert(@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num) {
        Goods goods=new Goods();
        goods.setName(name);
        goods.setF_id(f_id);
        goods.setNum(num);
        goods.setPrice(price);
        service.insertGetKey(goods);
        return goods.getId();
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id) throws Exception {

        return service.delete(id);
    }

    @RequestMapping("/update/{id}/{name}/{f_id}/{price}/{num}")
    public int update(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("f_id") int f_id,@PathVariable("price")double price,@PathVariable("num")int num){
        Goods goods=new Goods();
        goods.setName(name);
        goods.setF_id(f_id);
        goods.setNum(num);
        goods.setPrice(price);
        goods.setId(id);
        service.update(goods);
        return id;
    }

    @HystrixCommand(fallbackMethod = "fallbackD")
    @RequestMapping("/multiFind/{f_id}/{price}")
    public List<Goods>  multiFind(@PathVariable("f_id") int f_id,@PathVariable("price")double price) throws Exception{
        List<Goods> list=service.multiFind(f_id,price);
        Iterator<Goods> iterator=list.iterator();
        if(iterator.hasNext()){
            return list;
        }else{
            throw new Exception();
        }
    }


    public List<Goods> fallbackN(@PathVariable("name") String name){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setId(0);
        Goods.setName("Name Not Found!");
        list.add(Goods);
        return list;
    }

    public List<Goods> fallbackI(@PathVariable("id") int id){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setId(0);
        Goods.setName("Id Not Found!");
        list.add(Goods);
        return list;
    }

    public List<Goods> fallbackF(@PathVariable("f_id") int f_id){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setF_id(0);
        Goods.setName("Factory Id Not Found!");
        list.add(Goods);
        return list;
    }

    public List<Goods> fallbackP(@PathVariable("price") double price){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setPrice(0);
        Goods.setName("Price Not Found!");
        list.add(Goods);
        return list;
    }

    public List<Goods> fallbackD(@PathVariable("f_id") int f_id,@PathVariable("price")double price){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setPrice(0);
        Goods.setName("Not Found!");
        list.add(Goods);
        return list;
    }
}
