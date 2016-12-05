package com.fx.DBDao;

import java.sql.*;

public class TaskDBHelper extends BaseDBHelper {

	public Task findTask() {
		Connection conn = null;
		Task task=new Task();
		try {
			conn = getConnection();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
			return null;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		String sql = "SELECT * from Task WHERE `Condition`='1' LIMIT 1";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                task.setTRSN(rs.getString("TRSN"));
				task.setAimLoc(rs.getString("Task"));
			}
			rs.close();
			ps.close();
			conn.close();
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void changeCondition(String TRSN,String Contion) {
		Connection conn = null;
		try {
			conn = getConnection();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			Statement ps = conn.createStatement();
			String sql = "UPDATE Task SET `Condition` = '"+Contion+"' WHERE TRSN = '"+TRSN+ "' ";
			ps.executeUpdate(sql);
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTask(String Task) {
		Connection conn = null;
		try {
			conn = getConnection();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			Statement ps = conn.createStatement();
			String sql = "DELETE FROM task WHERE Task='" + Task + "'";
			ps.executeUpdate(sql);
			ps.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
