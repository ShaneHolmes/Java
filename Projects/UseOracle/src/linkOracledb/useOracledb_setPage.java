/*
 * 使用oracle对表进行分页查询
 */
package linkOracledb;
import java.sql.*;

public class useOracledb_setPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    String url="jdbc:oracle:thin:@localhost:1521:XE";
		    String userName="hr";
		    String userPass="123456";
		    Connection ct=DriverManager.getConnection(url,userName,userPass);
		    Statement sm=ct.createStatement();
		    
		    //分页的信息
		    int pageCount=0;//页面数
		    int rowCount=0;//行记录总数
		    int pageSize=3;//每个页面显示的记录条数
		    
		    ResultSet rs=sm.executeQuery("select count(*) from employees");//取出总的记录条数
		    
		    //计算
		    if(rs.next())
		    {
		    	rowCount=rs.getInt(1);
		    	if(rowCount%pageSize==0) {
		    		pageCount=rowCount/pageSize;
		    	}else {
		    		pageCount=rowCount/pageSize+1;
		    	}
		    }
		    
		    rs=sm.executeQuery
		    		("select * from (select aaa.*,rownum rn from (select employee_id,first_name,salary,manager_id,department_id from employees where department_id=60) aaa where rownum<=3) where rn>=1"); 
		    while(rs.next()) {
		    	System.out.println("<tr>");
		    	System.out.println("<td>"+rs.getInt(1)+"</td>");
		    	System.out.println("<td>"+rs.getString(2)+"</td>");
		    	System.out.println("<td>"+rs.getInt(3)+"</td>");
		    	System.out.println("<td>"+rs.getInt(4)+"</td>");
		    	System.out.println("<td>"+rs.getInt(5)+"</td>");
		    	System.out.println("</tr>");
		    	
		    	
		    }
		    for(int i=1;i<=pageCount;i++) {
		    	System.out.println("");
		    }
		    
		    rs.close();
		    sm.close();
		    ct.close();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
