package client.jiemian;
import java.awt.*;
import net.user.*;
import javax.swing.*;

import client.model.BridgeToServer;

import java.awt.event.*;
public class Verify extends JFrame implements MouseMotionListener,MouseListener,ActionListener
{
	private static final long serialVersionUID = 1L;

	//用以实现窗口拖动，记录鼠标点击的初始位置
	Point origin = new Point();
	
	JPanel jp;
	JTextField jtf;
	JPasswordField jpf;
	JCheckBox jcb1,jcb2;
	JButton jb1,jb2,jb3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	
	public static void main(String[] args)
	{
		new Verify();
	}
	
	public Verify()
	{
		jp = new JPanel();
		jp.setLayout(null);
		jp.addMouseListener(this);
		jp.addMouseMotionListener(this);
		jp.setBackground(new Color(235,242,249));
		
		jl1 = new JLabel(new ImageIcon("images/vwim.gif"));
		jl2 = new JLabel("注册账号",JLabel.CENTER);
		jl2.setForeground(new Color(97, 179, 246));
		jl2.setFont(new Font("宋体", Font.PLAIN,13));
		jl2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl3 = new JLabel("找回密码",JLabel.CENTER);
		jl3.setForeground(new Color(97, 179, 246));
		jl3.setFont(new Font("宋体", Font.PLAIN,13));
		jl3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl4 = new JLabel(new ImageIcon("images/dzh.jpg"));
		jl5 = new JLabel(new ImageIcon("images/erweima.png"));
		jl6 = new JLabel(new ImageIcon("images/xidianlog.png"));
		
		jtf = new JTextField();
		jtf.setText(" 账号/手机/邮箱");
//		jtf.setBackground(null);
		jtf.setForeground(Color.gray);
		jtf.setFont(new Font("宋体",Font.PLAIN,12));
		jtf.setBorder(BorderFactory.createLoweredBevelBorder());
		jtf.addFocusListener(new FocusListener()
		{
	          public void focusLost(FocusEvent e)
	          {
	        	  if(jtf.getText().trim().equals(""))
	        	  {
	        		  jtf.setForeground(Color.gray);
	        		  jtf.setFont(new Font("宋体",Font.PLAIN,12));
	        		  jtf.setText(" 账号/手机/邮箱");
	        	  }
	          }
	          public void focusGained(FocusEvent e)
	          {
	        	  if(jtf.getText().trim().equals("账号/手机/邮箱"))
	        	  {
	        		  jtf.setText("");
	        		  jtf.setFont(new Font("宋体",Font.BOLD,16));
	        		  jtf.setForeground(Color.black);
	        	  }
	          }
		});
		
		
		jpf = new JPasswordField();
		jpf.setText(" 密码");
		jpf.setEchoChar('\0');
		jpf.setForeground(Color.gray);
		jpf.setFont(new Font("宋体",Font.PLAIN,12));
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		jpf.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e) {
				String str=new String(jpf.getPassword());
				if(str.trim().equals("密码"))
				{
					jpf.setText("");
					char c=0x00B7;
					jpf.setEchoChar(c);
					jpf.setFont(new Font("Cambria",Font.BOLD,26));
					jpf.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				String str=new String(jpf.getPassword());
				if(str.trim().equals(""))
				{
					jpf.setText(" 密码");
					jpf.setFont(new Font("宋体",Font.PLAIN,12));
					jpf.setForeground(Color.gray);
					jpf.setEchoChar('\0');
				}
				
			}
	      
		});
		
		jcb1 = new JCheckBox("记住密码");
		jcb2 = new JCheckBox("自动登录");
		
		jb1 = new JButton("\u03a6");
		jb1.setFont(new Font("宋体", Font.BOLD, 16));
		jb1.setForeground(Color.WHITE);
		jb1.setOpaque(false);
		jb1.setBackground(null);
		jb1.setBorder(null);
		jb1.addActionListener(this);
		jb2 = new JButton("\u03A9");
		jb2.setFont(new Font("宋体", Font.BOLD, 16));
		jb2.setForeground(Color.WHITE);
		jb2.setBackground(null);
		jb2.setOpaque(false);
		jb2.setBorder(null);
		jb2.addActionListener(this);
		jb3 = new JButton("登    录");
		jb3.addActionListener(this);//添加事件
		jb3.setBorder(null);
		jb3.setForeground(Color.WHITE);
		jb3.setBackground(new Color(9, 163, 220));
		

		//添加组件
		jp.add(jl1,-1);
		jl1.setBounds(0,0,430,181);
		jp.add(jl2);
		jl2.setBounds(336, 195, 62, 27);
		jp.add(jl3);
		jl3.setBounds(336, 222, 62, 27);
		jp.add(jl4);
		jl4.setBounds(5, 297, 29, 28);
		jp.add(jl5);
		jl5.setBounds(396, 297, 29, 28);
		jp.add(jl6,-1);
		jl6.setBounds(42, 193, 80, 80);

		jp.add(jtf);
		jtf.setBounds(133, 195, 193, 27);
		jp.add(jpf);
		jpf.setBounds(133, 222, 193, 27);

		jp.add(jcb1);
		jcb1.setBounds(131, 260, 80, 16);
		jp.add(jcb2);
		jcb2.setBounds(251, 260, 80, 16);

		jp.add(jb1,0);
		jb1.setBounds(370, 0, 30, 30);
		jp.add(jb2,0);
		jb2.setBounds(400, 0, 30, 30);
		jp.add(jb3);
		jb3.setBounds(133, 287, 193, 31);
		
		this.add(jp);
		this.setSize(430,330);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-215,
				Toolkit.getDefaultToolkit().getScreenSize().height/2-175);
		this.setIconImage((new ImageIcon("images/logo.jpg")).getImage());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		Point p = this.getLocationOnScreen();
		this.setLocation(p.x+arg0.getX()-origin.x , p.y+arg0.getY()-origin.y);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		origin.x = arg0.getX();
		origin.y = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==jb1)
		{
			this.setExtendedState(Frame.ICONIFIED);
		}
		else if(arg0.getSource()==jb2)
		{
			System.exit(0);
		}
		else if(arg0.getSource()==jb3)
		{
			String uid=jtf.getText();
			String password=new String(jpf.getPassword());
			VerifyMessage vm=new VerifyMessage(uid,password);
			User master=new BridgeToServer().sendVMToServer(vm);
			if(master!=null)
			{
				new PrimWin(master);
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "用户名密码错误！");
			}
			
		}
	}

}
