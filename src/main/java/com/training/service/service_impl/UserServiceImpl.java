package com.training.service.service_impl;

import com.training.dao.AbstractDAO;
import com.training.dao.UserDAO;
import com.training.model.User;
import com.training.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    AbstractDAO<Integer, User> dao = new UserDAO();

    @Override
    public List<User> getAllUsers() {
        return dao.getAll();
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.getByLogin(login);
    }

    @Override
    public User getUserById(Integer id) {
        return dao.getById(id);
    }
}
