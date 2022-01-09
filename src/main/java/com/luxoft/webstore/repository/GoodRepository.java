package com.luxoft.webstore.repository;

import com.luxoft.webstore.entity.Goods;

import java.util.List;

public interface GoodRepository {
    List<Goods> findAll();
    void addProduct(Goods goods);
    void update(Goods good, int id);
    void remove(int id);
}
