package io;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JFrameInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputFrame();

	}

}

class InputFrame extends JFrame{
	JTextField jtf=new JTextField(10);
	JButton jbt=new JButton("��ƽ��");
	JLabel jlb=new JLabel("���");
	
	public InputFrame()
	{
		setLayout(new FlowLayout());
		getContentPane().add(jtf);//�����������������
		getContentPane().add(jbt);
		getContentPane().add(jlb);
		
		jbt.addActionListener(new buttonListener());
		
	    this.setSize(400,100);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	class buttonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String s=jtf.getText();
			double d=Double.parseDouble(s);
			double sq=d*d;
			jlb.setText(d+"d��ƽ����"+sq);
		}
	}
}

