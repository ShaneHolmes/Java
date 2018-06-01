/*
 * 使用jdbc方式连接Oracle,
 */
package linkOracledb;
import java.sql.*;

public class LinkOracledb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//连接时可能会出现异常，用try catch语句
		try {
			//第一步：加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//第二步：得到连接
			//路径
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			//用户名
			String userName="hr";
			//密码
			String userPass="123456";
			Connection ct=DriverManager.getConnection(url,userName,userPass);
			//第三步：数据库语句
			Statement sm=ct.createStatement();
			//得到结果集
			ResultSet rs=sm.executeQuery("select * from employees where employee_id=100");
			//相关操作
			while(rs.next()) {
				System.out.println("userId :"+rs.getString(1));//参数1代表第一个字段
			}
			//使用完成之后需要将按照后开先关的顺序依次关闭
			rs.close();
			sm.close();
			ct.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally
		{
			
		}

	}

}
