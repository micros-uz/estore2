package uz.micros.estore.util;

import org.joda.time.DateTime;

import java.util.Date;

public class DateFormatter {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public String getCurrentDate() {
        return new DateTime(new Date()).toString(DATE_FORMAT);
    }
}