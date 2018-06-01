/*
 * 事件监听器
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//引入对事件进行处理的包
public class Demo1_ActionListener extends JFrame implements ActionListener{

	//定义一个MyPanel
	JPanel mypanel;
	
	//声明组件
	JButton jbutton1,jbutton2;
	
	//构造函数
	public Demo1_ActionListener()
	{
		//创建组件
		mypanel=new JPanel();
		jbutton1=new JButton("蓝色");//jbutton1,2作为事件源对象
		jbutton2=new JButton("红色");
		
		//添加组件及设置布局
		this.add(jbutton1,BorderLayout.NORTH);
		mypanel.setBackground(Color.BLACK);
		this.add(mypanel,BorderLayout.CENTER);//中间为默认,可以不写布局方式
		this.add(jbutton2, BorderLayout.SOUTH);
		
		/*
		 * 注册监听
		 */
		jbutton1.addActionListener(this);//jbutton1是事件源，让当前对象this去监听
		//创建Cat类的一个对象，让它也去监听
		Cat cat=new Cat();
		jbutton1.addActionListener(cat);//jbutton1是事件源，让实例对象cat去监听，
		/*
		 * 一个事件源可以被多个监听者监听，如果这个事件发生了，那么所有的监听者都会对此作出相应的反应
		 */
		//指定action命令，监听者监听多个事件源，通过指定action命令的方法，将是哪个事件源的事件发生传递给监听者，监听者以此做出相应的反应
		jbutton1.setActionCommand("蓝色");
		jbutton2.addActionListener(this);//jbutton2没有注册cat的监听者，所以当按下红色按钮时，猫猫不知道
		jbutton2.setActionCommand("红色");
		
		
		//设置窗体属性
		this.setTitle("ActionListener");
		this.setSize(400,200);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		Demo1_ActionListener demo=new Demo1_ActionListener();
	}

	
	
	
	@Override//对事件处理的方法，接受事件源的事件发生指令之后，对相应的事件源做出响应
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪一个按钮
		if(e.getActionCommand().equals("蓝色"))//点下蓝色的按钮
		{
			System.out.println("你点击了蓝色按钮");
			mypanel.setBackground(Color.BLUE);
		}else if(e.getActionCommand().equals("红色"))
		{
			System.out.println("你点击了红色按钮");
			mypanel.setBackground(Color.red);
		}else
		{
			System.out.println("none");
		}
	}
}

class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("蓝色"))//点下蓝色的按钮
		{
			System.out.println("猫猫也知道你点击了蓝色按钮");
		}else if(e.getActionCommand().equals("红色"))
		{
			System.out.println("猫猫也知道你点击了红色按钮");
		}else
		{
			System.out.println("none");
		}
	}
	
}
