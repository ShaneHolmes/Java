package com.mhl.db;
import java.sql.*;

public class sqlHelper {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void Driver() {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=restaurant","sa","sa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet Query(String sql,String[] paras) {
		this.Driver();
		try {
			ps = con.prepareStatement(sql);
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
