package com.fx.Tools;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class StringChangeTool {
    public static int[][] stringToInteger(String[][] arrary) {//把RFID矩阵转换成路径矩阵
        int x = arrary.length;
        int y = arrary[0].length;
        int[][] marray = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!arrary[i][j].equals("NULL")) {
                    marray[i][j] = 1;
                } else {
                    marray[i][j] = 0;
                }
            }
        }
        return marray;
    }
}
