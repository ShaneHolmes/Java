/*
 * ���ֲ��ֹ�������ʹ��1
 * ʹ������ʽ���ֺͱ�Ե���֣����JPanel��jp1�������JButton��jb1��jb2��
 * jpane2�������JButton��jb3��jb4��jb5��
 * jpane1�ŵ�JFrame��NORTHλ��
 * jpane2�ŵ�JFrame��SOUTHλ��
 * JFrame��CENTERλ�������JButton��jb0
 */
package gui;
import java.awt.*;
import javax.swing.*;

public class Demo1_useOfLayout extends JFrame
{

	//�������
	JPanel jpane1,jpane2;
	JButton jbutton1,jbutton2,jbutton3,jbutton4,jbutton5,jbutton0;//��JButton jb0�ŵ��м�
	
	
	//���캯��
	public Demo1_useOfLayout()
	{
		//�������
		//JPanel��Ĭ�ϲ�����FlowLayout��ʽ����
		jpane1=new JPanel();
		jpane2=new JPanel();
		
		jbutton1=new JButton("1");
		jbutton2=new JButton("2");
		jbutton3=new JButton("3");
		jbutton4=new JButton("4");
		jbutton5=new JButton("5");
		jbutton0=new JButton("center");
		
		//���ò���
		
		//�������������
		jpane1.add(jbutton1);
		jpane1.add(jbutton2);
		jpane2.add(jbutton3);
		jpane2.add(jbutton4);
		jpane2.add(jbutton5);
		
		//��Panel����JFrame
		this.add(jpane1,BorderLayout.NORTH);//���1�ӵ�JFrame�ı���
		this.add(jbutton0,BorderLayout.CENTER);//JButton��ťjb0�ӵ�JFrame���в�
		this.add(jpane2,BorderLayout.SOUTH);//���2�ӵ�JFrame���ϲ�
		
		//���ô��ڵ�����
		this.setTitle("���ֹ��������ۺ�ʹ��");
		this.setSize(400,400);
		this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_useOfLayout demo=new Demo1_useOfLayout();

	}

}
