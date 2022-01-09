package com.luxoft.webstore.repository;

import com.luxoft.webstore.entity.User;

import java.util.List;

public interface UserInterface {
    List<User> findAll();
    void addUser(User user);
}
