/*
 * 类似QQ登录界面
 * 分为三个部分：北，中，南
 * 北部：一张图片。JLabel可以放置图片
 * 南部：三个按钮。每张按钮上面放置一张图片
 * 中部：第一部分是选项卡窗格；之后是三行三列的网格布局：
 * 第一行，账号（JLabel）  文本框（JTextField） 清除账号（JButton）
 * 第二行，密码（JLabel）  密码框（JPasswordField） 忘记密码（JLabel）
 * 第三行，隐身登录（JCheckBox复选框按钮） 记住密码（JCheckBox复选框按钮） 账号申诉（JLabel）
 * 
 */

package gui;
import java.awt.*;
import javax.swing.*;

public class Demo7_QQlogin extends JFrame{

	/*
	 * 声明组件
	 */
	//北部区域
	JLabel jlabelNorth;//JLabel可以放置图片
	
	//南部区域
	JButton jbuttonSouth1,jbuttonSouth2,jbuttonSouth3;//南部的三个按钮
	JPanel jpanelSouth;//南部面板
	
	//中部区域
	JTabbedPane jtabbedpane;//选项卡窗格
	JPanel jpanelCenter1,jpanelCenter2,jpanelCenter3;//中部用来放置组件的三个面板，每个面板放置一行组件
	JLabel jlabelCenter1,jlabelCenter2,jlabelCenter3,jlabelCenter4;
	JTextField jtextfield;
	JPasswordField jpasswordfield;
	JButton jbuttonCenter;//清除按钮
	JCheckBox jcheckbox1,jcheckbox2;//复选框按钮
	
	
	
	
	//构造函数
	public Demo7_QQlogin()
	{
		/*
		 * 创建组件
		 */
		
		//北部组件
		jlabelNorth=new JLabel(new ImageIcon("images/1.jpg"));
		
		
		//南部组件
		jbuttonSouth1=new JButton(new ImageIcon("images/4.png"));
		jbuttonSouth2=new JButton(new ImageIcon("images/4.png"));
		jbuttonSouth3=new JButton(new ImageIcon("images/4.png"));
		jpanelSouth=new JPanel();
		
		
		//中部区域
		jtabbedpane=new JTabbedPane();//创建选项卡窗格
		
		jpanelCenter1=new JPanel();
		jpanelCenter2=new JPanel();
		jpanelCenter2.setBackground(Color.PINK);//设置第二块面板的颜色
		jpanelCenter3=new JPanel();
		jpanelCenter3.setBackground(new Color(0,0,225));//设置第三块面板的颜色
		
		jlabelCenter1=new JLabel("账号",JLabel.CENTER);//按钮放在中间
		jlabelCenter2=new JLabel("密码",JLabel.CENTER);
		jlabelCenter3=new JLabel("忘记密码",JLabel.CENTER);
		jlabelCenter3.setFont(new Font("宋体",Font.PLAIN,16));//设置“忘记密码”的字体样式
		jlabelCenter3.setForeground(Color.blue);//设置字体颜色
		jlabelCenter4=new JLabel("账号申诉",JLabel.CENTER);
		
		jtextfield=new JTextField();
		jpasswordfield=new JPasswordField();
		
		jbuttonCenter=new JButton("清除账号");
		
		jcheckbox1=new JCheckBox("隐身登录");//复选框按钮
		jcheckbox2=new JCheckBox("记住密码");
		
		
		
		
	
		//将面板添加到选项卡窗格上
		jtabbedpane.add("你的账号",jpanelCenter1);
		jtabbedpane.add("选项卡2窗格",jpanelCenter2);
		jtabbedpane.add("选项卡2窗格",jpanelCenter3);
	
		//设置布局管理器
		jpanelCenter1.setLayout(new GridLayout(3,3));//3x3的网格布局
		
		
		/*
		 * 添加组件
		 */
		//南部组件添加到jpanelsouth
		jpanelSouth.add(jbuttonSouth1);
		jpanelSouth.add(jbuttonSouth2);
		jpanelSouth.add(jbuttonSouth3);
		
		//中部组件添加到jpanelCenter1,设置布局管理器时已将jpanelCenter1这块面板设置为3x3的网格布局，只需按顺序添加组件即可
		jpanelCenter1.add(jlabelCenter1);//第一行
		jpanelCenter1.add(jtextfield);
		jpanelCenter1.add(jbuttonCenter);
		
		jpanelCenter1.add(jlabelCenter2);//第二行
		jpanelCenter1.add(jpasswordfield);
		jpanelCenter1.add(jlabelCenter3);
		
		jpanelCenter1.add(jcheckbox1);
		jpanelCenter1.add(jcheckbox2);
		jpanelCenter1.add(jlabelCenter4);
		
		
		//然后将北，南，中部的元素放到JFrame中
		this.add(jlabelNorth,BorderLayout.NORTH);
		this.add(jtabbedpane,BorderLayout.CENTER);
		this.add(jpanelSouth, BorderLayout.SOUTH);
		
		//设置窗口的属性
		this.setIconImage((new ImageIcon("images/1.jpg")).getImage());
		this.setTitle("my login");
		this.setSize(400,400);
		//this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo7_QQlogin demo=new Demo7_QQlogin();
	}

}
