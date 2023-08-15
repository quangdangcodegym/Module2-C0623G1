package nhanvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class UIManager {

    private Scanner scanner = new Scanner(System.in);
    List<Employee> employees;

    public UIManager() {
        employees = new ArrayList<>();

        List<Certificate> certificatesExperience = new ArrayList<>();
        certificatesExperience.add(new Certificate(1L, "BAP TOT NGHIEP DAI HOC KHOA HOC", "GIOI", LocalDate.of(2022, 10, 10)));
        certificatesExperience.add(new Certificate(2L, "BAP TIENG ANH", "GIOI", LocalDate.of(2028, 10, 10)));
        Employee eplExperience = new Experience(1L, "Quang Dang", LocalDate.of(2023, 8, 14), "0399578132", "quang.dang@codegym.vn",
            0 ,certificatesExperience, 2, "Leader");

        employees.add(eplExperience);
        Employee.employeeCount = Employee.employeeCount + 1;


//        (long id, String fullName, LocalDate birthDay, String phone, String email,
//        int employeeType, List<nhanvien.Certificate> certificates,
//                LocalDate graduationDate, String graduationRank, String education)


        List<Certificate> certificatesFresher = new ArrayList<>();
        certificatesFresher.add(new Certificate(1L, "BAP TOT NGHIEP BACH KHOA", "GIOI", LocalDate.of(2022, 10, 10)));
        Employee eplFresher = new Fresher(2L, "Long Dang", LocalDate.of(1990, 2, 2), "0399578135", "long.dang@codegym.vn",
                1, certificatesFresher, LocalDate.of(2022, 10, 10), "KHA", "TRUONG BACH KHOA");

        employees.add(eplFresher);


    }


    public void launcher(){
        boolean checkContinue = false;
        do {
            System.out.println("Menu chương trình");
            System.out.println("Nhập 1. Xem danh sách nhân viên");
            System.out.println("Nhập 2. Thêm nhân viên");
            System.out.println("Nhập 3. Xóa nhân viên");

            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:
                    showListEmployeesView();
                    break;
                case 2:
                    addEmployeeView();
                    break;
                case 3:
                    editEmployeeView();
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục hay không (Y/N): ");
            String actionContinue = scanner.nextLine();
            switch (actionContinue) {
                case "Y":
                    checkContinue = true;
                    break;
                case "N":
                    checkContinue = false;
                    break;
            }
        } while (checkContinue);

    }

    private void editEmployeeView() {
        System.out.println("Nhập ID nhân viên muốn sửa");
        long idEmployee = Long.parseLong(scanner.nextLine());
        findEmployeeById(idEmployee);

    }

    public Employee findEmployeeById(long idEmployee) {
        Employee eplEdit = null;

        /**
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idEmployee) {
                eplEdit = employees.get(i);
                break;
            }
        }



        eplEdit = employees.stream().filter(new Predicate<nhanvien.Employee>() {
            @Override
            public boolean test(nhanvien.Employee employee) {
                if (employee.getId() == idEmployee) {
                    return true;
                }
                return false;
            }
        }).findFirst().orElseThrow();

        eplEdit = employees.stream().filter(employee -> {
            if(employee.getId() == idEmployee){
                return true;
            }
            return false;
        }).findFirst().orElseThrow();;

        eplEdit = employees.stream().filter(employee -> {
//            return employee.getId() == idEmployee ? true : false;
            return employee.getId() == idEmployee;
        }).findFirst().orElseThrow();;

         **/

        eplEdit = employees.stream().filter(employee -> employee.getId() == idEmployee).findFirst().orElseThrow();

        return eplEdit;
    }

    public void showListEmployeesView(){
        System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", "ID", "Fullname", "Birthday", "Phone", "Email", "nhanvien.Employee type");
        /**
        for (int i = 0; i < employees.size(); i++) {
            nhanvien.Employee eplItem = employees.get(i);
            System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
                    eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
        }
        Consumer c;


         employees.stream().forEach(eplItem -> {
             System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
             eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
         });
         **/
        Consumer c;
        employees.stream().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee eplItem) {
                System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
                        eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
            }
        });

        /**
         Instance method reference: (obj[EType], args) -> obj.instanceMethod(args)
                                    Ngắn gọn: EType::instanceMethod
         */

        employees.stream().forEach(eplItem -> {
            System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
                    eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
        });

//        employees.stream().forEach(nhanvien.PrintUtils::toStringEmployee);     // Nếu phương thức bên trong là static

//        nhanvien.PrintUtils printUtils = new nhanvien.PrintUtils();
//        employees.stream().forEach(printUtils::toStringEmployee);

        employees.stream().forEach(Employee::showInfo);






    }

    public void addEmployeeView(){
        System.out.println("Chọn loại nhân viên muốn thêm: ");
        System.out.println("Nhập 1. Thêm nhanvien.Experience");
        System.out.println("Nhập 2. Thêm nhanvien.Fresher");
        System.out.println("Nhập 3. Thêm nhanvien.Intern");

        Employee epl;
        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1:
                epl = new Experience();
                addEmployeeExperienceView(epl);
                break;
            case 2:
                epl = new Fresher();
                addEmployeeFresherView(epl);
                break;

        }
    }

    public void inputBasicEmployeeInfo(Employee epl) {
        System.out.println("Nhập họ tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập ngày sinh (theo định dạng: dd-MM-yyyy: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String strDate = scanner.nextLine();       // "20-08-2023"
        LocalDate birtDay = LocalDate.parse(strDate, formatter);
        System.out.println("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        epl.setFullName(fullName);
        epl.setBirthDay(birtDay);
        epl.setPhone(phone);
        epl.setEmail(email);
        epl.setId(Employee.employeeCount + 1);

    }

    public void addEmployeeExperienceView(Employee epl) {

        inputBasicEmployeeInfo(epl);
        System.out.println("Nhập số năm kinh nghiệm:");
        int expInYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kĩ năng:");
        String skill = scanner.nextLine();

        if (epl instanceof Experience) {
            Experience experience = (Experience) epl;
            experience.setExpInYear(expInYear);
            experience.setProSkill(skill);
        }
        employees.add(epl);
        Employee.employeeCount = Employee.employeeCount +1;
    }

    public void addEmployeeFresherView(Employee epl){
        inputBasicEmployeeInfo(epl);


        System.out.println("Nhập ngày tốt nghiệp (theo định dạng: dd-MM-yyyy): ");
        LocalDate graduationDate = DateUtils.parseDate(scanner.nextLine());

        System.out.println("Nhập loại bằng: ");
        String graduationRank = scanner.nextLine();

        System.out.println("Nhập trường học: ");
        String education = scanner.nextLine();

        if (epl instanceof Fresher) {
            Fresher fresher = (Fresher) epl;
            fresher.setEducation(education);
            fresher.setGraduationDate(graduationDate);
            fresher.setEducation(education);
        }

        employees.add(epl);
        Employee.employeeCount = Employee.employeeCount +1;
    }



    public static void main(String[] args) {
        UIManager uiManager = new UIManager();
        uiManager.launcher();
    }

}
