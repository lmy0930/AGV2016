package com.fx.WorkTask;

import com.fx.Object.AGVCar;

import java.io.IOException;
import java.io.OutputStream;

public class TskOBJ implements IWorkTSK{
	@Override
	public void execute(AGVCar car, String tskContain, OutputStream out) throws IOException {
//		AGVcarlist list= AGVcarlist.getInstance();
//		Map map= Map.getInstance();
//		synchronized (list){
//			synchronized (map){
//				int index=-1;
//				if((index=list.indexofCar(tskContain))>=0){
//					car.setCondition(list.getCar(index).getCondition());
//					car.setTSKlist(list.getCar(index).getTSKlist());
//					car.setTSKpath(list.getCar(index).getTSKpath());
//					car.setID(tskContain);
//					car.setOut(out);
//					car.setLocation(list.getCar(index).getLocation());
//					list.replaceCar(index,car);
//				}
//				else{
//					List<Integer> list1=new ArrayList<>();
//					list1.add(LocSelectTool.getLocNum("0029",map.getRFIDMap()));
//					car.setID(tskContain);//设置ID
//					car.setCondition("rk");
//					car.setLocation(LocSelectTool.getLocNum("0029",map.getRFIDMap()));
//					car.setOut(out);
//					car.setTSKlist(list1);
//					car.setTSKpath("0029ps");
//					list.addCar(car);
//				}
//			}
//		}
	}
}
