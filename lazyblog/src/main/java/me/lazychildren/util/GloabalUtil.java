package me.lazychildren.util;


import java.text.SimpleDateFormat;
import java.util.Date;


public class GloabalUtil {
    public static Integer PAGE_SIZE = 7;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final Boolean USER_LOGIN = true;
    public static final Boolean USER_LOGOFF = false;
    public static String getTime()
    {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

}
