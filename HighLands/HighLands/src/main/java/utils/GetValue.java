package utils;

import models.Gender;
import models.Role;

import java.util.Scanner;

public class GetValue {
    static Scanner input = new Scanner(System.in);
    public static String getString(String str) {
        System.out.println(str);
        String enter = input.nextLine();
        return enter;
    }
    public static int getAge(String str){
        try{
            System.out.println(str);
            int age = input.nextInt();
            if (age < 0 || age > 100) {
                throw new Exception(" Age trong khoang 0 - 100");
            }
            return age;
        } catch (Exception e) {
            e.getMessage();
            return getAge(str);
        }
    }
    public static int getInt(String str){
        try{
            System.out.println(str);
            int age = input.nextInt();
            if (age < 0 || age > 100) {
                throw new Exception(" So trong khoang 0 - 100");
            }
            return age;
        } catch (Exception e) {
            e.getMessage();
            return getAge(str);
        }
    }
    public static Enum getGender(String str) {
        System.out.println(str);
        int choice = Integer.parseInt(input.nextLine()) ;
        System.out.println("Nhap 1. Female");
        System.out.println("Nhap 2. Female");
        System.out.println("Nhap 3. Female");
        switch (choice) {
            case 1:
                return Gender.FEMALE;
            case 2:
                return Gender.MALE;
            case 3:
                return Gender.OTHER;
        }
        return null;
    }
    public static Enum getRole(String str) {
        System.out.println(str);
        int choice = Integer.parseInt(input.nextLine()) ;
        System.out.println("Nhap 1. Admin");
        System.out.println("Nhap 2. Cashier");
        System.out.println("Nhap 3. CLient");
        switch (choice) {
            case 1:
                return Role.ADMIN;
            case 2:
                return Role.CASHIER;
            case 3:
                return Role.CLIENT;
        }
        return null;
    }
}
