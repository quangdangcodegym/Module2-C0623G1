package views;

import init.Initdata;
import models.User;
import service.UserService;
import utils.GetValue;

import java.util.List;

public class UserView {
    private UserService userService;

    public UserView() {
        Initdata.initUser();
        userService = new UserService();
    }
    public void launcher(){
        System.out.println("Menu quản lý user:");
        System.out.println("Nhập 1. Xem danh sách");
        System.out.println("Nhập 2. Thêm user");
        System.out.println("Nhập 3. Sửa user");

        int actionChoice = GetValue.getInt("Mời nhập: ");
        switch (actionChoice) {
            case 1:
                showUsers();
                break;
            case 2:
                addUser();
                break;
        }

    }

    private void addUser() {

    }

    private void showUsers() {
        List<User> users = userService.getAll();
        for (User u : users) {
            //id, String name, String username, String password, Enum gender, Enum role
            System.out.printf("%5s | %10s | %20s | %10s \n", u.getId(), u.getName(), u.getGender(), u.getRole());
        }


    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.launcher();
    }
}
