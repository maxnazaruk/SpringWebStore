package com.luxoft.webstore.repository;


import com.luxoft.webstore.entity.Goods;
import com.luxoft.webstore.repository.mapper.GoodMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcGoodsRepository implements GoodRepository {
    private static final GoodMapper GOOD_MAPPER = new GoodMapper();
    private static final String SELECT_ALL = "SELECT id, name, price, date FROM goods";
    private static final String INSERT_INTO = "INSERT INTO goods (name, price, date) VALUES (?, ?, NOW());";
    private static final String UPDATE = "UPDATE goods SET name = ?, price = ?, date = ? WHERE id = ?;";
    private static final String REMOVE = "DELETE FROM goods WHERE id = ?;";

    private final JdbcTemplate jdbcTemplate;

    public void addProduct(Goods good) {
        jdbcTemplate.update(INSERT_INTO, good.getName(), good.getPrice());
    }

    @Override
    public List<Goods> findAll() {
        return jdbcTemplate.query(SELECT_ALL, GOOD_MAPPER);
    }


    public void update(Goods good, int id)  {
        jdbcTemplate.update(UPDATE, good.getName(), good.getPrice(), good.getDate(), id);
    }

    public void remove(int id) {
        jdbcTemplate.update(REMOVE, id);
    }
}
