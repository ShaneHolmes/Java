/*
 * 实现鼠标键盘监听机制
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo3_MouseEventKeyEvent extends JFrame{

	//声明自己的组件
	MyPanel1 mypanel1=null;
	
	//构造函数
	public Demo3_MouseEventKeyEvent()
	{
		//创建组件
		mypanel1=new MyPanel1();
		
		//添加面板
		this.add(mypanel1);
		
		//注册监听
		this.addMouseListener(mypanel1);
		this.addKeyListener(mypanel1);
		this.addMouseMotionListener(mypanel1);
		
		//设置窗口属性
		this.setTitle("MouseEventKeyEvent");
		this.setSize(400,300);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addWindowListener(mypanel1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo3_MouseEventKeyEvent demo=new Demo3_MouseEventKeyEvent();

	}

}


/*
 * 创建自己的面板
 * 1.让MyPanel知道鼠标按下的消息，并且知道点击的位置(x,y)
 * 2.让MyPanel知道那个键按下
 * 3.让MyPanel知道鼠标移动，拖拽
 * 4.让MyPanel知道窗口的变化（最小化最大化）
 */
class MyPanel1 extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
{

	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标点击了x="+e.getX()+",y="+e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标进入坐标x="+e.getX()+",y="+e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标出去了");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar()+"键被按下");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标当前坐标：x="+e.getX()+"y="+e.getY());
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口打开了");
	}

	
	
	@Override//窗口正在关闭
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口关闭了");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口最大化了");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口最小化了");
	}
	
}


