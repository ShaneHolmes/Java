/*
�������񲼾֣���������һ�е�����
��ϲ�����˶�(��ǩJLabel)  ����  ���� ����  (��ѡ�����JCheckBox)�ɶ�ѡ
*����Ա�(��ǩJLabel)     �� Ů(��ѡ��ťJRadioButton)ֻ�ܵ���һ��
*ע���û�(��ťJButton)    ȡ��(��ťJButton)
*
*��������JPanel
*��һ�зŵ�һ��JPanel  jpanel1���������jp1������ϲ�����˶�(��ǩJLabel)  ����  ���� ����  (��ѡ�����JCheckBox)��Ĭ����ʽ����
*�ڶ��зŵڶ���JPanel  jpanel2���������jp2��������Ա�(��ǩJLabel)     �� Ů(��ѡ��ťJRadioButton)��Ĭ����ʽ����
*�����зŵ�����JPanel  jpanel3���������jp3ע���û�(��ťJButton)    ȡ��(��ťJButton)��Ĭ����ʽ����
*/



package gui;

import java.awt.*;
import javax.swing.*;

public class Demo3_useOfLayout extends JFrame
{
	

     //�������
     JPanel jpanel1,jpanel2,jpanel3;
     JButton jbutton1,jbutton2;
     JLabel jlabel1,jlabel2;
     JCheckBox jcheckbox1,jcheckbox2,jcheckbox3;
     JRadioButton jradiobutton1,jradiobutton2;

//���캯��
   public Demo3_useOfLayout()
   {
	//�������
	jpanel1=new JPanel();
	jpanel2=new JPanel();
	jpanel3=new JPanel();
	
	jbutton1=new JButton("ע���û�");
	jbutton2=new JButton("ȡ��");
			
	
	jlabel1=new JLabel("��ϲ�����˶�");
	jlabel2=new JLabel("����Ա�    ");
	
	jcheckbox1=new JCheckBox("����");//��ѡ��
	jcheckbox2=new JCheckBox("����");
	jcheckbox3=new JCheckBox("����");
	
	jradiobutton1=new JRadioButton("��");
	jradiobutton2=new JRadioButton("Ů");//��ѡ��ť
	
	//����ѡ��ťjrb1,jrb2����һ��ButtonGroup�й���
	ButtonGroup bg=new ButtonGroup();
	bg.add(jradiobutton1);
	bg.add(jradiobutton2);
	
	//���ò��ֹ�����
	this.setLayout(new GridLayout(3,1));//����һ��
	
	//�������������
	jpanel1.add(jlabel1);//��һ�����
	jpanel1.add(jcheckbox1);
	jpanel1.add(jcheckbox2);
	jpanel1.add(jcheckbox3);
	
	jpanel2.add(jlabel2);//�ڶ������
	jpanel2.add(jradiobutton1);
	jpanel2.add(jradiobutton2);
	
	jpanel3.add(jbutton1);//���������
	jpanel3.add(jbutton2);
	
	//��3�����Panel����JFrame,ǰ��������Ϊ���񲼾֣���˳��������
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
	Demo3_useOfLayout demo=new Demo3_useOfLayout();

}

}
