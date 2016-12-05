package com.fx.WorkThread;


import com.fx.DBDao.TaskDBHelper;
import com.fx.DBDao.Task;
import com.fx.Map.Map;
import com.fx.Object.AGVCarList;
import com.fx.Object.AGVcarlist;
import com.fx.Tools.LocSelectTool;


import java.util.List;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class WorkThreadDB extends Thread {
    @Override
    public void run() {
        super.run();
        Map map = Map.getInstance();
        AGVCarList list = AGVCarList.getInstance();
        while (true) {
            TaskDBHelper mdh = new TaskDBHelper();
            Task task = mdh.findTask();
            if (task != null) {
                synchronized (list) {
                    synchronized (map) {
                        if (list.getsize() > 0) {
                            DijkstraWayConstructor dijwc = new DijkstraWayConstructor();
                            for (int i = 0; i < list.getsize(); i++) {
                                if (list.getCar(i).getCondition().equals("wt")) {
                                    int node = LocSelectTool.getLocNum(task, map.getRFIDMap());
                                    List<Integer> templist = dijwc.creatWay(list.getCar(i).getLocation(), node);
                                    if (templist != null) {
                                        dijwc.logWayPath(templist);
                                        list.getCar(i).setTSKlist(templist);
                                        list.getCar(i).setTSKpath(dijwc.creatWayPath(templist));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
