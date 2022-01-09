package com.luxoft.webstore.web;

import com.luxoft.webstore.entity.Goods;
import com.luxoft.webstore.service.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class WebStoreController {

    private final GoodsService goodsService;

    @GetMapping
    public List<Goods> findAll(){
        List<Goods> goods = goodsService.findAll();
        return goods;
    }

    @PostMapping
    public void addGood(Goods good){
        goodsService.add(good);
    }
}
