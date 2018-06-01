/*
 * 使用列表框组件
 * 拆分窗格：JSplitPane(属于容器类组件，在javax.swing.*中)
 */

package gui;
import java.awt.*;
import javax.swing.*;
public class Demo5_swingJSplitPane extends JFrame {

	//定义组件
	JList jlist;//声明列表框组件
	JLabel jlabel;//标签
	JSplitPane jsplitpane;//声明拆分窗格
	//构造函数
	public  Demo5_swingJSplitPane()
	{
		//创建组件
		String [] item={"Mercy","Ronaodo","Kobe"};//用字符串数组定义要在列表框组件中显示的元素
		jlist=new JList(item);//然后直接把string作为参数传递到JList中即可将这些元素放入列表框组件中	
		
		jlabel=new JLabel(new ImageIcon("images/1.jpg"));//标签可以放图片，用new ImageIcon("文件路径")作为参数
		
		jsplitpane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jlabel);//水平拆分,拆分结果是分成左右两半。往左边放jlist，右边放jlabel
		jsplitpane.setOneTouchExpandable(true);//设置了伸缩
		
		//设置布局管理器
		
		//添加组件
		this.add(jsplitpane);//只需将拆分窗格放到容器中即可
		
		//设置窗体属性
		this.setTitle("JSplitPane拆分窗格");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocation(700, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo5_swingJSplitPane demo=new Demo5_swingJSplitPane();

	}

}
