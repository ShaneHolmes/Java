/*
 * swing���:
 *         ���������(JComboBox)
 *         �б�����(JList)
 *         �����������(JScrollPane)
 */

package gui;

import java.awt.*;
import javax.swing.*;

public class Demo4_swingComponent extends JFrame
{
	//�������
	JPanel jpanel1,jpanel2;
	JLabel jlabel1,jlabel2;
	JComboBox jcombobox;//���������
	JList jlist;//�б�����
	JScrollPane jscrollpane;
	
	//���캯��
	public  Demo4_swingComponent()
	{
		//�������
		jpanel1=new JPanel();
		jpanel2=new JPanel();
		
		jlabel1=new JLabel("ϲ�����˶�");
		jlabel2=new JLabel("ϲ��������");
		
		//���ַ������鶨��Ҫ���������������ʾ��Ԫ��
		String []string1={"����","����","��ë��","ƹ����","����","��ȭ��","����"};
		jcombobox=new JComboBox(string1);//Ȼ��ֱ�Ӱ�string��Ϊ�������ݵ�JComboBox�м��ɽ���ЩԪ�ط��������������		
	    
		//���ַ������鶨��Ҫ���б���������ʾ��Ԫ��
		String []string2={"¹��","�Ʊ�","������","������","����˹̹","C��","ϰ��ƽ"};
		jlist=new JList(string2);//Ȼ��ֱ�Ӱ�string��Ϊ�������ݵ�JList�м��ɽ���ЩԪ�ط����б�������		
	    
		//��JList�У��������JScrollPane�����������ȫ����ʾ����
		//��JList��ϣ���л���ѡ�Ӧ�������������
		jlist.setVisibleRowCount(1);//���ó�ʼ��ʾ������Ϊ1
		jscrollpane=new JScrollPane(jlist);//��jlist��Ϊ�������ݵ�JScrollPane��
		
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));//���񲼾�
		
		
		
		//������
		jpanel1.add(jlabel1);
		jpanel1.add(jcombobox);
		
		jpanel2.add(jlabel2);
		jpanel2.add(jscrollpane);//��ӵ��ǹ�������
		
		
		
		//��2�����Panel����JFrame,ǰ��������Ϊ���񲼾֣���˳��������
		this.add(jpanel1);
		this.add(jpanel2);
		
		
		//���ô�������
		this.setTitle("swingcomponent");
		this.setResizable(false);
		this.setSize(400,400);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Demo4_swingComponent demo=new Demo4_swingComponent();
	}

}
