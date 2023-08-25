package com.cg.utils;

import com.cg.model.User;

import java.util.Comparator;

public class CompareUtils {
    public static Comparator<User> comparatorAscById(){
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Long.compare(o1.getId(), o2.getId());
            }
        };
    }
    public static Comparator<User> comparatorDescById() {
        return  new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Long.compare(o1.getId(), o2.getId()) * -1;
            }
        };
    }
    public static Comparator<User> comparatorAscByName() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.getName().compareTo(o2.getName())) *-1;
            }
        };
    }
    public static Comparator<User> comparatorAscByAge() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
    }

    public static Comparator<User> comparatorDescByName(){
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    public static Comparator<User> comparatorDescByAge() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
    }
}
