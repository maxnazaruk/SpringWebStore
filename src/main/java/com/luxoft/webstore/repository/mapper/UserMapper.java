package com.luxoft.webstore.repository.mapper;



import com.luxoft.webstore.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String pass = resultSet.getString("pass");
        String sole = resultSet.getString("sole");

        User user = User.builder().
                id(id)
                .email(email)
                .pass(pass)
                .sole(sole)
                .build();

        return user;
    }
}
