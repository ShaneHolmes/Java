package client.jiemian;
import net.user.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import client.model.*;
public class PrimWin extends JFrame implements ActionListener, MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	
	Point origin=new Point();
	
	int fsize=0;
	User master;
	JPanel []greatfrid;
	Dimension dim;
	Font font;
	
	JTabbedPane jtp_friend;
	JPanel jp_back, jp_friend1, jp_friend2, jp_friend3, jp_friend4, jp_friend5;
	JScrollPane jsp1,jsp2,jsp3,jsp4,jsp5;
	JTextField jtf_search, jtf_signature;
	JLabel jl_headim, jl_logo, jl_nickname;
	JButton jb_close, jb_min;
	
	public PrimWin(User master)
	{
		this.master=master;
		fsize=this.master.getMyfriend().size();
		greatfrid=new JPanel[fsize];
		dim=new Dimension(255, 53);
		font=new Font("宋体", Font.PLAIN, 13);
		
		//创建背景面板
		jp_back=new JPanel(null);
		jp_back.setBackground(new Color(32, 158, 219));
		jp_back.addMouseMotionListener(this);
		jp_back.addMouseListener(this);
		
		//创建北部组件
		jl_logo=new JLabel(new ImageIcon("images/logoprim.png"));
		jb_min=new JButton(new ImageIcon("images/minprim.png"));
		jb_min.setBorder(null);
		jb_min.addActionListener(this);
		jb_min.setActionCommand("tomin");
		jb_close=new JButton(new ImageIcon("images/closeprim.png"));
		jb_close.setBorder(null);
		jb_close.addActionListener(this);
		jb_close.setActionCommand("exit");
		jl_headim=new JLabel(this.master.getIcon());
		jl_nickname=new JLabel(this.master.getNickname());
		jl_nickname.setForeground(Color.WHITE);
		jl_nickname.setFont(new Font("宋体", Font.BOLD, 15));
		jtf_search=new JTextField("搜索好友：");
		jtf_search.setBorder(null);
		jtf_search.setBackground(new Color(21, 127, 178));
		jtf_signature=new JTextField(this.master.getSignature());
		jtf_signature.setFont(new Font("宋体", Font.PLAIN, 12));
		jtf_signature.setForeground(Color.WHITE);
		jtf_signature.setBorder(null);
		jtf_signature.setEditable(false);
		jtf_signature.setBackground(null);
		
		//创建中间部分组件
		jtp_friend=new JTabbedPane();
		jp_friend1=new JPanel(new GridLayout(15, 1));
		jp_friend1.setBackground(Color.WHITE);
		jp_friend2=new JPanel();
		jp_friend2=new JPanel(new GridLayout(15, 1));
		jp_friend2.setBackground(Color.WHITE);
		jp_friend3=new JPanel();
		jp_friend3=new JPanel(new GridLayout(15, 1));
		jp_friend3.setBackground(Color.WHITE);
		jp_friend4=new JPanel();
		jp_friend4=new JPanel(new GridLayout(15, 1));
		jp_friend4.setBackground(Color.WHITE);
		jp_friend5=new JPanel();
		jp_friend5=new JPanel(new GridLayout(15, 1));
		jp_friend5.setBackground(Color.WHITE);
		//处理好友选项卡
		jsp1=new JScrollPane(jp_friend1);
		jsp2=new JScrollPane(jp_friend2);
		jsp3=new JScrollPane(jp_friend3);
		jsp4=new JScrollPane(jp_friend4);
		jsp5=new JScrollPane(jp_friend5);
		jtp_friend.add("同窗", jsp1);
		jtp_friend.add("故友", jsp2);
		jtp_friend.add("袍泽", jsp3);
		jtp_friend.add("家人", jsp4);
		jtp_friend.add("同事", jsp5);
		for(int i=0;i<fsize;i++)
		{
			ContactMen f = this.master.getMyfriend().get(i);
			JLabel jl1=new JLabel(f.getIcon());
			JLabel jl2=new JLabel();
			jl2.setFont(font);
			JLabel jl3=new JLabel(f.getSignature());
			jl3.setFont(font);
			if(f.getMarkname()!=null)
			{
				jl2.setText(f.getMarkname()+"("+f.getNickname()+")");
			}
			else
			{
				jl2.setText(f.getNickname());
			}
			
			greatfrid[i]=new JPanel();
			greatfrid[i].setBackground(null);
			greatfrid[i].setLayout(null);
			greatfrid[i].setPreferredSize(dim);
			greatfrid[i].add(jl1);
			greatfrid[i].add(jl2);
			greatfrid[i].add(jl3);
			jl1.setBounds(5, 5, 40, 40);
			jl2.setBounds(50,5, 180, 20);
			jl3.setBounds(50,25, 220, 20);
			greatfrid[i].addMouseListener(this);
			switch(f.getType())
			{
			case "1":
				jp_friend1.add(greatfrid[i]);
				break;
			case "4":
				jp_friend4.add(greatfrid[i]);
				break;
			}
		}
		
		//添加组件到背景面板并设置位置
		jp_back.add(jl_logo);
		jp_back.add(jb_min);
		jp_back.add(jb_close);
		jp_back.add(jl_headim);
		jp_back.add(jl_nickname);
		jp_back.add(jtf_signature);
		jp_back.add(jtf_search);
		jp_back.add(jtp_friend);
		
		jl_logo.setBounds(5, 2, 45, 20);
		jb_min.setBounds(230, 0, 25, 20);
		jb_close.setBounds(255, 0, 25, 20);
		jl_headim.setBounds(9, 43, 60, 60);
		jl_nickname.setBounds(76, 43, 120, 18);
		jtf_signature.setBounds(76,65, 135, 18);
		jtf_search.setBounds(0, 110, 280, 30);
		jtp_friend.setBounds(0, 143, 280, 490);
		
		this.add(jp_back);
		this.setSize(280, 675);
		this.setLocation(200, 0);
		this.setIconImage((new ImageIcon("images/logo.jpg")).getImage());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent m) 
	{
		for(int i=0;i<fsize;i++)
		{
			if(m.getSource()==greatfrid[i]&&m.getClickCount()==2)
			{
				ContactMen f = this.master.getMyfriend().get(i);
				if(f.getIdcard().equals(this.master.getIdcard()))
				{
					//不能与自己聊天
					JOptionPane.showMessageDialog(this, "不能与自己聊天");
				}
				else
				{
					ChatWin cw=new ChatWin(this.master, f);
					ChatWinManage.addChat(this.master.getIdcard()+f.getIdcard(), cw);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent m) 
	{
		for(int i=0;i<this.fsize;i++)
		{
			if(m.getSource()==greatfrid[i])
			{
				greatfrid[i].setBackground(new Color(252,240,193));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent m) 
	{
		for(int i=0;i<this.fsize;i++)
		{
			if(m.getSource()==greatfrid[i])
			{
				greatfrid[i].setBackground(null);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		origin.x=e.getX();
		origin.y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Point p=this.getLocationOnScreen();
		this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("exit"))
		{
			try 
			{
				BridgeToServerThreadManage.getBridgeToServerThread(this.master.getIdcard()).getS().close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BridgeToServerThreadManage.deleteBridgeToServerThread(this.master.getIdcard());
			System.exit(0);
		}
		else if(e.getActionCommand().equals("tomin"))
		{
			this.setExtendedState(JFrame.ICONIFIED);
		}
	}

}
