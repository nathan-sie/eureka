package com.neu.provider.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.provider.bean.Goods;
import com.neu.provider.service.GoodsService;
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
    public List<Goods> fallback(@PathVariable("name") String name){
        ArrayList<Goods> list = new ArrayList<>();
        Goods Goods = new Goods();
        Goods.setName("Not Found!");
        list.add(Goods);
        return list;
    }
}
