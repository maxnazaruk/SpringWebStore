package com.luxoft.webstore.service;


import com.luxoft.webstore.entity.User;
import com.luxoft.webstore.repository.JdbcUserRepository;

import javax.servlet.http.Cookie;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class UserVerificationService {
    private JdbcUserRepository jdbcUserRepository;

    public UserVerificationService(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public boolean signInUser(User user) {
        List<User> list = null;
        try {
            list = jdbcUserRepository.findAll();
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for (User person : list) {
            if (person.getEmail().equals(user.getEmail())) {
                return checkPassword(person, user);
            }
        }
        return false;
    }

    private boolean checkPassword(User dbUser, User logUser) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] messageDigest = md.digest((logUser.getPass() + logUser.getSole()).getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        System.out.println(hashtext);

        if (dbUser.getPass().equals(hashtext)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void addNewUser(User user) {
        jdbcUserRepository.addUser(user);
    }

    public String passwordConverter(User user, String pass) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] messageDigest = md.digest((pass + user.getSole()).getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
        return hashtext;
    }

    public boolean tokenVerification(Cookie[] cookies, List<String> tokens) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-token")) {
                    if (tokens.contains(cookie.getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
