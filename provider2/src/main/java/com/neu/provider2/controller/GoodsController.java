package com.neu.provider2.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.provider2.bean.Goods;
import com.neu.provider2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/findByName/{name}")
    public List<Goods> findByName(@PathVariable String name) throws Exception {
        List<Goods> list =  service.findByName(name);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @RequestMapping("/findById/{id}")
    public List<Goods> findById(@PathVariable int id) throws Exception {
        List<Goods> list =  service.findById(id);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @RequestMapping("/findByF_id/{f_id}")
    public List<Goods> findByF_Id(@PathVariable int f_id) throws Exception {
        List<Goods> list =  service.findByF_id(f_id);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }

    @RequestMapping("/findByPrice/{price}")
    public List<Goods> findByPrice(@PathVariable double price) throws Exception {
        List<Goods> list =  service.findByPrice(price);
        if(list == null || list.size() == 0)
            throw new Exception();
        return list;
    }


    public List<Goods> fallback(@PathVariable("name") String name){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setName("Not Found!");
        list.add(Goods);
        return list;
    }
}
