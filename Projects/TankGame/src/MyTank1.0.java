/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package tankGame;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
public class Game1 extends JFrame implements ActionListener,MouseListener
{
	private static final long serialVersionUID = 1L;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3;
	JMenuItem jmi1,jmi2,jmi3,jmi4;
	MyPanel mp;
	PrePanel pp=new PrePanel();
	//标记newgame的次数
	int count=0;
	
	public static void main(String[] args)
	{
		new Game1();
	}
	
	public Game1()
	{
		pp.jl1.addMouseListener(this);
		pp.jl2.addMouseListener(this);
		pp.jl3.addMouseListener(this);
		pp.jl4.addMouseListener(this);
		
		jmb=new JMenuBar();
		jm1=new JMenu("游戏（G）");
		jm1.setFont(new Font("宋体",Font.PLAIN,14));
		jm1.setMnemonic('G');
		jm2=new JMenu("查看（V）");
		jm2.setFont(new Font("宋体",Font.PLAIN,14));
		jm2.setMnemonic('V');
		jm3=new JMenu("帮助（H）");
		jm3.setFont(new Font("宋体",Font.PLAIN,14));
		jm3.setMnemonic('H');
		
		jmi1=new JMenuItem("开始游戏",new ImageIcon("images/start.jpg"));
		jmi1.setFont(new Font("宋体",Font.PLAIN,14));
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2=new JMenuItem("继续游戏",new ImageIcon("images/continue.jpg"));
		jmi2.setFont(new Font("宋体",Font.PLAIN,14));
		jmi3=new JMenuItem("设置游戏");
		jmi3.setFont(new Font("宋体",Font.PLAIN,14));
		jmi4=new JMenuItem("存档退出");
		jmi4.setFont(new Font("宋体",Font.PLAIN,14));
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.addSeparator();
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		
		this.setJMenuBar(jmb);
		this.add(pp);
		Thread t=new Thread(pp);
		t.start();
		
		this.setTitle("坦克大战小游戏");
		this.setIconImage(new ImageIcon("images/game.jpg").getImage());
		this.setSize(1100,665);
		this.setResizable(false);
		this.setLocation(100, 40);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("newgame"))
		{
			this.requestFocus();
			
			count++;
			if(count==1)
			{
				mp=new MyPanel();
				
				this.remove(pp);
				this.add(mp);
				Thread t=new Thread(mp);
				t.start();
				this.addKeyListener(mp);
				this.setVisible(true);
			}
			else
			{
				this.remove(mp);
				mp=new MyPanel();
				Thread t=new Thread(mp);
				t.start();
				this.add(mp);
				this.addKeyListener(mp);
				this.setVisible(true);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource()==pp.jl1)
		{
			count++;
			mp=new MyPanel();
			
			this.remove(pp);
			this.add(mp);
			Thread t=new Thread(mp);
			t.start();
			this.addKeyListener(mp);
			this.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		(new MusicPlayer("sounds/sort.wav")).start();
		JLabel jl=(JLabel)e.getSource();
		jl.setEnabled(true);
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		JLabel jl=(JLabel)e.getSource();
		jl.setEnabled(false);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

class PrePanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	boolean yes=true;
	
	JLabel jl1,jl2,jl3,jl4;
	
	BackImage bim=null;
	Image im=null;

	public void paint(Graphics g)
	{
		super.paint(g);
		if(yes)
		{
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文新魏",Font.BOLD,200));
			g.drawString("坦克大战", 100, 230);
		}
	}
	
	public PrePanel()
	{
		try 
		{
			im=ImageIO.read(new File("images/tanke.jpg"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		bim=new BackImage(im);
		
		Font font=new Font("华文行楷",Font.BOLD,25);
		jl1=new JLabel("开   始   游   戏");
		jl1.setFont(font);
		jl1.setForeground(Color.RED);
		jl1.setEnabled(false);
		jl2=new JLabel("继   续   上   局");
		jl2.setFont(font);
		jl2.setForeground(Color.RED);
		jl2.setEnabled(false);
		jl3=new JLabel("联   机   作   战");
		jl3.setFont(font);
		jl3.setForeground(Color.RED);
		jl3.setEnabled(false);
		jl4=new JLabel("关   闭   游   戏");
		jl4.setFont(font);
		jl4.setForeground(Color.RED);
		jl4.setEnabled(false);
		
		this.setLayout(null);
		this.add(bim, -1);
		this.add(jl1, 0);
		this.add(jl2, 0);
		this.add(jl3, 0);
		this.add(jl4, 0);
		bim.setBounds(0, 0, 1100, 665);
		jl1.setBounds(450, 320, 200, 40);
		jl2.setBounds(450, 375, 200, 40);
		jl3.setBounds(450, 430, 200, 40);
		jl4.setBounds(450, 485, 200, 40);
	}

	public void run() 
	{
		int time=-1;
		while(++time<40)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yes=!yes;
			this.repaint();
		}
		
	}
	
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	private static final long serialVersionUID = 1L;
	
//	MusicPlayer music;
	
    Hero hero=null;
    
    Vector<Enemy> vem=new Vector<Enemy>();
    int ensize=6;
    
    //炸弹向量
    Vector<Bomb> vbb=new Vector<Bomb>();
    Image image1=null;
    Image image2=null;
    Image image3=null;
    
    public MyPanel()
    {
//		music=new MusicPlayer("sounds/kaishi.mp3");
//		music.start();
    	hero=new Hero(410,560);
    	hero.setVe(vem);
    	
    	for(int i=0;i<ensize;i++)
    	{
    		Enemy em=new Enemy(i*100,0);
    		em.setHe(hero);
    		Thread t=new Thread(em);
    		t.start();
    		vem.add(em);
    		em.setEts(vem);
    	}
    	
    	try
    	{
    		image1=ImageIO.read(new File("images/b1.gif"));
        	image2=ImageIO.read(new File("images/b2.gif"));
        	image3=ImageIO.read(new File("images/b3.gif"));
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.fillRect(0, 0, 900, 600);
		this.showinfo(g);
		
		if(this.hero.isLive())
		{
			this.drawTank(this.hero.getX(), this.hero.getY(), g, this.hero.dir, 0);
		}
		
		for(int i=0;i<this.hero.vbul.size();i++)
		{
			Bullet bt=hero.vbul.get(i);
			if(bt.isLive())
			{
				g.fill3DRect(bt.getX(), bt.getY(), 4, 4, true);
			}
			else
			{
				this.hero.vbul.remove(bt);
			}
		}
		
		for(int i=0;i<vbb.size();i++)
		{
			Bomb bomb=vbb.get(i);
			if(bomb.getLife()>6)
			{
				g.drawImage(image1, bomb.getX(), bomb.getY(), 40, 40, this);
			}
			else if(bomb.getLife()>3)
			{
				g.drawImage(image2, bomb.getX(), bomb.getY(), 40, 40, this);
			}
			else if(bomb.getLife()>0)
			{
				g.drawImage(image3, bomb.getX(), bomb.getY(), 40, 40, this);
			}
			else
			{
				vbb.remove(bomb);
			}
			bomb.lifedown();
		}
		
		//画敌人坦克和子弹
		for(int i=0;i<this.vem.size();i++)
		{
			Enemy en=this.vem.get(i);
			//画子弹
			g.setColor(Color.CYAN);
			for(int j=0;j<en.vbul.size();j++)
			{
				Bullet bt=en.vbul.get(j);
				if(bt.isLive())
				{
					g.fill3DRect(bt.getX(), bt.getY(), 4, 4, true);
				}
				else
				{
					en.vbul.remove(bt);
				}
			}
			//画敌人坦克
			if(en.isLive())
			{
				this.drawTank(en.getX(), en.getY(),g, en.getDir(), 1);
			}
			else
			{
				this.vem.remove(en);
			}
		}
	}

	//显示信息
	public void showinfo(Graphics g)
	{
		g.setFont(new Font("楷体",Font.BOLD,22));
		g.setColor(Color.RED);
		g.drawString("游戏基本信息", 930, 40);
		this.drawTank(930, 60, g, 0, 1);
		this.drawTank(930, 130, g, 0, 0);
		this.drawTank(930, 500, g, 0, 2);
		g.setColor(Color.black);
		g.drawString("20", 1000, 87);
		g.drawString("5", 1000, 157);
		g.drawString("15", 1000, 527);
	}
	
	//判断子弹是否击中坦克
	public void hitTank(Bullet bul,Tank tk)
	{
		if(bul.getX()>tk.getX()&&bul.getX()<tk.getX()+40&&bul.getY()>tk.getY()&&bul.getY()<tk.getY()+40)
		{
			bul.setLive(false);
			tk.setLive(false);
			Bomb b=new Bomb(tk.getX(),tk.getY());
			this.vbb.add(b);
		}
	}
	
	public void drawTank(int x,int y,Graphics g,int dir,int type)
	{
		
		switch(type)
		{
		case 0:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.CYAN);
			break;
		case 2:
			g.setColor(Color.green);
		}
		
		switch(dir)
		{
		case 0:
			g.fill3DRect(x, y, 10, 40, true);
			g.fill3DRect(x+30, y, 10, 40, true);
			g.fill3DRect(x+10, y+4, 20, 32, true);
			g.fill3DRect(x+18, y, 4, 22, true);
			break;
		case 1:
			g.fill3DRect(x, y, 40, 10, true);
			g.fill3DRect(x, y+30, 40, 10, true);
			g.fill3DRect(x+4, y+10, 32, 20, true);
			g.fill3DRect(x+18, y+18, 22, 4, true);
			break;
		case 2:
			g.fill3DRect(x, y, 10, 40, true);
			g.fill3DRect(x+30, y, 10, 40, true);
			g.fill3DRect(x+10, y+4, 20, 32, true);
			g.fill3DRect(x+18, y+18, 4, 22, true);
			break;
		case 3:
			g.fill3DRect(x, y, 40, 10, true);
			g.fill3DRect(x, y+30, 40, 10, true);
			g.fill3DRect(x+4, y+10, 32, 20, true);
			g.fill3DRect(x, y+18, 22, 4, true);
			break;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(this.hero.getDir()!=0)
			{
				this.hero.setDir(0);
			}
			else if(!this.hero.touchenemy())
			{
				this.hero.moveUp();
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(this.hero.getDir()!=1)
			{
				this.hero.setDir(1);
			}
			else if(!this.hero.touchenemy())
			{
				this.hero.moveRight();
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(this.hero.getDir()!=2)
			{
				this.hero.setDir(2);
			}
			else if(!this.hero.touchenemy())
			{
				this.hero.moveDown();
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(this.hero.getDir()!=3)
			{
				this.hero.setDir(3);
			}
			else if(!this.hero.touchenemy())
			{
				this.hero.moveLeft();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_F&&this.hero.isLive())
		{
			if(this.hero.vbul.size()<this.hero.bulsize)
			{
				this.hero.fire();
				(new MusicPlayer("sounds/fire.mp3")).start();
			}
		}
		
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}


	public void run() 
	{
		while(true)
		{
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			for(int i=0;i<vem.size();i++)
			{
				Enemy em=vem.get(i);
				for(int j=0;j<hero.vbul.size();j++)
				{
					Bullet be=hero.vbul.get(j);
					if(be.isLive())
					{
						this.hitTank(be, em);
					}
				}
				
				if(this.hero.isLive())
				{
					for(int k=0;k<em.vbul.size();k++)
					{
						if(em.vbul.get(k).isLive())
						{
							this.hitTank(em.vbul.get(k), this.hero);
						}
					}
				}
			}
			
			this.repaint();
		}
		
	}
	
}

class Bomb
{
	int x;
	int y;
	int life=9;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void lifedown()
	{
		life--;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}

class Bullet implements Runnable
{
	int x;
	int y;
	int direction;
	int speed=5;
	int sle=50;
	boolean live=true;
	
	public Bullet(int x,int y,int direction)
	{
		this.x=x;
		this.y=y;
		this.direction=direction;
	}

	public void run() 
	{
		while(live)
		{
			try {
				Thread.sleep(sle);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			switch(this.direction)
			{
			case 0:
				this.y-=this.speed;
				break;
			case 1:
				this.x+=this.speed;
				break;
			case 2:
				this.y+=this.speed;
				break;
			case 3:
				this.x-=this.speed;
				break;
			}
			
			if(x<0||x>900||y<0||y>600)
			{
				this.live=false;
			}
		}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}

class Tank
{
	int x=0;
	int y=0;
	int speed=3;
	int dir=0;
	int type=0;

	boolean live=true;
	Vector<Bullet> vbul=new Vector<Bullet>();
	Bullet bul=null;
	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void fire()
	{
		switch(this.dir)
		{
		case 0: 
			bul=new Bullet(x+18,y,0);
			break;
		case 1:
			bul=new Bullet(x+36,y+18,1);
			break;
		case 2:
			bul=new Bullet(x+18,y+36,2);
			break;
		case 3:
			bul=new Bullet(x,y+18,3);
			break;
		}
		
		vbul.add(bul);
		
		Thread t=new Thread(bul);
		t.start();
	}
	
	public void moveUp()
	{
		if(this.y-speed>0)
		{
			this.y-=speed;
		}
		else
		{
			this.y=0;
		}
	}
	public void moveLeft()
	{
		if(this.x-speed>0)
		{
			this.x-=speed;
		}
		else
		{
			this.x=0;
		}
		
	}
	public void moveDown()
	{
		if(this.y+speed<560)
		{
			this.y+=speed;
		}
		else
		{
			this.y=560;
		}
	}
	public void moveRight()
	{
		if(this.x+speed<860)
		{
			this.x+=speed;
		}
		else
		{
			this.x=860;
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
}

class Hero extends Tank
{
	Vector<Enemy> ve;
	int bulsize=8;
	
	public Hero(int x,int y)
	{
		super(x, y);
	}
	
	public boolean touchenemy()
	{
		int dx,dy;
		switch(this.getDir())
		{
		case 0:
			for(int i=0;i<ve.size();i++)
			{
				Enemy em=ve.get(i);
				dx=this.getX()-em.getX();
				dy=this.getY()-em.getY();
				if(dy>0&&Math.abs(dx)<40&&(dy-this.getSpeed()<40))
				{
					return true;
				}
			}
			break;
		case 1:
			for(int i=0;i<ve.size();i++)
			{
				Enemy em=ve.get(i);
				dx=this.getX()-em.getX();
				dy=this.getY()-em.getY();
				if(dx<0&&Math.abs(dy)<40&&(dx+this.getSpeed()>-40))
				{
					return true;
				}
			}
			break;
		case 2:
			for(int i=0;i<ve.size();i++)
			{
				Enemy em=ve.get(i);
				dx=this.getX()-em.getX();
				dy=this.getY()-em.getY();
				if(dy<0&&Math.abs(dx)<40&&(dy+this.getSpeed()>-40))
				{
					return true;
				}
			}
			break;
		case 3:
			for(int i=0;i<ve.size();i++)
			{
				Enemy em=ve.get(i);
				dx=this.getX()-em.getX();
				dy=this.getY()-em.getY();
				if(dx>0&&Math.abs(dy)<40&&(dx-this.getSpeed()<40))
				{
					return true;
				}
			}
			break;
		}
		return false;
	}

	public Vector<Enemy> getVe() {
		return ve;
	}

	public void setVe(Vector<Enemy> ve) {
		this.ve = ve;
	}
	
}

class Enemy extends Tank implements Runnable
{
	int bulsize=3;
	
	int sle=150;
	//定义一个向量用来访问MyPane的所有敌人向量
	Vector<Enemy> ets=new Vector<Enemy>();
	//定义一个hero用来访问面板的hero
	Hero he;
	
	public Enemy(int x,int y)
	{
		super(x,y);
		this.dir=2;
	}
	
	//判断是否碰到别的坦克
	public boolean touchTank()
	{
		int dx=this.getX()-he.getX();
	    int dy=this.getY()-he.getY();
		switch(this.getDir())
		{
		case 0:
			if(dy>0&&Math.abs(dx)<40&&(dy-this.getSpeed()<40))
			{
				return true;
			}
			for(int i=0;i<ets.size();i++)
			{
				Enemy etk=ets.get(i);
				dx=this.getX()-etk.getX();
				dy=this.getY()-etk.getY();
				if(etk!=this)
				{
					if(dy>0&&Math.abs(dx)<40&&(dy-this.getSpeed()<40))
					{
						return true;
					}
				}
			}
			break;
		case 1:
			if(dx<0&&Math.abs(dy)<40&&(dx+this.getSpeed()>-40))
			{
				return true;
			}
			for(int i=0;i<ets.size();i++)
			{
				Enemy etk=ets.get(i);
				dx=this.getX()-etk.getX();
				dy=this.getY()-etk.getY();
				if(etk!=this)
				{
					if(dx<0&&Math.abs(dy)<40&&(dx+this.getSpeed()>-40))
					{
						return true;
					}
				}
			}
			break;
		case 2:
			if(dy<0&&Math.abs(dx)<40&&(dy+this.getSpeed()>-40))
			{
				return true;
			}
			for(int i=0;i<ets.size();i++)
			{
				Enemy etk=ets.get(i);
				dx=this.getX()-etk.getX();
				dy=this.getY()-etk.getY();
				if(etk!=this)
				{
					if(dy<0&&Math.abs(dx)<40&&(dy+this.getSpeed()>-40))
					{
						return true;
					}
				}
			}
			break;
		case 3:
			if(dx>0&&Math.abs(dy)<40&&(dx-this.getSpeed()<40))
			{
				return true;
			}
			for(int i=0;i<ets.size();i++)
			{
				Enemy etk=ets.get(i);
				dx=this.getX()-etk.getX();
				dy=this.getY()-etk.getY();
				if(etk!=this)
				{
					if(dx>0&&Math.abs(dy)<40&&(dx-this.getSpeed()<40))
					{
						return true;
					}
				}
			}
			break;
		}
		return false;
	}

	
	
	public Vector<Enemy> getEts() {
		return ets;
	}

	public void setEts(Vector<Enemy> ets) {
		this.ets = ets;
	}

	public Hero getHe() {
		return he;
	}

	public void setHe(Hero he) {
		this.he = he;
	}

	public void run() 
	{
		while(live)
		{
			switch(this.dir)
			{
			case 0:
				for(int i=0;i<Math.random()*5+10;i++)
				{
					if(!this.touchTank())
					this.moveUp();
					try {
						Thread.sleep(sle);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				break;
			case 1:
				for(int i=0;i<Math.random()*5+10;i++)
				{
					if(!this.touchTank())
					this.moveRight();
					try {
						Thread.sleep(sle);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				break;
			case 2:
				for(int i=0;i<Math.random()*5+10;i++)
				{
					if(!this.touchTank())
					this.moveDown();
					try {
						Thread.sleep(sle);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for(int i=0;i<Math.random()*5+10;i++)
				{
					if(!this.touchTank())
					this.moveLeft();
					try {
						Thread.sleep(sle);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				break;
			}
			
			this.dir=(int)(Math.random()*4);
			if(Math.random()*5>1&&this.vbul.size()<this.bulsize)
			{
				this.fire();
			}
			
		}
		
	}

}

class MusicPlayer extends Thread
{
	private String filepath;
	public MusicPlayer(String filepath)
	{
		this.filepath=filepath;
	}
	
	public void run()
	{
		File sound=new File(filepath);
		
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(sound);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}

	}
}
