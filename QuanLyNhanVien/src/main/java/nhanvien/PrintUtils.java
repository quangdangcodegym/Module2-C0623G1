package nhanvien;

import stream_dahinh.Rectangle;

public class PrintUtils {
    public void toStringEmployee(Employee eplItem) {
        System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
                eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
    }

    public static int xxx(Rectangle c1, Rectangle c2) {
        if (c1.getArea() > c2.getArea()) {
            return 1;
        } else if (c1.getArea() < c2.getArea()) {
            return -1;
        }else{
            return 0;
        }
    }


    public static boolean uuu(Rectangle r1) {
        if(String.valueOf(r1.getWidth()).contains("5")){
            return true;
        }
        return false;
    }


}
