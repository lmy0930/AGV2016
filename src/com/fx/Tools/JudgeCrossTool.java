package com.fx.Tools;

/**
 * Created by Shinelon on 2016/11/30.
 */
public class JudgeCrossTool {//十字路口判定

    public static boolean isCross(int[][] map, int x, int y) {//判定十字路口
        int count = 0;
        if (map[x][y] == 0) {
            return false;
        }
        if (x == 0) {
            if (y == 0) {
                return false;
            } else if (y == map[0].length - 1) {
                return false;
            } else {
                if (map[x][y + 1] == 1)
                    count++;
                if (map[x][y - 1] == 1)
                    count++;
                if (map[x + 1][y] == 1)
                    count++;
                if (count > 2) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if (x == map.length - 1) {
            if (y == 0) {
                return false;
            } else if (y == map[0].length - 1) {
                return false;
            } else {
                if (map[x][y + 1] == 1)
                    count++;
                if (map[x][y - 1] == 1)
                    count++;
                if (map[x - 1][y] == 1)
                    count++;
                if (count > 2) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (y == 0) {
                if (map[x][y + 1] == 1)
                    count++;
                if (map[x - 1][y] == 1)
                    count++;
                if (map[x + 1][y] == 1)
                    count++;
                if (count > 2) {
                    return true;
                } else {
                    return false;
                }
            } else if (y == map[0].length - 1) {
                if (map[x][y - 1] == 1)
                    count++;
                if (map[x - 1][y] == 1)
                    count++;
                if (map[x + 1][y] == 1)
                    count++;
                if (count > 2) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (map[x][y + 1] == 1)
                    count++;
                if (map[x][y - 1] == 1)
                    count++;
                if (map[x - 1][y] == 1)
                    count++;
                if (map[x + 1][y] == 1)
                    count++;
                if (count > 2) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
