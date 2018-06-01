/*
 * �˵������JMenuBar���˵������������
 *       JMenu���˵������              ��֦
 *       JMenuItem���˵����������Ҷ
 * �����˵�������
 *       JMenu�������Ƕ��JMenu
 * ���������
 *       JToolBar ���������      
 */
package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//������¼����д���İ�
public class Demo8_swingJMenuBar extends JFrame{

	//����Ҫ�õ����
	JMenuBar jmenubar;//�˵������
	JMenu jmenu1,jmenu2,jmenu3,jmenu4,jmenu5;
	JMenuItem jmenuitem2,jmenuitem3,jmenuitem4,jmenuitem5,jmenuitem6,jmenuitem7;
	
	JMenu secondmenu;//�����˵�
	JMenuItem itemfile,itemproject;
	
	JTextArea jtextarea;
	
	//������
	JToolBar jtoolbar;
	JButton jbutton1,jbutton2;
	
	
	//���캯��
	public Demo8_swingJMenuBar()
	{
		//�������
		jmenubar=new JMenuBar(); 
		jmenu1=new JMenu("�ļ�<F>");
		jmenu1.setMnemonic('F');//�������Ƿ�������Alt+F���൱�ڵ����һ��JMenu"�ļ�<F>"
		jmenu2=new JMenu("�༭<E>");
		jmenu2.setMnemonic('E');//�������Ƿ�
		jmenu3=new JMenu("��ʽ<O>");
		jmenu3.setMnemonic('O');//�������Ƿ�
		jmenu4=new JMenu("�鿴<V>");
		jmenu4.setMnemonic('V');//�������Ƿ�
		jmenu5=new JMenu("����<H>");
		jmenu5.setMnemonic('H');//�������Ƿ�
		
		secondmenu=new JMenu("�½�");
		itemfile=new JMenuItem("�ļ�");
		itemproject=new JMenuItem("����");
		
		jmenuitem2=new JMenuItem("��");
		jmenuitem3=new JMenuItem("����");
		jmenuitem4=new JMenuItem("���Ϊ");
		jmenuitem5=new JMenuItem("ҳ������");
		jmenuitem6=new JMenuItem("��ӡ");
		jmenuitem7=new JMenuItem("�˳�");
		
		jtextarea=new JTextArea();
		
		jtoolbar=new JToolBar();
		jbutton1=new JButton(new ImageIcon("images/start.jpg"));
		jbutton1.setToolTipText("�½�");//���õ���껮��ʱ����ʾ��Ϣ
		jbutton2=new JButton(new ImageIcon("images/continue.jpg"));
		jbutton2.setToolTipText("��");//���õ���껮��ʱ����ʾ��Ϣ
		
		//���ò��ֹ�����
		
		
		//������
		//���˵�����ӵ��˵���
		secondmenu.add(itemfile);
		secondmenu.add(itemproject);
		
		jmenu1.add(secondmenu);
		jmenu1.add(jmenuitem2);
		jmenu1.add(jmenuitem3);
		jmenu1.add(jmenuitem4);
		jmenu1.addSeparator();//��ӷָ���
		jmenu1.add(jmenuitem5);
		jmenu1.addSeparator();//��ӷָ���
		jmenu1.add(jmenuitem6);
		jmenu1.addSeparator();//��ӷָ���
		jmenu1.add(jmenuitem7);
		
		//����ť��ӵ���������
		jtoolbar.add(jbutton1);
		jtoolbar.add(jbutton2);
		
		//���˵���ӵ��˵�����
		jmenubar.add(jmenu1);
		jmenubar.add(jmenu2);
		jmenubar.add(jmenu3);
		jmenubar.add(jmenu4);
		jmenubar.add(jmenu5);
		
		//���˵�����ӵ�������
		this.setJMenuBar(jmenubar);
		
		//���������ŵ�������
		this.add(jtoolbar,BorderLayout.NORTH);
		
		//��jtextarea�ŵ�������
		JScrollPane jscrollpane=new JScrollPane(jtextarea);//���ù�������
		//����һ�����ù�������ʱ���֣��дӲ�����NEVER��һֱ����ALWAYS����Ҫʱ����NEEDED����
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    //��������������
	    this.add(jscrollpane);
	    
	    
	    
	    
	    
	    //���ô��ڵ�����
	    this.setIconImage((new ImageIcon("images/1.jpg")).getImage());
	    this.setTitle("���±�");
	    this.setSize(600,800);
	  	this.setBackground(getForeground());
	  	this.setLocation(700,100);
	  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	this.setVisible(true);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_swingJMenuBar demo=new Demo8_swingJMenuBar();

	}

}
