package com.yan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yanwenbo on 2017-09-28.
 */
public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date format(String time) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
            date = simpleDateFormat.parse(time);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }

}
