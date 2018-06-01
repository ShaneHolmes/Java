package view.se;
import java.awt.Graphics;
import java.awt.Image;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import model.se.Server;

import java.awt.event.*;
public class ServerPrimWin extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	Image im;
	BackImage bim;
	
	JPanel jp1, jp2;
	JTable jt;
	JScrollPane jsp1, jsp2;
	JTextArea jta;
	JButton jb1, jb2, jb3;
	Server server;
	
	public static void main(String [] args)
	{
		new ServerPrimWin();
	}

	public ServerPrimWin()
	{
		try {
			im=ImageIO.read(new File("material/sebackim.jpg"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		bim=new BackImage(im);
		bim.setLayout(new BorderLayout());
		jp1=new JPanel(new FlowLayout());
		jp1.setPreferredSize(new Dimension(1000,80));
		jp1.setOpaque(false);
		jp2=new JPanel(new BorderLayout());
		jp2.setPreferredSize(new Dimension(1000,120));
		jp2.setOpaque(false);
		
		jt=new JTable();
		jsp1=new JScrollPane(jt);
		jta=new JTextArea();
		jta.setBackground(null);
		jta.setOpaque(false);
		jsp2=new JScrollPane(jta);
		
		JButton jb1=new JButton("打开服务器");
		jb1.setPreferredSize(new Dimension(100, 60));
		jb1.addActionListener(this);
		JButton jb2=new JButton("关闭服务器");
		jb2.setPreferredSize(new Dimension(100, 60));
		jb2.addActionListener(this);
		JButton jb3=new JButton("发送公告");
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jsp2);
		jp2.add(jb3, BorderLayout.EAST);
		
		bim.add(jp1, BorderLayout.NORTH);
	//	bim.add(jsp1);
	//	bim.add(jp2, BorderLayout.SOUTH);
		
		this.add(bim);
		this.setSize(1000, 650);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==jb1)
		{
			server=new Server();
		}
		else if(e.getSource()==jb2)
		{
		//	server
		}
		
	}
}

class BackImage extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	Image im=null;
	public BackImage(Image im)
	{
		this.im=im;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(this.im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}