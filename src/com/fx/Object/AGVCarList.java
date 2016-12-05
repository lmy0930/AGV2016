package com.fx.Object;

import com.fx.Tools.LogUtilsTool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class AGVCarList {
    private Map<String, AGVCar> list = new HashMap<String, AGVCar>();
    private static AGVCarList agvlist = new AGVCarList();

    private AGVCarList() {
    }

    public static AGVCarList getInstance() {
        return agvlist;
    }

    public void addCar(AGVCar car) {//添加小车
        list.put(car.getID(), car);
        LogUtilsTool.Log("添加小车" + car.getID() + "，当前小车数量：" + agvlist.getsize());
    }

    public void removeCar(String ID) {//移除小车
        list.remove(ID);
        LogUtilsTool.Log("移除小车" + ID + "，当前小车数量：" + agvlist.getsize());
    }

    public void updateCar(AGVCar car) {//更新小车
        list.put(car.getID(), car);
        LogUtilsTool.Log("更新小车" + car.getID());
    }


    public AGVCar getCar(String ID) {
        return list.get(ID);
    }

    public int getsize() {
        return list.size();
    }
}
