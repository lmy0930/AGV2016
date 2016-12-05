package com.fx.Tools;

import com.fx.Map.MapDate;

import java.util.List;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class MapCreatTool {
    public static String[][] creatArray(List<MapDate> list) {//生成RFID矩阵
        String[][] Map = new String[list.size()][list.get(0).getYarray().size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).getYarray().size(); j++) {
                Map[i][j] = list.get(i).getYarray().get(j);
            }
        }
        return Map;
    }
}
