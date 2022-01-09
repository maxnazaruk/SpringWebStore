package com.luxoft.webstore.repository.mapper;



import com.luxoft.webstore.entity.Goods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class GoodMapper implements RowMapper<Goods> {

    @Override
    public Goods mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        LocalDateTime localDateTime = resultSet.getTimestamp("date").toLocalDateTime();

        Goods good = Goods.builder().
                id(id)
                .name(name)
                .price(price)
                .date(localDateTime).
                build();

        return good;
    }
}
