package application;
import java.io.*;//�ļ����������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NotePad extends JFrame implements ActionListener{

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
	public NotePad()
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
		jbutton1=new JButton(new ImageIcon("images/start.jpg"));//��ͼƬ�ŵ���ť��
		jbutton1.setToolTipText("�½�");//���õ���껮��ʱ����ʾ��Ϣ
		jbutton2=new JButton(new ImageIcon("images/continue.jpg"));
		jbutton2.setToolTipText("��");//���õ���껮��ʱ����ʾ��Ϣ
		
		//���ò��ֹ�����
		
		
		//������,����С�����˳��������
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
	
	    
	    /*
	     * ע�����
	     */
	    jmenuitem2.addActionListener(this);
	    jmenuitem3.addActionListener(this);
	    jmenu1.addActionListener(this);//jmenu1���¼�Դ,��thisȥ����
	    jmenu2.addActionListener(this);
	    jmenu3.addActionListener(this);
	    jmenu4.addActionListener(this);
	    jmenu5.addActionListener(this);
	    
	    
	    
	    
	    //ָ��action��������߼�������¼�Դ��ͨ��ָ��action����ķ����������ĸ��¼�Դ���¼��������ݸ������ߣ��������Դ�������Ӧ�ķ�Ӧ
	    jmenuitem2.setActionCommand("��");
	    jmenuitem3.setActionCommand("����");
	    jmenu1.setActionCommand("�ļ�");
	    jmenu2.setActionCommand("�༭");
	    jmenu3.setActionCommand("��ʽ");
	    jmenu4.setActionCommand("�鿴");
	    jmenu5.setActionCommand("����");
	    
	    
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
		NotePad demo=new NotePad();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��")){
			//�ļ�ѡ�����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�...");//���ô����ļ��Ի�������
			jfc1.showOpenDialog(null);//��Ĭ�Ϸ�ʽչʾ�����ļ�·��
			jfc1.setVisible(true);//��ʾ
			
			String filename=jfc1.getSelectedFile().getAbsolutePath();//��ѡ�е��ļ��ľ���·������filename
			System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			try{
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//���ļ��ж�ȡ��Ϣ����ʾ
				String s="";
				String alls="";
				while((s=br.readLine())!=null)
				{
					alls+=s+"\r\n";//�����е��ļ���Ϣ�ȱ�����alls,֮����һ�������ʾ
				}
				//��ʾ��JTextArea
				jtextarea.setText(alls);
			}catch(Exception en){
				en.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("����")){
			//���ֱ���Ի���
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("���Ϊ...");
			jfc.showSaveDialog(null);//��Ĭ�ϵķ�ʽ����
			jfc.setVisible(true);
			
			//�õ��û�ϣ�������·��
			String file=jfc.getSelectedFile().getName();
			
			//Ȼ��д��Ҫ������ļ���
			FileWriter fw=null;
			BufferedWriter bw=null;
			try{
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				
				bw.write(this.jtextarea.getText());
			}catch(Exception e2){
				e2.printStackTrace();
			}finally{
				try {
					fw.close();
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("��ʽ")){
			
		}else if(e.getActionCommand().equals("�鿴")){
			
		}else if(e.getActionCommand().equals("����")){
			
		}else if(e.getActionCommand().equals("��ʽ")){
			
		}
			
	}

}
