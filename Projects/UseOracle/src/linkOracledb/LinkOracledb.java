/*
 * ʹ��jdbc��ʽ����Oracle,
 */
package linkOracledb;
import java.sql.*;

public class LinkOracledb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����ʱ���ܻ�����쳣����try catch���
		try {
			//��һ������������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�ڶ������õ�����
			//·��
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			//�û���
			String userName="hr";
			//����
			String userPass="123456";
			Connection ct=DriverManager.getConnection(url,userName,userPass);
			//�����������ݿ����
			Statement sm=ct.createStatement();
			//�õ������
			ResultSet rs=sm.executeQuery("select * from employees where employee_id=100");
			//��ز���
			while(rs.next()) {
				System.out.println("userId :"+rs.getString(1));//����1�����һ���ֶ�
			}
			//ʹ�����֮����Ҫ�����պ��ȹص�˳�����ιر�
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
