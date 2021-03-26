package com.devcenter.apptest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime toLocalDateTime(String dateTime){
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static String toString(LocalDateTime dateTime){
        return dateTime.format(formatter);
    }

}
