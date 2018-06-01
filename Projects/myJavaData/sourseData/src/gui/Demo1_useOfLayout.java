/*
 * 多种布局管理器的使用1
 * 使用了流式布局和边缘布局，面板JPanel的jp1中添加了JButton的jb1，jb2；
 * jpane2中添加了JButton的jb3，jb4，jb5；
 * jpane1放到JFrame的NORTH位置
 * jpane2放到JFrame的SOUTH位置
 * JFrame的CENTER位置添加了JButton的jb0
 */
package gui;
import java.awt.*;
import javax.swing.*;

public class Demo1_useOfLayout extends JFrame
{

	//定义组件
	JPanel jpane1,jpane2;
	JButton jbutton1,jbutton2,jbutton3,jbutton4,jbutton5,jbutton0;//把JButton jb0放到中间
	
	
	//构造函数
	public Demo1_useOfLayout()
	{
		//创建组件
		//JPanel的默认布局是FlowLayout流式布局
		jpane1=new JPanel();
		jpane2=new JPanel();
		
		jbutton1=new JButton("1");
		jbutton2=new JButton("2");
		jbutton3=new JButton("3");
		jbutton4=new JButton("4");
		jbutton5=new JButton("5");
		jbutton0=new JButton("center");
		
		//设置布局
		
		//往面板中添加组件
		jpane1.add(jbutton1);
		jpane1.add(jbutton2);
		jpane2.add(jbutton3);
		jpane2.add(jbutton4);
		jpane2.add(jbutton5);
		
		//把Panel加入JFrame
		this.add(jpane1,BorderLayout.NORTH);//面板1加到JFrame的北部
		this.add(jbutton0,BorderLayout.CENTER);//JButton按钮jb0加到JFrame的中部
		this.add(jpane2,BorderLayout.SOUTH);//面板2加到JFrame的南部
		
		//设置窗口的属性
		this.setTitle("布局管理器的综合使用");
		this.setSize(400,400);
		this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_useOfLayout demo=new Demo1_useOfLayout();

	}

}
