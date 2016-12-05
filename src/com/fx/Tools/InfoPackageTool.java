package com.fx.Tools;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class InfoPackageTool {
    public String packageInfo(String info) {//网络数据打包
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        sb.append(info);
        sb.append("#");
        return sb.toString();
    }
}
