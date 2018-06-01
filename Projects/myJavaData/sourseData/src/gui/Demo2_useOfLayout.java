/*
       利用网格布局，设置三行一列的网格
      用户名(标签JLabel)    文本框JTextField
 *密码(标签JLabel)     密码框JPasswordField
 *登录(按钮JButton)    取消(按钮JButton)
 *
 *定义三个JPanel
 *第一列放第一个JPanel  jpanel1，其中面板jpanel1放入用户名(标签JLabel)，文本框JTextField，默认流式布局
 *第二列放第二个JPanel  jpanel2，其中面板jp2放入密码(标签JLabel)，密码框JPasswordField，默认流式布局
 *第三列放第三个JPanel  jpanel3，其中面板jp登录(按钮JButton)，取消(按钮JButton)，默认流式布局
 */
package gui;

import java.awt.*;
import javax.swing.*;

public class Demo2_useOfLayout extends JFrame
{

	//定义组件
	JPanel jpanel1,jpanel2,jpanel3;
	JButton jbutton1,jbutton2;
	JLabel jlabel1,jlabel2;
	JTextField jtextfeild1;
	JPasswordField jpasswordfield1;
	
	//构造函数
	public Demo2_useOfLayout()
	{
		//创建组件
		jpanel1=new JPanel();
		jpanel2=new JPanel();
		jpanel3=new JPanel();
		
		jbutton1=new JButton("登录");
		jbutton2=new JButton("取消");
				
		
		jlabel1=new JLabel("用户名");
		jlabel2=new JLabel("密码    ");
		
		jtextfeild1=new JTextField(10);
		jpasswordfield1=new JPasswordField(10);
		
		
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));//三行一列
		
		//往面板中添加组件
		jpanel1.add(jlabel1);
		jpanel1.add(jtextfeild1);
		
		jpanel2.add(jlabel2);
		jpanel2.add(jpasswordfield1);
		
		jpanel3.add(jbutton1);
		jpanel3.add(jbutton2);
		
		//把3个Panel加入JFrame,前面已设置为网格布局，按顺序添加面板
		this.add(jpanel1);
		this.add(jpanel2);
		this.add(jpanel3);
		
		//设置窗口的属性
		this.setTitle("布局管理器的综合使用");
		this.setSize(300,150);
		this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2_useOfLayout demo=new Demo2_useOfLayout();

	}

}
