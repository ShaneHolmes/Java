package com.mhl.model;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;

import com.mhl.db.*;
public class EmpModel extends AbstractTableModel {
	Vector Column;
	Vector Row;
	public  void empQuery(String sql,String[] paras) {
		sqlHelper sh = new sqlHelper();
		ResultSet rs = sh.Query(sql, paras);
		Column = new Vector();
		Row = new Vector();
	
		//此方法便 于扩展
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++) {
				Column.add(rsmd.getColumnName(i+1));
			}
			while(rs.next()) {
				Vector temp = new Vector();
				for(int i=0;i<rsmd.getColumnCount();i++) {
					temp.add(rs.getString(i+1));
				}
				Row.add(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)Column.get(column);
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Column.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Row.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)Row.get(rowIndex)).get(columnIndex);
	}

}
