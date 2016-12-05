package com.fx.Map;

import com.fx.Tools.AdjacencyChangeTool;
import com.fx.Tools.MapCreatTool;
import com.fx.Tools.StringChangeTool;
import com.fx.Tools.XMLAnalyzeTool;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class Map {
    private static Map mMap = new Map();
    private String[][] RFIDMap;//记录RFID坐标
    private int[][] Map;//记录地图环形图
    private int[][] AdjacencyMap;//记录地图临界矩阵
    private int[][] WayConditionLogger;//路径计数器
    private java.util.Map<Integer, String> MapNodeCondition;//路径节点占用
    private int width=0;//地图宽度
    private int height=0;//地图长度

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Map() {
        try {
            init();
        } catch (JDOMException e) {
            e.printStackTrace();
            mMap=null;
        } catch (IOException e) {
            e.printStackTrace();
            mMap=null;
        }
    }

    public static Map getInstance() {
        return mMap;
    }

    private void init() throws JDOMException, IOException {
        List<MapDate> list = XMLAnalyzeTool.MapXMLAnalyze("./src/pro.txt");
        RFIDMap = MapCreatTool.creatArray(list);
        Map = StringChangeTool.stringToInteger(RFIDMap);
        AdjacencyMap = AdjacencyChangeTool.changeByLocationArray(Map);
        WayConditionLogger = new int[AdjacencyMap.length][AdjacencyMap.length];
        MapNodeCondition = new HashMap<Integer, String>();
        for (int i = 0; i <AdjacencyMap.length; i++) {
            MapNodeCondition.put(i,"0");
        }
        width=RFIDMap[0].length;
        height=RFIDMap.length;
    }

    public String[][] getRFIDMap() {
        return RFIDMap;
    }

    public int[][] getMap() {
        return Map;
    }

    public int[][] getAdjacencyMap() {
        return AdjacencyMap;
    }

    public int[][] getWayConditionLogger() {
        return WayConditionLogger;
    }

    public java.util.Map<Integer, String> getMapNodeCondition() {
        return MapNodeCondition;
    }


    public void printMap(){//打印地图
        System.out.println("RFID地图");
        for (int i = 0; i < RFIDMap.length; i++) {
            for (int j = 0; j < RFIDMap[0].length; j++) {
                System.out.print(RFIDMap[i][j]+"\t");

            }
            System.out.println(" ");

        }

        System.out.println("Map地图");
        for (int i = 0; i < Map.length; i++) {
            for (int j = 0; j < Map[0].length; j++) {
                System.out.print(Map[i][j]+"\t");
            }
            System.out.println(" ");

        }
    }


    public static void main(String[] args) {
        Map map = getInstance();
    }


}
