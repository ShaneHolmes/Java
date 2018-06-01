/*
 * 菜单组件：JMenuBar（菜单条组件）树干
 *       JMenu（菜单组件）              树枝
 *       JMenuItem（菜单项组件）树叶
 * 二级菜单制作：
 *       JMenu里面可以嵌套JMenu
 * 工具条组件
 *       JToolBar 容器类组件      
 */
package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//引入对事件进行处理的包
public class Demo8_swingJMenuBar extends JFrame{

	//声明要用的组件
	JMenuBar jmenubar;//菜单栏组件
	JMenu jmenu1,jmenu2,jmenu3,jmenu4,jmenu5;
	JMenuItem jmenuitem2,jmenuitem3,jmenuitem4,jmenuitem5,jmenuitem6,jmenuitem7;
	
	JMenu secondmenu;//二级菜单
	JMenuItem itemfile,itemproject;
	
	JTextArea jtextarea;
	
	//工具条
	JToolBar jtoolbar;
	JButton jbutton1,jbutton2;
	
	
	//构造函数
	public Demo8_swingJMenuBar()
	{
		//创建组件
		jmenubar=new JMenuBar(); 
		jmenu1=new JMenu("文件<F>");
		jmenu1.setMnemonic('F');//设置助记符，按下Alt+F键相当于点击这一个JMenu"文件<F>"
		jmenu2=new JMenu("编辑<E>");
		jmenu2.setMnemonic('E');//设置助记符
		jmenu3=new JMenu("格式<O>");
		jmenu3.setMnemonic('O');//设置助记符
		jmenu4=new JMenu("查看<V>");
		jmenu4.setMnemonic('V');//设置助记符
		jmenu5=new JMenu("帮助<H>");
		jmenu5.setMnemonic('H');//设置助记符
		
		secondmenu=new JMenu("新建");
		itemfile=new JMenuItem("文件");
		itemproject=new JMenuItem("工程");
		
		jmenuitem2=new JMenuItem("打开");
		jmenuitem3=new JMenuItem("保存");
		jmenuitem4=new JMenuItem("另存为");
		jmenuitem5=new JMenuItem("页面设置");
		jmenuitem6=new JMenuItem("打印");
		jmenuitem7=new JMenuItem("退出");
		
		jtextarea=new JTextArea();
		
		jtoolbar=new JToolBar();
		jbutton1=new JButton(new ImageIcon("images/start.jpg"));
		jbutton1.setToolTipText("新建");//设置当鼠标划过时的提示信息
		jbutton2=new JButton(new ImageIcon("images/continue.jpg"));
		jbutton2.setToolTipText("打开");//设置当鼠标划过时的提示信息
		
		//设置布局管理器
		
		
		//添加组件
		//将菜单项添加到菜单上
		secondmenu.add(itemfile);
		secondmenu.add(itemproject);
		
		jmenu1.add(secondmenu);
		jmenu1.add(jmenuitem2);
		jmenu1.add(jmenuitem3);
		jmenu1.add(jmenuitem4);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem5);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem6);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem7);
		
		//将按钮添加到工具条上
		jtoolbar.add(jbutton1);
		jtoolbar.add(jbutton2);
		
		//将菜单添加到菜单条上
		jmenubar.add(jmenu1);
		jmenubar.add(jmenu2);
		jmenubar.add(jmenu3);
		jmenubar.add(jmenu4);
		jmenubar.add(jmenu5);
		
		//将菜单条添加到窗体上
		this.setJMenuBar(jmenubar);
		
		//将工具条放到窗体上
		this.add(jtoolbar,BorderLayout.NORTH);
		
		//将jtextarea放到窗体中
		JScrollPane jscrollpane=new JScrollPane(jtextarea);//设置滚动窗格
		//下面一行设置滚动条何时出现，有从不出现NEVER，一直出现ALWAYS，需要时出现NEEDED三种
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    //最后往窗口中添加
	    this.add(jscrollpane);
	    
	    
	    
	    
	    
	    //设置窗口的属性
	    this.setIconImage((new ImageIcon("images/1.jpg")).getImage());
	    this.setTitle("记事本");
	    this.setSize(600,800);
	  	this.setBackground(getForeground());
	  	this.setLocation(700,100);
	  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	this.setVisible(true);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_swingJMenuBar demo=new Demo8_swingJMenuBar();

	}

}
