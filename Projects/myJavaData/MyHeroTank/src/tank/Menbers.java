package tank;

import java.util.Vector;

//坦克类
class Tank 
{
	//x表示坦克的横坐标，y表示坦克的纵坐标
	int x=0;
	int y=0;
	boolean isLive=true;
	
	//坦克方向：0表示向上，1表示向右，2表示下，3表示左
	int direct=0;//初始默认为向上方向
	
	//设置坦克的速度
	int speed=3;
	
	//设置坦克的颜色
	int color;
	
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	//构造函数
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX()
	{
		this.x=x;
	}
	public void setY()
	{
		this.y=y;
	}
	
}



//我的坦克
class Hero extends Tank
{
	//子弹
	Shot shot=null;
	//为了解决多颗子弹问题，使用Vector<>
	Vector<Shot> shots=new Vector<Shot>();
	
	public Hero(int x,int y)					
	{											
		super(x,y);
	}				
	
	//开火
	public void shotEnermy()
	{
		switch(this.direct)//判断方向，创建对应的方向上的坦克的子弹,然后在MyTankGame中绘制出子弹
		{
		
		case 0://向上
			shot=new Shot(x+20,y,0);//如果是向上，把(x+10,y)作为子弹的初始位置传递到新创建的shot中
			shots.add(shot);
			break;
		case 1://向右
			shot=new Shot(x+60,y+20,1);
			shots.add(shot);
			break;
		case 2://向下
			shot=new Shot(x+20,y+60,2);
			shots.add(shot);
			break;
		case 3://向左
			shot=new Shot(x,y+20,3);
			shots.add(shot);
			break;
		}
		//在按下p开火之后，执行完switch语句块之后，创建了一个子弹类对象，由MyTankGame中绘制出子弹
		//接下来启动子弹的线程，让其能够运动
		Thread t=new Thread(shot);
		t.start();
	}
	
	
	//坦克向上移动
	public void moveUp()
	{
		y-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=speed;	
	}
	//坦克向下移动
	public void moveDown()
	{
		y+=speed;	
	}
	//坦克向左移动
	public void moveLeft()
	{
		x-=speed;	
	}
}


//子弹类，作为线程
class Shot implements Runnable
{
	int x;
	int y;
	int direct;//方向
	int shotspeed=5;//子弹射击速度
	boolean isLive=true;//判断子弹是否还活着，初始值为true。当子弹出了边界或是打倒敌人的坦克之后isLive==false
	
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
	
	@Override
	public void run() {//线程重写run函数
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(50);//线程暂停50毫秒
			}catch(Exception e){
				e.printStackTrace();
			}
			switch(direct)//设置x,y的位置实时更新
			{
			case 0://向上
				y-=shotspeed;
				break;
			case 1://向右
				x+=shotspeed;
				break;
			case 2://向下
				y+=shotspeed;
				break;
			case 3://向左
				x-=shotspeed;
				break;
				
			}
			
			//判断子弹是否碰到边缘
			if(x<=0||x>=1600||y<=0||y>=1000)//我的面板大小this.setSize(1600,1000);
			{
				isLive=false;
				break;
			}
		}
	}
}


//炸弹类
class Bomb
{
	//定义炸弹的坐标
	int x,y;
	int life=15;//炸弹的声明
	boolean isLive=true;
	
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	//减少生命值
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive=false;
		}
	}
}




//敌人的 坦克,要使敌人的坦克移动，使用线程
class EnermyTank extends Tank implements Runnable//因为不能多继承，所以在继承了Tank类的前提下，使用implements Runnable来实现线程，使其运动
{
	
	int times=0;//子弹连发
	
	//定义一个向量，可以存放敌人的子弹
	Vector<Shot> shots=new Vector<Shot>();
	//敌人添加子弹，应在刚刚创建坦克和敌人的子弹死亡后
	
	
	public EnermyTank(int x,int y)
	{
		super(x, y);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			
			
			switch(this.direct)
			{
			case 0://坦克正在向上移动
				for(int i=0;i<15;i++)
				{
					if(y>0)//控制坦克在固定范围内移动,不出边界
					{
						y-=speed;
					}
					
					try{
				       Thread.sleep(100);
			            } catch(Exception e)
			                  {
				              e.printStackTrace();
			                  }
				}
				break;
			case 1://坦克正在向右移动
                    for(int i=0;i<23;i++)
					{
                    	if(x<1550)//控制坦克在固定范围内移动,不出边界
                    	{
                    		x+=speed;
                    	}
						
						try{
					       Thread.sleep(100);
				            } catch(Exception e)
				                  {
					              e.printStackTrace();
				                  }
					}
				break;
			case 2://坦克正在向下移动
				for(int i=0;i<30;i++)
				{
					if(y<900)//控制坦克在固定范围内移动,不出边界
					{
						y+=speed;
					}
					
					try{
				       Thread.sleep(100);
			            } catch(Exception e)
			                  {
				              e.printStackTrace();
			                  }
				}
				break;
			case 3://坦克正在向左移动
				for(int i=0;i<50;i++)
				{
					if(x>0)//控制坦克在固定范围内移动,不出边界
					{
						x-=speed;
					}
					
					try{
				       Thread.sleep(100);
			            } catch(Exception e)
			                  {
				              e.printStackTrace();
			                  }
				}
				break;
			}
			
			this.times++;
			if(times%2==0)//判断是否需要给子弹添加新的子弹
			{
				if(this.isLive)
				{
					if(shots.size()<7)//子弹减少，需要添加
					{
									
                                	Shot shot=null;
									
									switch(this.direct)//判断方向，创建对应的方向上的坦克的子弹,然后在MyTankGame中绘制出子弹
									{
									
									case 0://向上
										shot=new Shot(this.x+20,this.y,0);//如果是向上，把(x+10,y)作为子弹的初始位置传递到新创建的shot中
										this.shots.add(shot);
										break;
									case 1://向右
										shot=new Shot(this.x+60,this.y+20,1);
										this.shots.add(shot);
										break;
									case 2://向下
										shot=new Shot(this.x+20,this.y+60,2);
										this.shots.add(shot);
										break;
									case 3://向左
										shot=new Shot(this.x,this.y+20,3);
										this.shots.add(shot);
										break;
									}
								   //启动子弹线程
						           Thread thread=new Thread(shot);
						           thread.start();
			                  }
						}
				}
			
			
			//让坦克随机产生一个新的方向
		    this.direct=(int)(Math.random()*4);//Math.random()产生一个0-1的随机数，*4之后得到一个0-3的随机整数
		    
		    //判断敌人坦克是否死亡
		    if(this.isLive==false)
		    {
		    	//让敌人坦克线程结束。若敌人坦克死亡后线程没有结束，将占用CPU资源，但这辆坦克在Panel上显示不出来，“僵尸线程”
		    	break;
		    }
		    
		    //判断子弹是否死亡
		    if(shots.size()<1)
		    {
		    	
		    }
		}
	}
}

