/*
       �������񲼾֣���������һ�е�����
      �û���(��ǩJLabel)    �ı���JTextField
 *����(��ǩJLabel)     �����JPasswordField
 *��¼(��ťJButton)    ȡ��(��ťJButton)
 *
 *��������JPanel
 *��һ�зŵ�һ��JPanel  jpanel1���������jpanel1�����û���(��ǩJLabel)���ı���JTextField��Ĭ����ʽ����
 *�ڶ��зŵڶ���JPanel  jpanel2���������jp2��������(��ǩJLabel)�������JPasswordField��Ĭ����ʽ����
 *�����зŵ�����JPanel  jpanel3���������jp��¼(��ťJButton)��ȡ��(��ťJButton)��Ĭ����ʽ����
 */
package gui;

import java.awt.*;
import javax.swing.*;

public class Demo2_useOfLayout extends JFrame
{

	//�������
	JPanel jpanel1,jpanel2,jpanel3;
	JButton jbutton1,jbutton2;
	JLabel jlabel1,jlabel2;
	JTextField jtextfeild1;
	JPasswordField jpasswordfield1;
	
	//���캯��
	public Demo2_useOfLayout()
	{
		//�������
		jpanel1=new JPanel();
		jpanel2=new JPanel();
		jpanel3=new JPanel();
		
		jbutton1=new JButton("��¼");
		jbutton2=new JButton("ȡ��");
				
		
		jlabel1=new JLabel("�û���");
		jlabel2=new JLabel("����    ");
		
		jtextfeild1=new JTextField(10);
		jpasswordfield1=new JPasswordField(10);
		
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));//����һ��
		
		//�������������
		jpanel1.add(jlabel1);
		jpanel1.add(jtextfeild1);
		
		jpanel2.add(jlabel2);
		jpanel2.add(jpasswordfield1);
		
		jpanel3.add(jbutton1);
		jpanel3.add(jbutton2);
		
		//��3��Panel����JFrame,ǰ��������Ϊ���񲼾֣���˳��������
		this.add(jpanel1);
		this.add(jpanel2);
		this.add(jpanel3);
		
		//���ô��ڵ�����
		this.setTitle("���ֹ��������ۺ�ʹ��");
		this.setSize(300,150);
		this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2_useOfLayout demo=new Demo2_useOfLayout();

	}

}
