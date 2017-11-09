package com.tow.spring.form.service;

import com.tow.spring.form.model.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    void saveOrUpdate(User user);

    void delete(int id);
}
