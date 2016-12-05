package com.fx.WorkTask;


import com.fx.Object.AGVCar;

import java.io.IOException;
import java.io.OutputStream;

public interface IWorkTSK {
   public void execute(AGVCar car, String tskContain, OutputStream out) throws IOException;
}
