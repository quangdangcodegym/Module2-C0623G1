package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateMain {

    public static void main(String[] args) {
        String strDate = "12/10/2023";      // parse String => localDate

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        LocalDate date = LocalDate.now();

        LocalDate date = LocalDate.parse(strDate, formatter);
        LocalDate d1 = date.plusDays(5);
        System.out.println(date);


        System.out.println("Local date format: " + formatter.format(d1));
    }
}
