package uz.micros.estore.util;

import org.joda.time.DateTime;

import java.util.Date;

public class DateFormatter {
    private static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public String getCurrentDate() {
        return new DateTime(new Date()).toString(FULL_FORMAT);
    }

    public String getPostDate(DateTime date) {
        return new DateTime(date).toString(DATE_FORMAT);
    }
}