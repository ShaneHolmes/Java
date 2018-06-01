/*
 * swing组件:
 *         下拉框组件(JComboBox)
 *         列表框组件(JList)
 *         滚动窗格组件(JScrollPane)
 */

package gui;

import java.awt.*;
import javax.swing.*;

public class Demo4_swingComponent extends JFrame
{
	//定义组件
	JPanel jpanel1,jpanel2;
	JLabel jlabel1,jlabel2;
	JComboBox jcombobox;//下拉框组件
	JList jlist;//列表框组件
	JScrollPane jscrollpane;
	
	//构造函数
	public  Demo4_swingComponent()
	{
		//创建组件
		jpanel1=new JPanel();
		jpanel2=new JPanel();
		
		jlabel1=new JLabel("喜欢的运动");
		jlabel2=new JLabel("喜欢的明星");
		
		//用字符串数组定义要在下拉框组件中显示的元素
		String []string1={"篮球","足球","羽毛球","乒乓球","网球","跆拳道","冲浪"};
		jcombobox=new JComboBox(string1);//然后直接把string作为参数传递到JComboBox中即可将这些元素放入下拉框组件中		
	    
		//用字符串数组定义要在列表框组件中显示的元素
		String []string2={"鹿晗","科比","林心如","金秀贤","爱因斯坦","C罗","习近平"};
		jlist=new JList(string2);//然后直接把string作为参数传递到JList中即可将这些元素放入列表框组件中		
	    
		//在JList中，如果不加JScrollPane，他会把内容全部显示出来
		//在JList中希望有滑动选项，应进行下面的设置
		jlist.setVisibleRowCount(1);//设置初始显示的行数为1
		jscrollpane=new JScrollPane(jlist);//吧jlist作为参数传递到JScrollPane中
		
		
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));//网格布局
		
		
		
		//添加组件
		jpanel1.add(jlabel1);
		jpanel1.add(jcombobox);
		
		jpanel2.add(jlabel2);
		jpanel2.add(jscrollpane);//添加的是滚动窗格
		
		
		
		//把2个面板Panel加入JFrame,前面已设置为网格布局，按顺序添加面板
		this.add(jpanel1);
		this.add(jpanel2);
		
		
		//设置窗体属性
		this.setTitle("swingcomponent");
		this.setResizable(false);
		this.setSize(400,400);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Demo4_swingComponent demo=new Demo4_swingComponent();
	}

}
