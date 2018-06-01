/*
 * ����QQ��¼����
 * ��Ϊ�������֣������У���
 * ������һ��ͼƬ��JLabel���Է���ͼƬ
 * �ϲ���������ť��ÿ�Ű�ť�������һ��ͼƬ
 * �в�����һ������ѡ�����֮�����������е����񲼾֣�
 * ��һ�У��˺ţ�JLabel��  �ı���JTextField�� ����˺ţ�JButton��
 * �ڶ��У����루JLabel��  �����JPasswordField�� �������루JLabel��
 * �����У������¼��JCheckBox��ѡ��ť�� ��ס���루JCheckBox��ѡ��ť�� �˺����ߣ�JLabel��
 * 
 */

package gui;
import java.awt.*;
import javax.swing.*;

public class Demo7_QQlogin extends JFrame{

	/*
	 * �������
	 */
	//��������
	JLabel jlabelNorth;//JLabel���Է���ͼƬ
	
	//�ϲ�����
	JButton jbuttonSouth1,jbuttonSouth2,jbuttonSouth3;//�ϲ���������ť
	JPanel jpanelSouth;//�ϲ����
	
	//�в�����
	JTabbedPane jtabbedpane;//ѡ�����
	JPanel jpanelCenter1,jpanelCenter2,jpanelCenter3;//�в��������������������壬ÿ��������һ�����
	JLabel jlabelCenter1,jlabelCenter2,jlabelCenter3,jlabelCenter4;
	JTextField jtextfield;
	JPasswordField jpasswordfield;
	JButton jbuttonCenter;//�����ť
	JCheckBox jcheckbox1,jcheckbox2;//��ѡ��ť
	
	
	
	
	//���캯��
	public Demo7_QQlogin()
	{
		/*
		 * �������
		 */
		
		//�������
		jlabelNorth=new JLabel(new ImageIcon("images/1.jpg"));
		
		
		//�ϲ����
		jbuttonSouth1=new JButton(new ImageIcon("images/4.png"));
		jbuttonSouth2=new JButton(new ImageIcon("images/4.png"));
		jbuttonSouth3=new JButton(new ImageIcon("images/4.png"));
		jpanelSouth=new JPanel();
		
		
		//�в�����
		jtabbedpane=new JTabbedPane();//����ѡ�����
		
		jpanelCenter1=new JPanel();
		jpanelCenter2=new JPanel();
		jpanelCenter2.setBackground(Color.PINK);//���õڶ���������ɫ
		jpanelCenter3=new JPanel();
		jpanelCenter3.setBackground(new Color(0,0,225));//���õ�����������ɫ
		
		jlabelCenter1=new JLabel("�˺�",JLabel.CENTER);//��ť�����м�
		jlabelCenter2=new JLabel("����",JLabel.CENTER);
		jlabelCenter3=new JLabel("��������",JLabel.CENTER);
		jlabelCenter3.setFont(new Font("����",Font.PLAIN,16));//���á��������롱��������ʽ
		jlabelCenter3.setForeground(Color.blue);//����������ɫ
		jlabelCenter4=new JLabel("�˺�����",JLabel.CENTER);
		
		jtextfield=new JTextField();
		jpasswordfield=new JPasswordField();
		
		jbuttonCenter=new JButton("����˺�");
		
		jcheckbox1=new JCheckBox("�����¼");//��ѡ��ť
		jcheckbox2=new JCheckBox("��ס����");
		
		
		
		
	
		//�������ӵ�ѡ�������
		jtabbedpane.add("����˺�",jpanelCenter1);
		jtabbedpane.add("ѡ�2����",jpanelCenter2);
		jtabbedpane.add("ѡ�2����",jpanelCenter3);
	
		//���ò��ֹ�����
		jpanelCenter1.setLayout(new GridLayout(3,3));//3x3�����񲼾�
		
		
		/*
		 * ������
		 */
		//�ϲ������ӵ�jpanelsouth
		jpanelSouth.add(jbuttonSouth1);
		jpanelSouth.add(jbuttonSouth2);
		jpanelSouth.add(jbuttonSouth3);
		
		//�в������ӵ�jpanelCenter1,���ò��ֹ�����ʱ�ѽ�jpanelCenter1����������Ϊ3x3�����񲼾֣�ֻ�谴˳������������
		jpanelCenter1.add(jlabelCenter1);//��һ��
		jpanelCenter1.add(jtextfield);
		jpanelCenter1.add(jbuttonCenter);
		
		jpanelCenter1.add(jlabelCenter2);//�ڶ���
		jpanelCenter1.add(jpasswordfield);
		jpanelCenter1.add(jlabelCenter3);
		
		jpanelCenter1.add(jcheckbox1);
		jpanelCenter1.add(jcheckbox2);
		jpanelCenter1.add(jlabelCenter4);
		
		
		//Ȼ�󽫱����ϣ��в���Ԫ�طŵ�JFrame��
		this.add(jlabelNorth,BorderLayout.NORTH);
		this.add(jtabbedpane,BorderLayout.CENTER);
		this.add(jpanelSouth, BorderLayout.SOUTH);
		
		//���ô��ڵ�����
		this.setIconImage((new ImageIcon("images/1.jpg")).getImage());
		this.setTitle("my login");
		this.setSize(400,400);
		//this.setResizable(false);
		this.setBackground(getForeground());
		this.setLocation(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo7_QQlogin demo=new Demo7_QQlogin();
	}

}
