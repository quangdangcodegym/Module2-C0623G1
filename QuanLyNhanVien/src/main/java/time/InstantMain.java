package time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class InstantMain {
    public static void main(String[] args) {


        /**
        Instant currentInstant = Instant.now();
        Instant s1 = Instant.ofEpochMilli(24*60*60*1000);
//        System.out.println("Thời điểm hiện tại: " + currentInstant.getEpochSecond());
        System.out.println("Năm 1970: " + s1);


         **/

        String strDate = "20-10-2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Instant instant = Instant.from(formatter.parse(strDate));
        System.out.println(instant);


        Date date = new Date();


    }
}
