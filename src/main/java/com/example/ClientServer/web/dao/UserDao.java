package com.example.ClientServer.web.dao;


import com.example.ClientServer.web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User getUserById(Long id);

    List<User> listUsers();

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserByName(String name);

    User getUserByEmail(String email);
}
