/*
 * 通过上下左右键，来控制辆坦克的位置
 * repaint重绘方法
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo2_KeyListener extends JFrame{

	MyPanel mypanel=null;
	
	//构造函数
	public Demo2_KeyListener()
	{
		mypanel=new MyPanel();
		
		this.add(mypanel);
		
		
		//实现监听
		this.addKeyListener(mypanel);
		
		
		//设置窗体属性
		this.setTitle("KeyListener");
		this.setSize(400,400);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo2_KeyListener demo=new Demo2_KeyListener();
	}

}


//定义自己的面板
class MyPanel extends JPanel implements KeyListener
{
	int x=10;
	int y=10;//初始化圆的坐标
	public void paint(Graphics g)
	{
		super.paint(g);//继承父类
		g.setColor(Color.green);
		g.fillOval(x, y, 10, 50);
		g.fillOval(x+20, y, 10, 50);
		g.setColor(Color.blue);
		g.fill3DRect(x+5, y+8,20,35,true);
		g.setColor(Color.red);
		g.fill3DRect(x+14, y-3, 3, 15, true);
	}

	@Override
	public void keyTyped(KeyEvent e) {//某个键的值被输出
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//某个键被按下
		// TODO Auto-generated method stub
		//System.out.println((char)e.getKeyCode()+"键被按下");
		if(e.getKeyCode()==KeyEvent.VK_DOWN)//按下下方向键
		{
			y+=5;
			
		}else if(e.getKeyCode()==KeyEvent.VK_UP)//按下上方向键
		{
			y-=5;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)//按下左方向键
		{
			x-=3;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)//按下右方向键
		{
			x+=3;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {//某个键被释放
		// TODO Auto-generated method stub
		
	}
}