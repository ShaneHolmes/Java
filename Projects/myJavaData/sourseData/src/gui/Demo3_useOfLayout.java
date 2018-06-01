/*
利用网格布局，设置三行一列的网格
你喜欢的运动(标签JLabel)  足球  篮球 网球  (复选框组件JCheckBox)可多选
*你的性别(标签JLabel)     男 女(单选框按钮JRadioButton)只能点中一个
*注册用户(按钮JButton)    取消(按钮JButton)
*
*定义三个JPanel
*第一列放第一个JPanel  jpanel1，其中面板jp1放入你喜欢的运动(标签JLabel)  足球  篮球 网球  (复选框组件JCheckBox)，默认流式布局
*第二列放第二个JPanel  jpanel2，其中面板jp2放入你的性别(标签JLabel)     男 女(单选框按钮JRadioButton)，默认流式布局
*第三列放第三个JPanel  jpanel3，其中面板jp3注册用户(按钮JButton)    取消(按钮JButton)，默认流式布局
*/



package gui;

import java.awt.*;
import javax.swing.*;

public class Demo3_useOfLayout extends JFrame
{
	

     //定义组件
     JPanel jpanel1,jpanel2,jpanel3;
     JButton jbutton1,jbutton2;
     JLabel jlabel1,jlabel2;
     JCheckBox jcheckbox1,jcheckbox2,jcheckbox3;
     JRadioButton jradiobutton1,jradiobutton2;

//构造函数
   public Demo3_useOfLayout()
   {
	//创建组件
	jpanel1=new JPanel();
	jpanel2=new JPanel();
	jpanel3=new JPanel();
	
	jbutton1=new JButton("注册用户");
	jbutton2=new JButton("取消");
			
	
	jlabel1=new JLabel("你喜欢的运动");
	jlabel2=new JLabel("你的性别    ");
	
	jcheckbox1=new JCheckBox("篮球");//复选框
	jcheckbox2=new JCheckBox("足球");
	jcheckbox3=new JCheckBox("网球");
	
	jradiobutton1=new JRadioButton("男");
	jradiobutton2=new JRadioButton("女");//单选按钮
	
	//将单选按钮jrb1,jrb2放入一个ButtonGroup中管理
	ButtonGroup bg=new ButtonGroup();
	bg.add(jradiobutton1);
	bg.add(jradiobutton2);
	
	//设置布局管理器
	this.setLayout(new GridLayout(3,1));//三行一列
	
	//往面板中添加组件
	jpanel1.add(jlabel1);//第一个面板
	jpanel1.add(jcheckbox1);
	jpanel1.add(jcheckbox2);
	jpanel1.add(jcheckbox3);
	
	jpanel2.add(jlabel2);//第二个面板
	jpanel2.add(jradiobutton1);
	jpanel2.add(jradiobutton2);
	
	jpanel3.add(jbutton1);//第三个面板
	jpanel3.add(jbutton2);
	
	//把3个面板Panel加入JFrame,前面已设置为网格布局，按顺序添加面板
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
	Demo3_useOfLayout demo=new Demo3_useOfLayout();

}

}
