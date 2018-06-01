package com.mhl.model;
import java.sql.*;

import com.mhl.db.*;
public class UserModel {
	String zhiwei="";
	public String CheckUser(String userid,String passwd) {
		
		
		String sql = "select rszl.zhiwei from login,rszl where login.empid=rszl.empid and login.empid=? and passwd=?";
		String[] paras = {userid,passwd};
		sqlHelper sh = new sqlHelper();
		ResultSet rs = sh.Query(sql, paras);
		
	    try {
			if(rs.next())
				zhiwei=rs.getString(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh.close();
		return zhiwei;
	}
	
}
