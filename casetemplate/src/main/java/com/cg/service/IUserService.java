package com.cg.service;

import com.cg.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User findUser(long id);

    void updateUser(long id, User user);

    void deleteUser(long id);

    void createUser(User user);
}
