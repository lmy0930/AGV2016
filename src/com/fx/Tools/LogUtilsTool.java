package com.fx.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class LogUtilsTool {//日志记录工具

    public static void Log(String info) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + ":" + info);
    }
}
