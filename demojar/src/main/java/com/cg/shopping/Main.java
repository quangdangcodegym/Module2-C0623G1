package com.cg.shopping;

import com.cg.shopping.model.User;
import com.cg.shopping.utils.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = FileUtils.readData("./data/users.txt", User.class);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
