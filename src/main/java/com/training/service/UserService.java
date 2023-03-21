package com.training.service;

import com.training.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserByLogin(String login);

    User getUserById(Integer id);
}
