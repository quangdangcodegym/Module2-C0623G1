package com.cg.service;

import com.cg.model.EGender;
import com.cg.model.User;
import com.cg.utils.DateUtils;
import com.cg.utils.FileUtils;
import com.cg.utils.PasswordUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserService implements IUserService {
    private final String fileUser = "./data/users.txt";
    @Override
    public List<User> getAllUsers() {
        return FileUtils.readData(fileUser, User.class);
    }

    @Override
    public User findUser(long id) {
        List<User> users = getAllUsers();
        User u = users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
        return u;
    }

    @Override
    public User findUser(String username) {
        List<User> users = getAllUsers();
        User u = users.stream().filter(user -> user.getName().equals(username)).findFirst().orElseThrow();
        return u;
    }

    @Override
    public void updateUser(long id, User user) {
        List<User> users = getAllUsers();
        /**
        for (User u : users) {
            if (u.getId() == id) {
                u.setAge(user.getAge());
                u.setName(user.getName());
                u.setDob(user.getDob());
                u.setGender(user.getGender());
                u.setPassword(user.getPassword());
            }
        }
         **/
        users.stream()
                .filter(u0-> u0.getId() == id)
                .map(u->{
                    u.setAge(user.getAge());
                    u.setName(user.getName());
                    u.setDob(user.getDob());
                    u.setGender(user.getGender());
                    u.setPassword(user.getPassword());
                    return u;
                });

    }

    @Override
    public void deleteUser(long id) {
        List<User> users = getAllUsers();
        /**
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
            }
        }
         **/
        users.remove(
                users.stream().filter(u -> u.getId() == id).findFirst().get()
        );
        FileUtils.writeData(fileUser, users);
    }

    @Override
    public void createUser(User user) {
        List<User> users = getAllUsers();
        user.setPassword(PasswordUtils.generatePassword(user.getPassword()));
        users.add(user);

        FileUtils.writeData(fileUser, users);
    }

    @Override
    public boolean checkUsernamePassword(String username, String password) {
        List<User> users = getAllUsers();

        return users
                .stream()
                .anyMatch(user -> user.getName().equals(username) && PasswordUtils.isValid(password, user.getPassword()));
    }
}
