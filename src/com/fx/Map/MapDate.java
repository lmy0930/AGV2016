package com.fx.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class MapDate {
    private List<String> Yarray=new ArrayList<String>();

    public List<String> getYarray() {
        return Yarray;
    }

    public void addEle(String ele) {
        Yarray.add(ele);
    }
}
