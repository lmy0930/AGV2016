package com.fx.Tools;

/**
 * Created by Shinelon on 2016/11/30.
 */
public class LocSelectTool {//定位RFID在矩阵中的位置

    public static int getLocNum(String RFID, String[][] RFIDarray) {
        for (int i = 0; i < RFIDarray.length; i++) {
            for (int j = 0; j < RFIDarray[0].length; j++) {
                if (RFIDarray[i][j].equals(RFID)) {
                    return i * (RFIDarray[0].length) + j;
                }
            }
        }
        return -1;
    }


    public static String getLocRFID(int num, String[][] RFIDarray) {//根据位置返回RFID
        int x = num / RFIDarray[0].length;
        int y = num % RFIDarray[0].length;
        return RFIDarray[x][y];
    }
}
