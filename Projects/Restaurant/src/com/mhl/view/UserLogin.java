package com.mhl.view;

import com.mhl.tools.*;
import com.mhl.model.*;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class UserLogin extends JFrame implements ActionListener {
	
	//Container ct;
	JLabel jl1,jl2,jl3;
	JTextField jtf1;
	JPasswordField jpf1;
	JButton jb1,jb2;
	
	
	public static void main(String[] args) {
		new UserLogin();
		
	}
	
	public UserLogin() {
		
		//Container容器，把各个组键加进去，先加在上面。Container就需要add.
		Container ct = this.getContentPane();
		this.setLayout(null);
		
		jl1 = new JLabel("请输入用户名: ");
		jl1.setFont(ToolFont.f1);
		jl1.setBounds(47, 170, 119, 20);
		ct.add(jl1);
		
		jl2 = new JLabel("(或员工号)");
		jl2.setFont(ToolFont.f3);
		jl2.setBounds(90, 185, 119, 20);
		jl2.setForeground(Color.red);
		ct.add(jl2);
		
		jtf1 = new JTextField();
		jtf1.setBounds(165, 165, 115, 30);
		jtf1.setFont(ToolFont.f1);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jtf1);
		
		jl3 = new JLabel("请输入密码: ");
		jl3.setFont(ToolFont.f1);
		jl3.setBounds(47, 218, 119, 20);
		ct.add(jl3);
		
		jpf1 = new JPasswordField();
		jpf1.setBounds(165, 213, 115, 30);
		jpf1.setFont(ToolFont.f1);
		jpf1.setEchoChar('*');
		jpf1.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpf1);
		
		jb1 = new JButton("登陆");
		jb1.setFont(ToolFont.f1);
		jb1.setBounds(86, 265, 80, 30);
		jb1.addActionListener(this);
		ct.add(jb1);
		
		jb2 = new JButton("取消");
		jb2.setFont(ToolFont.f1);
		jb2.setBounds(196, 265, 80, 30);
		jb2.addActionListener(this);
		ct.add(jb2);
		
		BackImage bi = new BackImage();
		bi.setBounds(0, 0, 348, 330);
		ct.add(bi);
		
		
		
		
		//this.add(ct);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(355, 365);
		this.setLocation(width/2-200,height/2-150);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("用户登陆");
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	class BackImage extends JPanel {
		Image im;
		public BackImage() {
			try {
				im = ImageIO.read(new File("image/UserLogin.JPG"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paint(Graphics g) {
			g.drawImage(im, 0, 0, 348, 330, this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			String userid = jtf1.getText().trim();
			String passwd = new String(jpf1.getPassword());
			UserModel um = new UserModel();
			String zhiwei = um.CheckUser(userid, passwd).trim();
			if(zhiwei.equals("经理")||zhiwei =="主管" ||zhiwei== "系统管理员") {
				new Windows1();
				this.dispose();
			}
			
		} else if(e.getSource() == jb2) {
			this.dispose();
		}
		
	}

}
