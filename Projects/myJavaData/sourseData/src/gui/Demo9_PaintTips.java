/*
 * java绘图原理
 */

package gui;
import java.awt.*;
import javax.swing.*;
public class Demo9_PaintTips extends JFrame{

	//声明要使用的组件
	MyPanel mypanel;
	
	//构造函数
	public Demo9_PaintTips()
	{
		//创建组件面板
		mypanel=new MyPanel();
		
		//添加组件
		this.add(mypanel);
		
		//设置窗体属性
		this.setTitle("PaintTips");
		this.setSize(600,600);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_PaintTips demo=new Demo9_PaintTips();

	}

}


/*
 * 定义一个MyPanel类，(我自己的面板，用于绘图和实现绘图的区域)
 * */
class MyPanel extends JPanel
{
	//首先必须要覆盖JPanel的paint方法,父类中该paint()方法名为paint，既是覆盖，方法名不能够更改
	public void paint(Graphics g)//Graphics是绘图重要的类，可以理解成是一只画笔
	{
		//调用父类完成初始化，这句话不能少
		super.paint(g);
		
		g.drawOval(10,10, 30, 30);//先画出一个圆
		g.drawLine(0, 0, 300, 300);//画直线
		g.drawRect(50,50, 40, 30);//画矩形
		g.fillRect(70,100, 30, 50);//填充矩形
		g.setColor(Color.red);//设置颜色
		g.setFont(new Font("华文彩云",Font.BOLD,60));//设置字体    			
		g.drawString("PaintTips", 200,200);//画字符串			
		g.setColor(Color.green);//设置颜色
		g.fillOval(300, 300, 40, 30);	
//		//画图片
//		Image image=
//				Toolkit.getDefaultToolkit().getImage
//				(Panel.class.getResource("images/1.jpg"));				
//		g.drawImage(image, 300, 40, 40, 30, this);		
		
	}
	
	
	
	
	
	
	
	
	
}