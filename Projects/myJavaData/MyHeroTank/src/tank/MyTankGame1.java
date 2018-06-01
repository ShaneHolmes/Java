/*
 * 功能:实现坦克游戏
 * 1.画出坦克
 * 2.我的坦克可以上下左右移动
 */
package tank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame1 extends JFrame{

	//声明面板组件
	MyPanel mypanel=null;
	
	//构造函数
	public MyTankGame1()
	{
		//创建组件面板
		mypanel=new MyPanel();
		
		//添加面板
		this.add(mypanel);
		
		//注册监听
		this.addKeyListener(mypanel);
		
		//启动线程
		Thread t=new Thread(mypanel);
		t.start();
		
		//设置窗口属性
		this.setTitle("坦克帝国");
		this.setSize(1600,1000);
		this.setLocation(200,10);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyTankGame1 demo=new MyTankGame1();
	}

}


//定义一个我自己的面板,面板作为一个线程，用来刷新面板，才能显示出子弹的运动轨迹。创建线程之后，应在 MyTankGame1中启动线程
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我自己的坦克
	Hero hero=null;
	
	//定义三张图片，用来实现爆炸效果
	Image image1=null;
	Image image2=null;
	Image image3=null;
	
	//定义炸弹集合
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	//定义敌人的坦克组
	Vector<EnermyTank> enermytanks=new Vector<EnermyTank>();
	
	int enermytanksize=6;//定义敌人坦克数量
	
	//构造函数
	public MyPanel()
	{
		hero=new Hero(800,500);
		
		//初始化图片
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b3.gif"));
		
		//初始敌人的坦克
		for(int i=0;i<enermytanksize;i++)
		{
			EnermyTank enermytank=new EnermyTank((i+1)*200,0);//创建一辆敌人的坦克
			enermytank.setColor(0);
			enermytank.setDirect(2);
			enermytanks.add(enermytank);//把enermytank添加到集合Vector 对象enermytanks中去
		
			//给敌人的坦克添加一颗子弹
			Shot shot=new Shot(enermytank.x+20,enermytank.y+60,2);
			enermytank.shots.add(shot);
			Thread thread1=new Thread(shot);
			thread1.start();
			
		    //启动敌人坦克的线程
			Thread thread=new Thread(enermytank);
			thread.start();
		}
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 1600, 1000);//画出背景
		g.setColor(Color.DARK_GRAY);
		g.fillRect(200,200,300,70);
		g.fillRect(430,250,70,260);
		g.fillRect(200,500,300,70);
		g.fillRect(200,550,70,250);
		g.fillRect(200,750,300,70);
		
		g.fillRect(550,200,300,60);
		g.fillRect(550,200,60,600);
		g.fillRect(790,200,60,600);
		g.fillRect(550,740,300,60);
		
		g.fillRect(930,200,60,600);
		
		g.fillRect(1050,200,300,70);
		g.fillRect(1050,200,70,600);
		g.fillRect(1050,500,300,70);
		g.fillRect(1280,500,70,250);
		g.fillRect(1050,750,300,70);
		
		
		
		if(this.hero.isLive)
		{
			//画出自己的坦克
		    this.drawTank(hero.getX(),hero.getY(),g,this.hero.direct,1);
		}
		
	    
		//从shots中取出每一颗子弹并画出这颗子弹
		for(int i=0;i<hero.shots.size();i++)
		{
			Shot myshot=hero.shots.get(i);
		    //画出子弹,花出一颗子弹
		    if(myshot!=null&&myshot.isLive==true)//当按下f键之后才画出子弹。一开始没按下的时候，hero.shot==null，这时 画出子弹会抛出异常;子弹出边界之后不再绘制
		    {
			g.draw3DRect(myshot.x,myshot.y, 1, 1, false);
		    }
		    
		    if(myshot.isLive==false)//Vector<>中这颗子弹已经死亡，将其从Vector中移除
		    {
		    	hero.shots.remove(myshot);//要将这颗死亡的子弹移除，不能使用i变量
		    }
		}
		
		//画出炸弹
		for(int i=0;i<bombs.size();i++)
		{
			//取出炸弹
			Bomb bomb=bombs.get(i);
			
			if(bomb.life>9)
			{
				g.drawImage(image1, bomb.x, bomb.y,80,80,this);
			}
			else if(bomb.life>5)
			{
				g.drawImage(image2, bomb.x, bomb.y,80,80,this);
			}
			else 
			{
				g.drawImage(image3, bomb.x, bomb.y,80,80,this);
			}
			//让bomb生命值减少
			bomb.lifeDown();
			//如果炸弹生命值为0，九江炸弹从Vector中去掉
			if(bomb.life==0)
			{
				bombs.remove(bomb);
			}
		}
		
		
		
		
		
		
		//画出敌人的坦克,并画出子弹
		for(int i=0;i<enermytanks.size();i++)//这里用i<enermytanks.size()，因为当一辆坦克打掉后，Vector集合类的enermytanks.size()==enermytanksize-1，只需要绘制
		{
			EnermyTank enermytank=enermytanks.get(i);
			if(enermytank.isLive)
			{
				this.drawTank(enermytanks.get(i).getX(),enermytanks.get(i).getY(),g,enermytanks.get(i).getDirect(),0);
			    for(int j=0;j<enermytank.shots.size();j++)
			    {
			    	//取出子弹
			    	Shot enermyshot=enermytank.shots.get(j);
			    	//画出子弹
			    	if(enermyshot.isLive)
			    	{
			    		g.draw3DRect(enermyshot.x, enermyshot.y, 1, 1, false);
			    	}
			    	else
			    	{
			    		//如果敌人坦克的子弹死亡，就从Vector中去掉
			    		enermytank.shots.remove(enermyshot);
			    	}
			    }
			}
			
		}
	}
	
	
	
	
	
	/*
	 * 写一个函数，用来判断子弹是否击中坦克*/
	public void hitTank(Shot shot,Tank tank)//参数为子弹以及坦克，读取它们的坐标，根据子弹是否在坦克坐标范围之内来判断是否击中坦克
	{
		//由于坦克的方向不同，导致坦克坐标位置以及其范围的不同，因此先判断所传入的当前坦克的位置
		switch(tank.direct)
		{
		//坦克方向向上或者向下
		case 0:
		case 2:
			if(shot.x>tank.x&&shot.x<tank.x+40&&shot.y>tank.y&&shot.y<tank.y+60)//子弹在坦克这个范围之内，即说明打中坦克
			{
				//子弹死亡
				shot.isLive=false;
				//坦克死亡
				tank.isLive=false;
				//创建一颗炸弹,放入Vrctor
				Bomb bomb=new Bomb(tank.x,tank.y);
				bombs.add(bomb);
		
			}
			//坦克方向向左或者向右
		case 1:
		case 3:
			if(shot.x>tank.x&&shot.x<tank.x+60&&shot.y>tank.y&&shot.y<tank.y+40)//子弹在坦克这个范围之内，即说明打中坦克
			{
				//子弹死亡
				shot.isLive=false;
				//坦克死亡
				tank.isLive=false;			
				//创建一颗炸弹,放入Vrctor
				Bomb bomb=new Bomb(tank.x,tank.y);
				bombs.add(bomb);	
			}
		}
	}

	/*
	 * 写一个函数，判断我的子弹是否击中敌人的坦克*/
	public void hitEnermyTank()
	{
		//判断是否击中
		for(int i=0;i<hero.shots.size();i++)
		{
			//取出子弹
			Shot myshot=hero.shots.get(i);
			//判断子弹是否有效
			if(myshot.isLive)
			{
				//取出每个坦克与其比较，看看其子弹是否在坦克的范围之内，如果是，则说明击中
				{
					for(int j=0;j<enermytanks.size();j++)//注意是j++
					{
						//首先取出坦克
						EnermyTank enermytank=enermytanks.get(j);
						
						if(enermytank.isLive)
						{
							this.hitTank(myshot, enermytank);
						}
						
					}
				}
			}
		}
	}
	
	
	/*
	 * 写一个函数，判断敌人的子弹是否击中我的坦克*/
	public void hitMyHero()
	{
		//取出每一个敌人的坦克
		for(int i=0;i<this.enermytanks.size();i++)
		{
			//取出坦克
			EnermyTank enermytank=enermytanks.get(i);
			//然后取出该敌人坦克的每一颗子弹
			for(int j=0;j<enermytank.shots.size();j++)
			{
				//取出子弹
				Shot enermyshot=enermytank.shots.get(j);
				
				if(hero.isLive)
				{
					this.hitTank(enermyshot, hero);
				}
			}
		}
	}
	
	
	
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int tanktype)
	{
		//判断是什么类型的坦克
		switch(tanktype)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		
		}
		//判断是什么方向
		switch(direct)
		{
		case 0://向上
			//画出向上的坦克
			//第一步：画出左边的矩形
			g.fill3DRect(x, y, 10, 60, false);
			//第二步：画出右边的矩形
			g.fill3DRect(x+30, y,10, 60, false);
			//第三步：画出中间矩形
			g.fill3DRect(x+10, y+10, 20, 40, false);
			//第四步：画出圆形
			g.fillOval(x+10, y+20, 20, 20);
			//第五步：画出线
			g.drawLine(x+20, y+30, x+20, y);
			break;
		case 1://向右
			//画出向右的坦克
			//第一步：画出上面的矩形
			g.fill3DRect(x, y, 60, 10, false);
			//第二步：画出下面的矩形
			g.fill3DRect(x, y+30,60, 10, false);
			//第三步：画出中间矩形
			g.fill3DRect(x+10, y+10, 40, 20, false);
			//第四步：画出圆形
			g.fillOval(x+20, y+10, 20, 20);
			//第五步：画出线
			g.drawLine(x+30, y+20, x+60, y+20);
			break;
		case 2://向下
			//画出向上的坦克
			//第一步：画出左边的矩形
			g.fill3DRect(x, y, 10, 60, false);
			//第二步：画出右边的矩形
			g.fill3DRect(x+30, y,10, 60, false);
			//第三步：画出中间矩形
			g.fill3DRect(x+10, y+10, 20, 40, false);
			//第四步：画出圆形
			g.fillOval(x+10, y+20, 20, 20);
			//第五步：画出线
			g.drawLine(x+20, y+30, x+20, y+60);
			break;
		case 3://向左
			//画出向左的坦克
			//第一步：画出上面的矩形
			g.fill3DRect(x, y, 60, 10, false);
			//第二步：画出下面的矩形
			g.fill3DRect(x, y+30,60, 10, false);
			//第三步：画出中间矩形
			g.fill3DRect(x+10, y+10, 40, 20, false);
			//第四步：画出圆形
			g.fillOval(x+20, y+10, 20, 20);
			//第五步：画出线
			g.drawLine(x, y+20, x+30, y+20);
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//键按下处理，LEFT表示向左，UP表示向上，DOWN表示向下，RIGHT表示向右
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			//设置我的坦克的方向
			this.hero.setDirect(0);//按下键后，设置方向，之后的重绘函数repaint()会绘制出转变之后的坦克
			//控制我的坦克向上移动
			this.hero.moveUp();//改变坐标值，之后的重绘函数repaint()会绘制坐标变化之后的坦克
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			//向右
			this.hero.setDirect(1);
			//控制我的坦克向右移动
			this.hero.moveRight();
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//向下
			this.hero.setDirect(2);
			//控制我的坦克向下移动
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			//向左
			this.hero.setDirect(3);
			//控制我的坦克向左移动
			this.hero.moveLeft();
		}
		
		
		//判断玩家是否按下F键开火
		if(e.getKeyCode()==KeyEvent.VK_F)
		{
			if(this.hero.shots.size()<=100)
			{
			this.hero.shotEnermy();//调用shotEnermy()函数，该函数在hero类中定义
		    }
		}
		
		//必须重新绘制窗口
		this.repaint();
		
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//每个100毫秒去重绘我的面板MyPanel
		while(true)
		{
			try {
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
		    //判断是否击中敌人坦克
			this.hitEnermyTank();
			//判断是否击中我的坦克
			this.hitMyHero();
						
			//重绘
			this.repaint();
		}
	}
}

