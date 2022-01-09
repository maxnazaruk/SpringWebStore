package com.luxoft.webstore.repository;


import com.luxoft.webstore.entity.User;
import com.luxoft.webstore.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserInterface {
    private final JdbcTemplate jdbcTemplate;
    private static final UserMapper USER_MAPPER = new UserMapper();
    private static final String SELECT_ALL = "SELECT id, email, pass, sole FROM users;";
    private static final String CREATE_TABLE = "CREATE TABLE users (id SERIAL, email varchar(255), pass varchar(255), sole varchar(255));";
    private static final String INSERT_INTO = "INSERT INTO users (email, pass, sole) VALUES (?, ?, ?);";

    public void addUser(User user) {
        jdbcTemplate.update(INSERT_INTO, user.getEmail(), user.getPass(), user.getSole());
    }

    public List<User> findAll() {
        return jdbcTemplate.query(SELECT_ALL, USER_MAPPER);
    }
}
