package client.jiemian;
import net.user.*;
import java.awt.*;
import javax.swing.*;
import client.model.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class ChatWin extends JFrame implements MouseMotionListener, MouseListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	User me;
	ContactMen friend;
	
	Point origin = new Point();
	
	JPanel jp1,jp2,jp3,jp4,jp5;
	JLabel jl1,jl2,jl3,right_im;
	JToolBar jtb1,jtb2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JButton jb11,jb22,jb33,jb44;
	JSplitPane jsp1,jsp2;
	JTextArea jta1,jta2;
	JScrollPane scrol1,scrol2;

	public ChatWin(User me, ContactMen friend)
	{
		this.friend=friend;
		this.me=me;
		jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.addMouseListener(this);
		jp1.addMouseMotionListener(this);
		jp1.setBackground(new Color(225, 229, 244));
		
		//处理标题与工具栏
		jl1 = new JLabel(this.friend.getIcon());
		jp1.add(jl1);
		jl1.setBounds(7, 5, 42, 42);
		jl1.setBorder(BorderFactory.createLineBorder(Color.white));
		jl2 = new JLabel(this.friend.getNickname());
		jl2.setFont(new Font("黑体", Font.PLAIN, 16));
		jl2.setForeground(Color.BLACK);
		jp1.add(jl2);
		jl2.setBounds(55, 6, 200, 25);
		jl3 = new JLabel(this.friend.getSignature());
		jl3.setFont(new Font("宋体", Font.PLAIN, 13));
		jl3.setForeground(Color.BLUE);
		jp1.add(jl3);
		jl3.setBounds(55, 31, 300, 17);
		right_im=new JLabel(new ImageIcon("timg.jpg"));
		
		jtb1 = new JToolBar();
		jtb1.setLayout(null);
		jb1 = new JButton(new ImageIcon("images/yyth.jpg"));
		jb1.setToolTipText("语音通话");
		jtb1.add(jb1);
		jb1.setBounds(0, 0, 30, 30);
		jb2 = new JButton(new ImageIcon("images/spth.jpg"));
		jb2.setToolTipText("视频通话");
		jtb1.add(jb2);
		jb2.setBounds(35, 0, 30, 30);
		jp1.add(jtb1);
		jtb1.setBounds(7, 50, 570, 37);
		jtb1.setFloatable(false);
		jtb1.setOpaque(false);
		jtb1.setBackground(null);
		
		//处理聊天显示区域
		jp2 = new JPanel(new BorderLayout());
		jta1= new JTextArea();
		jta1.setBackground(null);
		jta1.setEditable(false);
		scrol1=new JScrollPane(jta1);
		jp2.add(scrol1);
		
		jp3 = new JPanel(new BorderLayout());
		jtb2= new JToolBar();
		jtb2.setPreferredSize(new Dimension(445,24));;
		jtb2.setFloatable(false);
		jb11= new JButton(new ImageIcon("images/wenzi.jpg"));
		jb11.setToolTipText("字体设置");
		jb11.setPreferredSize(new Dimension(24, 24));
		jtb2.add(jb11);
		jb22= new JButton(new ImageIcon("images/biaoqing.jpg"));
		jb22.setToolTipText("表情");
		jb22.setSize(24, 24);
		jtb2.add(jb22);
		jp3.add(jtb2, BorderLayout.NORTH);
		
		jp5 = new JPanel(new FlowLayout());
		jp5.setPreferredSize(new Dimension(445, 25));
		jb33 = new JButton("关闭(c)");
		jb33.setBackground(new Color(91, 88, 241));
		jb33.setPreferredSize(new Dimension(80,20));
		jb33.setMnemonic('c');
		jb33.addActionListener(this);
		jb33.setActionCommand("close");
		jb44 = new JButton("发送(s)");
		jb44.setBackground(new Color(91, 88, 241));
		jb44.setPreferredSize(new Dimension(80,20));
		jb44.setMnemonic('s');
		jb44.addActionListener(this);
		jb44.setActionCommand("send");
		jp5.add(jb33,FlowLayout.LEFT);
		jp5.add(jb44);
		jta2= new JTextArea();
		scrol2=new JScrollPane(jta2);
		jp3.add(scrol2,BorderLayout.CENTER);
		jp3.add(jp5, BorderLayout.SOUTH);
		
		
		jp4 = new JPanel();
		jp4.add(right_im);
		jsp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp2, jp3);
		jsp1.setDividerSize(3);
		jsp1.setDividerLocation(290);
		jsp1.setOneTouchExpandable(true);
		jsp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp1, jp4);
		jsp2.setDividerLocation(445);
		jsp2.setDividerSize(9);
		jsp2.setOneTouchExpandable(true);
		jp1.add(jsp2);
		jsp2.setBounds(3, 88, 580, 417);
		
		
		this.add(jp1);
		this.setSize(585, 510);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-292, 
				Toolkit.getDefaultToolkit().getScreenSize().height/2-255);
		this.setIconImage(this.friend.getIcon().getImage());
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	public void showChatMessageToJta1(ChatMessage cm)
	{
		jta1.append(cm.getSender()+"   "+cm.getSendTime()+"\r\n");
		jta1.append(cm.getContent()+"\r\n");
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Point p = this.getLocationOnScreen();
		this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		if(arg0.getClickCount()==2)
		{
			this.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) 
	{
		origin.x = e.getX();
		origin.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("close"))
		{
			this.dispose();
		}
		else if(e.getActionCommand().equals("send"))
		{
			if(jta2.getText().equals(""))
			{
				
			}
			else
			{
				ChatMessage cm=new ChatMessage();
				cm.setSender(this.me.getIdcard());
				cm.setReceiver(this.friend.getIdcard());
				cm.setContent(jta2.getText());
				cm.setSendTime(new Date().toString());
				jta1.append(me.getNickname()+"    "+Calendar.getInstance().getTime().toString()+"\r\n");
				jta1.append(jta2.getText()+"\r\n");
				jta2.setText("");
				
				try 
				{
					ObjectOutputStream oos=new ObjectOutputStream
							(BridgeToServerThreadManage.getBridgeToServerThread(this.me.getIdcard()).getS().getOutputStream());
					oos.writeObject(cm);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
	}

}
