/*
 * ʹ���б�����
 * ��ִ���JSplitPane(�����������������javax.swing.*��)
 */

package gui;
import java.awt.*;
import javax.swing.*;
public class Demo5_swingJSplitPane extends JFrame {

	//�������
	JList jlist;//�����б�����
	JLabel jlabel;//��ǩ
	JSplitPane jsplitpane;//������ִ���
	//���캯��
	public  Demo5_swingJSplitPane()
	{
		//�������
		String [] item={"Mercy","Ronaodo","Kobe"};//���ַ������鶨��Ҫ���б���������ʾ��Ԫ��
		jlist=new JList(item);//Ȼ��ֱ�Ӱ�string��Ϊ�������ݵ�JList�м��ɽ���ЩԪ�ط����б�������	
		
		jlabel=new JLabel(new ImageIcon("images/1.jpg"));//��ǩ���Է�ͼƬ����new ImageIcon("�ļ�·��")��Ϊ����
		
		jsplitpane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jlabel);//ˮƽ���,��ֽ���Ƿֳ��������롣����߷�jlist���ұ߷�jlabel
		jsplitpane.setOneTouchExpandable(true);//����������
		
		//���ò��ֹ�����
		
		//������
		this.add(jsplitpane);//ֻ�轫��ִ���ŵ������м���
		
		//���ô�������
		this.setTitle("JSplitPane��ִ���");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocation(700, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo5_swingJSplitPane demo=new Demo5_swingJSplitPane();

	}

}
