package com.fx.WorkTask;


import com.fx.Map.Map;
import com.fx.Object.AGVCar;
import com.fx.Object.AGVcarlist;
import com.fx.Tools.LocSelectTool;

import java.io.IOException;
import java.io.OutputStream;

public class TskTRA implements IWorkTSK {
	@Override
	public void execute(AGVCar car, String tskContain, OutputStream out) throws IOException {
		AGVcarlist list= AGVcarlist.getInstance();
		Map map= Map.getInstance();
		synchronized (list){
			synchronized (map){
				//DijkstraConflictSolver dijcs=new DijkstraConflictSolver();
				int node= LocSelectTool.getLocNum(tskContain,map.getRFIDMap());
				int index=car.getTSKlist().indexOf(node);
				if(index>0){
//					if (dijcs.doCollisionTest(index-1)){
//						LogUtilsTool.Log("node:"+(index-1)+"可通行");
//					}
//					else{
//						LogUtilsTool.Log("node:"+(index-1)+"不可通行");
//					}
				}
			}
		}
	}
}
