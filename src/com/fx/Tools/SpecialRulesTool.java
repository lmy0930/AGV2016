package com.fx.Tools;

import com.fx.Map.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class SpecialRulesTool {//添加特殊路径规则

    public static void addWayRules(List<String> rlist, Map map) {
        List<Integer> list = new ArrayList<>();
        for (String rfid : rlist) {
            int num = LocSelectTool.getLocNum(rfid, map.getRFIDMap());
            list.add(num);

        }
        for (int i = 0; i < list.size() - 1; i++) {
            map.getAdjacencyMap()[list.get(i)][list.get(i + 1)] = 1;
            map.getAdjacencyMap()[list.get(i + 1)][list.get(i)] = AdjacencyChangeTool.MAXVALUE;
            map.getWayConditionLogger()[list.get(i + 1)][list.get(i)] += 1;
        }

    }
}
