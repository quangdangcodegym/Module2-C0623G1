package com.cg.views;

import com.cg.model.User;
import com.cg.service.IUserService;
import com.cg.service.UserService;
import com.cg.utils.AuthUtils;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner = new Scanner(System.in);
    private IUserService iUserService;
    public LoginView() {
        iUserService = new UserService();
    }
    public void launcher() {
        System.out.println("Đặng nhập/Đăng ký");
        System.out.println("Nhập 1. Đăng nhập");
        System.out.println("Nhập 2. Đăng ký");

        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1 -> {
                loginView();
            }
            case 2 -> {
                registerView();
            }
        }

    }

    private void registerView() {
    }

    private void loginView() {
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập password:");
        String password = scanner.nextLine();

        if (iUserService.checkUsernamePassword(username, password)) {
            User user = iUserService.findUser(username);
            AuthUtils.setUserAuthentication(user);

            OrderView orderView = new OrderView();
            orderView.launcher();
            // Bỏ thêm cái ROLE
//            if(user.getRole().equal "ADMIN";)
        }
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.launcher();
    }
}
