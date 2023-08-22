package com.cg.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static LocalDate parseDate(String strDate) {
        try {
            return LocalDate.parse(strDate, dateTimeFormatter);
        } catch (DateTimeParseException dateTimeParseException) {
            dateTimeParseException.printStackTrace();
        }
        return null;
    }

    public static String formatDate(LocalDate localDate) {
        try{
            return dateTimeFormatter.format(localDate);
        }catch (DateTimeParseException dateTimeParseException) {
            dateTimeParseException.printStackTrace();
        }
        return null;
    }

}
