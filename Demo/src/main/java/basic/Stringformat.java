package basic;

import java.util.Date;

public class Stringformat {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.printf("%tT%n", date);
        System.out.printf("H : %tH, M: %tM, S: %tS%n",date,date,date);
        System.out.printf("%s %tB %<te, %<tY %n", "Ngày hiện tại: ", date);
        System.out.printf("%1$td.%1$tm.%1$ty %n", date);
        System.out.printf("%s %tb %<te, %<ty", "Ngày hiện tại: ", date);
    }
}
