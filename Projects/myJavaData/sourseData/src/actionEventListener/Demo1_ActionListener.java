/*
 * �¼�������
 */
package actionEventListener;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//������¼����д���İ�
public class Demo1_ActionListener extends JFrame implements ActionListener{

	//����һ��MyPanel
	JPanel mypanel;
	
	//�������
	JButton jbutton1,jbutton2;
	
	//���캯��
	public Demo1_ActionListener()
	{
		//�������
		mypanel=new JPanel();
		jbutton1=new JButton("��ɫ");//jbutton1,2��Ϊ�¼�Դ����
		jbutton2=new JButton("��ɫ");
		
		//�����������ò���
		this.add(jbutton1,BorderLayout.NORTH);
		mypanel.setBackground(Color.BLACK);
		this.add(mypanel,BorderLayout.CENTER);//�м�ΪĬ��,���Բ�д���ַ�ʽ
		this.add(jbutton2, BorderLayout.SOUTH);
		
		/*
		 * ע�����
		 */
		jbutton1.addActionListener(this);//jbutton1���¼�Դ���õ�ǰ����thisȥ����
		//����Cat���һ����������Ҳȥ����
		Cat cat=new Cat();
		jbutton1.addActionListener(cat);//jbutton1���¼�Դ����ʵ������catȥ������
		/*
		 * һ���¼�Դ���Ա���������߼������������¼������ˣ���ô���еļ����߶���Դ�������Ӧ�ķ�Ӧ
		 */
		//ָ��action��������߼�������¼�Դ��ͨ��ָ��action����ķ����������ĸ��¼�Դ���¼��������ݸ������ߣ��������Դ�������Ӧ�ķ�Ӧ
		jbutton1.setActionCommand("��ɫ");
		jbutton2.addActionListener(this);//jbutton2û��ע��cat�ļ����ߣ����Ե����º�ɫ��ťʱ��èè��֪��
		jbutton2.setActionCommand("��ɫ");
		
		
		//���ô�������
		this.setTitle("ActionListener");
		this.setSize(400,200);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		Demo1_ActionListener demo=new Demo1_ActionListener();
	}

	
	
	
	@Override//���¼�����ķ����������¼�Դ���¼�����ָ��֮�󣬶���Ӧ���¼�Դ������Ӧ
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж�����һ����ť
		if(e.getActionCommand().equals("��ɫ"))//������ɫ�İ�ť
		{
			System.out.println("��������ɫ��ť");
			mypanel.setBackground(Color.BLUE);
		}else if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("�����˺�ɫ��ť");
			mypanel.setBackground(Color.red);
		}else
		{
			System.out.println("none");
		}
	}
}

class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ"))//������ɫ�İ�ť
		{
			System.out.println("èèҲ֪����������ɫ��ť");
		}else if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("èèҲ֪�������˺�ɫ��ť");
		}else
		{
			System.out.println("none");
		}
	}
	
}
