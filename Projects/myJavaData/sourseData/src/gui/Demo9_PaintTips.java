/*
 * java��ͼԭ��
 */

package gui;
import java.awt.*;
import javax.swing.*;
public class Demo9_PaintTips extends JFrame{

	//����Ҫʹ�õ����
	MyPanel mypanel;
	
	//���캯��
	public Demo9_PaintTips()
	{
		//����������
		mypanel=new MyPanel();
		
		//������
		this.add(mypanel);
		
		//���ô�������
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
 * ����һ��MyPanel�࣬(���Լ�����壬���ڻ�ͼ��ʵ�ֻ�ͼ������)
 * */
class MyPanel extends JPanel
{
	//���ȱ���Ҫ����JPanel��paint����,�����и�paint()������Ϊpaint�����Ǹ��ǣ����������ܹ�����
	public void paint(Graphics g)//Graphics�ǻ�ͼ��Ҫ���࣬����������һֻ����
	{
		//���ø�����ɳ�ʼ������仰������
		super.paint(g);
		
		g.drawOval(10,10, 30, 30);//�Ȼ���һ��Բ
		g.drawLine(0, 0, 300, 300);//��ֱ��
		g.drawRect(50,50, 40, 30);//������
		g.fillRect(70,100, 30, 50);//������
		g.setColor(Color.red);//������ɫ
		g.setFont(new Font("���Ĳ���",Font.BOLD,60));//��������    			
		g.drawString("PaintTips", 200,200);//���ַ���			
		g.setColor(Color.green);//������ɫ
		g.fillOval(300, 300, 40, 30);	
//		//��ͼƬ
//		Image image=
//				Toolkit.getDefaultToolkit().getImage
//				(Panel.class.getResource("images/1.jpg"));				
//		g.drawImage(image, 300, 40, 40, 30, this);		
		
	}
	
	
	
	
	
	
	
	
	
}