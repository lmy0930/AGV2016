package com.fx.Tools;

/**
 * Created by Shinelon on 2016/11/28.
 */
public class AdjacencyChangeTool {
    public static final int MAXVALUE = 100;//极大值代表障碍物

    public static int[][] changeByLocationArray(int[][] locarray) {//把位置矩阵转换成进阶矩阵
        int width = locarray[0].length;
        int height = locarray.length;
        int nodecount = width * height;
        int[][] AdjacencyArray = new int[nodecount][nodecount];
        for (int i = 0; i < nodecount; i++)
            for (int j = 0; j < nodecount; j++) {
                if (i == j) {
                    AdjacencyArray[i][j] = 0;
                } else {
                    int x1 = i / width;
                    int y1 = i % width;
                    int x2 = j / width;
                    int y2 = j % width;
                    if (locarray[x1][y1] != 1 || locarray[x2][y2] != 1) {
                        AdjacencyArray[i][j] = MAXVALUE;
                    } else {
                        if ((x1 == x2 && (y1 == y2 + 1 || y1 == y2 - 1)) || (y1 == y2 && (x1 == x2 + 1 || x1 == x2 - 1))) {
                            AdjacencyArray[i][j] = 1;
                        } else {
                            AdjacencyArray[i][j] = MAXVALUE;
                        }
                    }
                }

            }
        return AdjacencyArray;

    }

}
