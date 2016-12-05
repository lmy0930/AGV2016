package com.fx.DBDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDBHelper {
    ;
    protected String drive_class="com.mysql.jdbc.Driver";
    protected String url="jdbc:mysql://localhost:3306/dbtask";
    protected String username="root";
    protected String pwd="123456";

    public BaseDBHelper() {
    }


    public Connection getConnection() throws CloneNotSupportedException, SQLException {
        Connection conn = null;
        try {
            Class.forName(drive_class);
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    public static void main(String[] args) {
        BaseDBHelper db=new BaseDBHelper();
    }


}
