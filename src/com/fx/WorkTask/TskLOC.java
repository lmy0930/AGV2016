package com.fx.WorkTask;

import com.fx.Object.AGVCar;

import java.io.IOException;
import java.io.OutputStream;


public class TskLOC implements IWorkTSK {
	@Override
	public void execute(AGVCar car, String tskContain, OutputStream out) throws IOException {
//		AGVcarlist list= AGVcarlist.getInstance();
//		Map map= Map.getInstance();
//		synchronized (list){
//			synchronized (map){
//				DijkstraUpdate dijupdate=new DijkstraUpdate();
//				int node= LocSelectTool.getLocNum(tskContain,map.getRFIDMap());
//				if(car.getTSKlist().get(0)==node){
//					dijupdate.LocUpdate(node,node);
//					car.setLocation(node);
//				}
//				else
//				{
//					int index=car.getTSKlist().indexOf(node);
//					if(index>=0){
//						dijupdate.LocUpdate(index-1,index);
//						car.setLocation(index);
//					}
//				}
//			}
//		}
	}
}
