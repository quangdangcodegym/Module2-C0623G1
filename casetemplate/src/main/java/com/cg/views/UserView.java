package com.cg.views;

import com.cg.model.EGender;
import com.cg.model.User;
import com.cg.service.IUserService;
import com.cg.service.UserService;
import com.cg.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class UserView {
    private Scanner scanner = new Scanner(System.in);
    private IUserService iUserService;

    public UserView() {
        iUserService = new UserService();
    }
    public void launcher() {
        boolean checkAction = false;
        do {
            System.out.println("Menu quản lý user: ");
            System.out.println("Nhập 1. Xem danh sách ");
            System.out.println("Nhập 2. Thêm user");
            System.out.println("Nhập 3. Sửa user");
            System.out.println("Nhập 4. Xóa user theo ID");
            System.out.println("Nhập 5: Sắp xếp theo (Vào trong chọn thêm menu: tên/tuổi/giới tính/dob + TĂNG DẦN/GIẢM DẦN) ");
            System.out.println("Nhập 6: Tìm kiếm theo ");

            /**
             System.out.println("Menu quản lý Sản phẩm: ");
             System.out.println("Nhập 1. Xem danh sách ");
             System.out.println("Nhập 2. Thêm user");
             System.out.println("Nhập 3. Sửa user");
             System.out.println("Nhập 4. Xóa user theo ID");
             System.out.println("Nhập 5: Sắp xếp theo (Vào trong chọn thêm menu: tên/tuổi/giới tính/dob + TĂNG DẦN/GIẢM DẦN) ");
             System.out.println("Nhập 6: Tìm kiếm theo ");
             */

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1 -> {
                    showUsers();
                }
                case 2 -> {
                    addUser();
                }
                case 4 -> {
                    deleteUser();
                }
                case 5 -> {
                    sortUser();
                }
            }
        }while (checkAction);



    }

    private void sortUser() {
        System.out.println("Chon:");
        System.out.println("Nhập 1. Tăng dần");
        System.out.println("Nhập 2. Giảm dân");

        int action = Integer.parseInt(scanner.nextLine());

        List<User> users = iUserService.getAllUsers();
        Comparator<User> comparator = null;
        switch (action) {
            case 1 -> {
                System.out.println("Bạn muốn sắp xếp theo:");
                System.out.println("Nhập 1. ID");
                System.out.println("Nhập 2. Tên");
                System.out.println("Nhập 3. Tuổi");

                int actionBy = Integer.parseInt(scanner.nextLine());
                switch (actionBy) {
                    case 1 -> {
                       comparator = new Comparator<User>() {
                           @Override
                           public int compare(User o1, User o2) {
                               if (o1.getId() > o2.getId()) {
                                   return 1;
                               } else if (o1.getId() < o2.getId()) {
                                   return -1;
                               }
                               return 0;
                           }
                       };
                    }
                    case 2 -> {
                        comparator = new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                return (o1.getName().compareTo(o2.getName())) *-1;
                            }
                        };
                    }
                    case 3 -> {
                        comparator = new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                if (o1.getAge() > o2.getAge()) {
                                    return 1;
                                } else if (o1.getAge() < o2.getAge()) {
                                    return -1;
                                }
                                return 0;
                            }
                        };
                    }
                }
            }
            case 2 -> {
                System.out.println("Bạn muốn sắp xếp theo:");
                System.out.println("Nhập 1. ID");
                System.out.println("Nhập 2. Tên");
                System.out.println("Nhập 3. Tuổi");
                int actionBy = Integer.parseInt(scanner.nextLine());
                switch (actionBy) {
                    case 1 -> {
                        comparator = new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                if (o1.getId() < o2.getId()) {
                                    return 1;
                                } else if (o1.getId() > o2.getId()) {
                                    return -1;
                                }
                                return 0;
                            }
                        };
                    }
                    case 2 -> {
                        comparator = new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        };
                    }
                    case 3 -> {
                        comparator = new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                if (o1.getAge() < o2.getAge()) {
                                    return 1;
                                } else if (o1.getAge() > o2.getAge()) {
                                    return -1;
                                }
                                return 0;
                            }
                        };
                    }
                }
            }
        }


        users.sort(comparator);
        showUsers(users);
    }

    private void deleteUser() {
        System.out.println("Nhập ID cần xóa: ");
        long id = Long.parseLong(scanner.nextLine());

        iUserService.deleteUser(id);
        showUsers();
    }

    private void addUser() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập password:");
        String pass = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày sinh: (dd-MM-yyyy)");
        LocalDate dob = DateUtils.parseDate(scanner.nextLine());

        System.out.println("Nhập giới tính: ");
        for (EGender eGender : EGender.values()) {
            System.out.println(eGender.getName() + " : " + eGender.getId());
        }
        int idGender = Integer.parseInt(scanner.nextLine());
        EGender gender = EGender.findById(idGender);

        User user = new User(System.currentTimeMillis() % 100000, name, pass, age, dob, gender);

        iUserService.createUser(user);

        showUsers();
    }

    private void showUsers() {
        System.out.printf("%10s | %20s | %10s | %20s | %10s \n", "ID", "Name", "DOB", "AGE", "GENDER");
        List<User> users = iUserService.getAllUsers();
        for (User u : users) {
            System.out.printf("%10s | %20s | %10s | %20s | %10s \n",
                    u.getId(), u.getName(), DateUtils.formatDate(u.getDob()), u.getAge(), u.getGender());
        }
    }
    private void showUsers(List<User> users) {
        System.out.printf("%10s | %20s | %10s | %20s | %10s \n", "ID", "Name", "DOB", "AGE", "GENDER");
        for (User u : users) {
            System.out.printf("%10s | %20s | %10s | %20s | %10s \n",
                    u.getId(), u.getName(), DateUtils.formatDate(u.getDob()), u.getAge(), u.getGender());
        }
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.launcher();
    }
}
