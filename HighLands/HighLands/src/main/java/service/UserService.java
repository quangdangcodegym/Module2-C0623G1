package service;

import models.User;
import utils.CRUD;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements CRUD<User> {
    private List<User> userList;
    private static String fileUser = "users.txt";

    public UserService(){
        userList = getAll();
        if (userList == null)  {
            userList = new ArrayList<>();
        }
    }
    private void save(){
        SerializationUtil.serialize(userList, fileUser);
    }
    @Override
    public void create(User user) {
        userList = getAll();
        userList.add(user);
        SerializationUtil.serialize(userList, fileUser);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<User> readFile(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) SerializationUtil.deserialize(fileUser);
    }
}
