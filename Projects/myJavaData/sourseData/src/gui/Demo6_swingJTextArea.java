/*
 * JTextArea 多行文本框组件
 */
package gui;
import java.awt.*;
import javax.swing.*;
public class Demo6_swingJTextArea extends JFrame{
	//声明组件
	JTextArea jtextarea;//多行文本框组件
	JScrollPane jscrollpane;
	JPanel jpanel;//面板
	JComboBox jcombobox;//下拉框组件
	JTextField jtextfield;//文本框
	JButton jbutton;
	//构造函数
	public  Demo6_swingJTextArea()
	{
		//创建组件
		jtextarea=new JTextArea();
		jscrollpane=new JScrollPane(jtextarea);
		
		jpanel=new JPanel();
		
		String[] item={"路人甲","痴儿乙","炮灰丙"};
		jcombobox=new JComboBox(item);
		
		jtextfield=new JTextField(10);
		jbutton=new JButton("发送");
		
		//设置布局管理器.本身是流布局，按顺序放
		
		//添加面板中组件
		jpanel.add(jcombobox);
		jpanel.add(jtextfield);
		jpanel.add(jbutton);
		
		//加入JFrame
		this.add(jscrollpane);
		this.add(jpanel,BorderLayout.SOUTH);
		
		//设置窗体属性
		this.setTitle("JTextArea");
		this.setIconImage((new ImageIcon("images/2.jpg")).getImage());
		this.setResizable(false);
		this.setSize(400,400);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		Demo6_swingJTextArea demo=new Demo6_swingJTextArea();
	}
}
