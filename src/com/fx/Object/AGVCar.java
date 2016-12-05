package com.fx.Object;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class AGVCar {
    private String ID;//小车ID
    private int Location;//小车位置
    private List<Integer> TSKlist;//工作路径(节点)
    private String TSK;//工作路径(字符串)
    private String Condition;//返回/运货/在库/等候   bk/fw/rk/wt
    private OutputStream out;
    private long UpdateTime;
    private String Goods;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int location) {
        Location = location;
    }

    public List<Integer> getTSKlist() {
        return TSKlist;
    }

    public void setTSKlist(List<Integer> TSKlist) {
        this.TSKlist = TSKlist;
    }

    public String getTSK() {
        return TSK;
    }

    public void setTSK(String TSK) {
        this.TSK = TSK;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public long getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        UpdateTime = updateTime;
    }

    public String getGoods() {
        return Goods;
    }

    public void setGoods(String goods) {
        Goods = goods;
    }
}
