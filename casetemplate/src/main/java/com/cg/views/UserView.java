package com.cg.views;

import com.cg.model.EGender;
import com.cg.model.User;
import com.cg.service.IUserService;
import com.cg.service.UserService;
import com.cg.utils.CompareUtils;
import com.cg.utils.DateUtils;
import com.cg.utils.ValidateUtils;
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
                        comparator = CompareUtils.comparatorAscById();
                    }
                    case 2 -> {
                        comparator = CompareUtils.comparatorAscByName();
                    }
                    case 3 -> {
                        comparator = CompareUtils.comparatorAscByAge();
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
                        comparator = CompareUtils.comparatorDescById();
                    }
                    case 2 -> {
                        comparator = CompareUtils.comparatorDescByName();
                    }
                    case 3 -> {
                        comparator = CompareUtils.comparatorDescByAge();
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

    /**

    private String inputUserName(){
        String name = null;
        boolean validateName = false;
        do {
            System.out.println("Nhập tên: ");
            name = scanner.nextLine();
            if (!ValidateUtils.isUserNameValid(name)) {         // Nếu SAI
                System.out.println("Tên phải bắt đầu là kí tự, có từ 8-20 kí tự");
                validateName = true;
            } else {
                validateName = false;
            }
        } while (validateName);
        return name;
    }
    private String inputPassword(){
        String password = null;
        boolean validatePassword = false;
        do {
            System.out.println("Nhập password: ");
            password = scanner.nextLine();
            if (!ValidateUtils.isPasswordValid(password)) {         // Nếu SAI
                System.out.println("Tên phải tôí thiểu 8 kí tự và không chứa kí tự đặc biệt");
                validatePassword = true;
            } else {
                validatePassword = false;
            }
        } while (validatePassword);
        return password;
    }
    private String inputAge(){
        String age = null;
        boolean validateAge = false;
        do {
            System.out.println("Nhập tuổi: ");
            String strAge = scanner.nextLine();
            if (!ValidateUtils.isAgeValid(strAge)) {         // Nếu SAI
                System.out.println("Tuổi phải từ 10-99");
                validateAge = true;
            } else {
                validateAge = false;
            }
        } while (validateAge);
        return age;
    }

     **/

    private String checkInputValid(String fieldName, String fieldMessage, String fieldPattern){
        String input = null;
        boolean validateInput = false;
        do {
            System.out.printf("Nhập %s: \n", fieldName);
            input = scanner.nextLine();
            if (!ValidateUtils.isValid(fieldPattern, input)) {         // Nếu SAI
                System.out.println(fieldMessage);
                validateInput = true;
            } else {
                validateInput = false;
            }
        } while (validateInput);
        return input;
    }



    private void addUser() {
        String name = checkInputValid(ValidateUtils.FIELD_NAME, ValidateUtils.FIELD_NAME_MESSAGE, ValidateUtils.REGEX_USERNAME );
        String pass = checkInputValid(ValidateUtils.FIELD_PASSWORD, ValidateUtils.FIELD_PASSWORD_MESSAGE, ValidateUtils.PASSWORD_REGEX );
        String strAge = checkInputValid(ValidateUtils.FIELD_AGE, ValidateUtils.FIELD_AGE_MESSAGE, ValidateUtils.AGE_REGEX);
        int age = Integer.parseInt(strAge);


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
