package init;

import models.Gender;
import models.Role;
import models.User;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

public class Initdata {
    public static void initUser() {
        //int id, String name, String username, String password, Enum gender, Enum role
        List<User> list = new ArrayList<>();
        list.add(new User(1,"Thanh Dat","nam123","123456", Gender.MALE, Role.ADMIN));
        list.add(new User(2,"Phap","nam123","123456", Gender.MALE, Role.CASHIER));
        list.add(new User(3,"Huong","nam123","123456", Gender.MALE, Role.CLIENT));
        list.add(new User(4,"Pham Van","phamnam123","123456", Gender.MALE, Role.CLIENT));
        list.add(new User(5,"Linh","linh123","123456", Gender.MALE, Role.CLIENT));
        list.add(new User(6,"Nam","nam123","123456", Gender.MALE, Role.CLIENT));

        SerializationUtil.serialize(list,"users.txt");
    }

    public static void main(String[] args) {
        initUser();

    }
}
