package com.neu.feign.controller;

import com.neu.feign.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
