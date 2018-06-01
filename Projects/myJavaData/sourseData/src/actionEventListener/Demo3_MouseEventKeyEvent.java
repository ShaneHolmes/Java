/*
 * ʵ�������̼�������
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo3_MouseEventKeyEvent extends JFrame{

	//�����Լ������
	MyPanel1 mypanel1=null;
	
	//���캯��
	public Demo3_MouseEventKeyEvent()
	{
		//�������
		mypanel1=new MyPanel1();
		
		//������
		this.add(mypanel1);
		
		//ע�����
		this.addMouseListener(mypanel1);
		this.addKeyListener(mypanel1);
		this.addMouseMotionListener(mypanel1);
		
		//���ô�������
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
 * �����Լ������
 * 1.��MyPanel֪����갴�µ���Ϣ������֪�������λ��(x,y)
 * 2.��MyPanel֪���Ǹ�������
 * 3.��MyPanel֪������ƶ�����ק
 * 4.��MyPanel֪�����ڵı仯����С����󻯣�
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
		System.out.println("�������x="+e.getX()+",y="+e.getY());
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
		System.out.println("����������x="+e.getX()+",y="+e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����ȥ��");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar()+"��������");
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
		System.out.println("��굱ǰ���꣺x="+e.getX()+"y="+e.getY());
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڴ���");
	}

	
	
	@Override//�������ڹر�
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڹر���");
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
		System.out.println("���������");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������С����");
	}
	
}


