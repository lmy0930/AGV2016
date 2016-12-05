package com.fx.WorkThread;

import com.fx.Object.AGVCar;
import com.fx.WorkTask.IWorkTSK;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Shinelon on 2016/11/30.
 */
public class WorkThreadLogic extends Thread {//业务流程
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private byte[] buff = new byte[1024];
    private String rxStr = "";
    private String msg = "";
    private AGVCar car = new AGVCar();

    public WorkThreadLogic(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        super.run();
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            while (true) {

                int rxlen = in.read(buff, 0, 200);
                if (rxlen != -1) {
                    String temp = new String(buff, 0, rxlen);
                    temp = temp.trim();
                    // Log.d("接收到数据："+temp);
                    rxStr += temp;
                    // 数据处理
                    while (processData()) {
                        String TskFlag = msg.substring(0, 3);
                        String TskContain = msg.substring(3);
                        StringBuilder ClassName = new StringBuilder();
                        ClassName.append("com.fx.WorkTask.Tsk");
                        ClassName.append(TskFlag);
                        IWorkTSK iwork = null;
                        try {
                            iwork = (IWorkTSK) Class.forName(ClassName.toString()).newInstance();
                        } catch (Exception e) {
                            iwork = null;
                            System.out.println("无效指令");
                        }
                        if (iwork != null) {
                            iwork.execute(car, TskContain, out);//提交事务
                        }
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("error IO");
            System.out.println("连接中断");

        } catch (Exception e) {
            System.out.println("error E");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error E");
            }
        }
    }

    private String getOneCmd() {//取一条命令
        String temp = "";
        temp = rxStr.substring(rxStr.indexOf('*') + 1, rxStr.indexOf('#'));
        rxStr = rxStr.substring(rxStr.indexOf('#') + 1);
        temp.lastIndexOf('*');
        temp = temp.substring(temp.lastIndexOf('*') + 1);
        return temp;
    }

    private boolean processData() {//解拆包
        String temp = "";
        if (rxStr.equalsIgnoreCase("")) {
            return false;
        }
        if (!rxStr.contains("*")) {
            rxStr = "";
        } else if (!rxStr.contains("#")) {
            return false;
        } else {
            if (rxStr.indexOf("*") > rxStr.indexOf("#")) {
                rxStr = rxStr.substring(rxStr.indexOf("*"));
                return false;
            }
            temp = getOneCmd();
            if (!temp.equals("")) {
                System.out.println("执行一次任务：" + temp);
                msg = temp;
                temp = "";
                return true;
            }
            return false;
        }
        return false;
    }

}
