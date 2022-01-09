package com.luxoft.webstore.service;



import com.luxoft.webstore.entity.Goods;
import com.luxoft.webstore.repository.JdbcGoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GoodsService {

    private final JdbcGoodsRepository jdbcGoodsRepository;

    public List<Goods> findAll() {
        return jdbcGoodsRepository.findAll();
    }

    public void add(Goods goods)  {
        jdbcGoodsRepository.addProduct(goods);
    }

    public void remove(int id)  {
        jdbcGoodsRepository.remove(id);
    }

    public void update(Goods good, int id) {
        jdbcGoodsRepository.update(good, id);
    }
}
