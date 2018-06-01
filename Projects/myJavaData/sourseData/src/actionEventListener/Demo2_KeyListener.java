/*
 * ͨ���������Ҽ�����������̹�˵�λ��
 * repaint�ػ淽��
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo2_KeyListener extends JFrame{

	MyPanel mypanel=null;
	
	//���캯��
	public Demo2_KeyListener()
	{
		mypanel=new MyPanel();
		
		this.add(mypanel);
		
		
		//ʵ�ּ���
		this.addKeyListener(mypanel);
		
		
		//���ô�������
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


//�����Լ������
class MyPanel extends JPanel implements KeyListener
{
	int x=10;
	int y=10;//��ʼ��Բ������
	public void paint(Graphics g)
	{
		super.paint(g);//�̳и���
		g.setColor(Color.green);
		g.fillOval(x, y, 10, 50);
		g.fillOval(x+20, y, 10, 50);
		g.setColor(Color.blue);
		g.fill3DRect(x+5, y+8,20,35,true);
		g.setColor(Color.red);
		g.fill3DRect(x+14, y-3, 3, 15, true);
	}

	@Override
	public void keyTyped(KeyEvent e) {//ĳ������ֵ�����
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//ĳ����������
		// TODO Auto-generated method stub
		//System.out.println((char)e.getKeyCode()+"��������");
		if(e.getKeyCode()==KeyEvent.VK_DOWN)//�����·����
		{
			y+=5;
			
		}else if(e.getKeyCode()==KeyEvent.VK_UP)//�����Ϸ����
		{
			y-=5;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)//���������
		{
			x-=3;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)//�����ҷ����
		{
			x+=3;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {//ĳ�������ͷ�
		// TODO Auto-generated method stub
		
	}
}