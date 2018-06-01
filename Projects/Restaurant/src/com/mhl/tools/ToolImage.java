package com.mhl.tools;
import java.awt.*;

//import javax.imageio.ImageIO;
import javax.swing.*;

public class ToolImage extends JPanel {
	Image im;
	
	public ToolImage(Image im) 
	{
		this.im = im;
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
