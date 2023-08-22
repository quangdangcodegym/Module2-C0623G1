package com.cg.model;

import com.cg.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements IParseModel<User> {
    private long id;
    private String name;
    private String password;
    private int age;
    private LocalDate dob;
    private EGender gender;


    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static void main(String[] args) {
    }

    @Override
    public User parse(String line) {
        String[] items = line.split(",");
        User u = new User(Long.parseLong(items[0]), items[1], items[2],Integer.parseInt(items[3]),
                DateUtils.parseDate(items[4]), EGender.valueOf(items[5]));
        return u;
    }

    @Override
    public String toString() {
        //3,Quang Dang2,123123,18,18-07-1992,MALE
        return String.format("%s,%s,%s,%s,%s,%s", this.id, this.name, this.password, this.age,
                DateUtils.formatDate(this.dob), this.gender);
    }
}
