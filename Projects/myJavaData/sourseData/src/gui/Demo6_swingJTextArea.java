/*
 * JTextArea �����ı������
 */
package gui;
import java.awt.*;
import javax.swing.*;
public class Demo6_swingJTextArea extends JFrame{
	//�������
	JTextArea jtextarea;//�����ı������
	JScrollPane jscrollpane;
	JPanel jpanel;//���
	JComboBox jcombobox;//���������
	JTextField jtextfield;//�ı���
	JButton jbutton;
	//���캯��
	public  Demo6_swingJTextArea()
	{
		//�������
		jtextarea=new JTextArea();
		jscrollpane=new JScrollPane(jtextarea);
		
		jpanel=new JPanel();
		
		String[] item={"·�˼�","�ն���","�ڻұ�"};
		jcombobox=new JComboBox(item);
		
		jtextfield=new JTextField(10);
		jbutton=new JButton("����");
		
		//���ò��ֹ�����.�����������֣���˳���
		
		//�����������
		jpanel.add(jcombobox);
		jpanel.add(jtextfield);
		jpanel.add(jbutton);
		
		//����JFrame
		this.add(jscrollpane);
		this.add(jpanel,BorderLayout.SOUTH);
		
		//���ô�������
		this.setTitle("JTextArea");
		this.setIconImage((new ImageIcon("images/2.jpg")).getImage());
		this.setResizable(false);
		this.setSize(400,400);
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		Demo6_swingJTextArea demo=new Demo6_swingJTextArea();
	}
}
