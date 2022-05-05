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
}
