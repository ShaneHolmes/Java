package tank;

import java.util.Vector;

//̹����
class Tank 
{
	//x��ʾ̹�˵ĺ����꣬y��ʾ̹�˵�������
	int x=0;
	int y=0;
	boolean isLive=true;
	
	//̹�˷���0��ʾ���ϣ�1��ʾ���ң�2��ʾ�£�3��ʾ��
	int direct=0;//��ʼĬ��Ϊ���Ϸ���
	
	//����̹�˵��ٶ�
	int speed=3;
	
	//����̹�˵���ɫ
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

	//���캯��
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



//�ҵ�̹��
class Hero extends Tank
{
	//�ӵ�
	Shot shot=null;
	//Ϊ�˽������ӵ����⣬ʹ��Vector<>
	Vector<Shot> shots=new Vector<Shot>();
	
	public Hero(int x,int y)					
	{											
		super(x,y);
	}				
	
	//����
	public void shotEnermy()
	{
		switch(this.direct)//�жϷ��򣬴�����Ӧ�ķ����ϵ�̹�˵��ӵ�,Ȼ����MyTankGame�л��Ƴ��ӵ�
		{
		
		case 0://����
			shot=new Shot(x+20,y,0);//��������ϣ���(x+10,y)��Ϊ�ӵ��ĳ�ʼλ�ô��ݵ��´�����shot��
			shots.add(shot);
			break;
		case 1://����
			shot=new Shot(x+60,y+20,1);
			shots.add(shot);
			break;
		case 2://����
			shot=new Shot(x+20,y+60,2);
			shots.add(shot);
			break;
		case 3://����
			shot=new Shot(x,y+20,3);
			shots.add(shot);
			break;
		}
		//�ڰ���p����֮��ִ����switch����֮�󣬴�����һ���ӵ��������MyTankGame�л��Ƴ��ӵ�
		//�����������ӵ����̣߳������ܹ��˶�
		Thread t=new Thread(shot);
		t.start();
	}
	
	
	//̹�������ƶ�
	public void moveUp()
	{
		y-=speed;
	}
	//̹�������ƶ�
	public void moveRight()
	{
		x+=speed;	
	}
	//̹�������ƶ�
	public void moveDown()
	{
		y+=speed;	
	}
	//̹�������ƶ�
	public void moveLeft()
	{
		x-=speed;	
	}
}


//�ӵ��࣬��Ϊ�߳�
class Shot implements Runnable
{
	int x;
	int y;
	int direct;//����
	int shotspeed=5;//�ӵ�����ٶ�
	boolean isLive=true;//�ж��ӵ��Ƿ񻹻��ţ���ʼֵΪtrue�����ӵ����˱߽���Ǵ򵹵��˵�̹��֮��isLive==false
	
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
	
	@Override
	public void run() {//�߳���дrun����
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(50);//�߳���ͣ50����
			}catch(Exception e){
				e.printStackTrace();
			}
			switch(direct)//����x,y��λ��ʵʱ����
			{
			case 0://����
				y-=shotspeed;
				break;
			case 1://����
				x+=shotspeed;
				break;
			case 2://����
				y+=shotspeed;
				break;
			case 3://����
				x-=shotspeed;
				break;
				
			}
			
			//�ж��ӵ��Ƿ�������Ե
			if(x<=0||x>=1600||y<=0||y>=1000)//�ҵ�����Сthis.setSize(1600,1000);
			{
				isLive=false;
				break;
			}
		}
	}
}


//ը����
class Bomb
{
	//����ը��������
	int x,y;
	int life=15;//ը��������
	boolean isLive=true;
	
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	//��������ֵ
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




//���˵� ̹��,Ҫʹ���˵�̹���ƶ���ʹ���߳�
class EnermyTank extends Tank implements Runnable//��Ϊ���ܶ�̳У������ڼ̳���Tank���ǰ���£�ʹ��implements Runnable��ʵ���̣߳�ʹ���˶�
{
	
	int times=0;//�ӵ�����
	
	//����һ�����������Դ�ŵ��˵��ӵ�
	Vector<Shot> shots=new Vector<Shot>();
	//��������ӵ���Ӧ�ڸոմ���̹�˺͵��˵��ӵ�������
	
	
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
			case 0://̹�����������ƶ�
				for(int i=0;i<15;i++)
				{
					if(y>0)//����̹���ڹ̶���Χ���ƶ�,�����߽�
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
			case 1://̹�����������ƶ�
                    for(int i=0;i<23;i++)
					{
                    	if(x<1550)//����̹���ڹ̶���Χ���ƶ�,�����߽�
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
			case 2://̹�����������ƶ�
				for(int i=0;i<30;i++)
				{
					if(y<900)//����̹���ڹ̶���Χ���ƶ�,�����߽�
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
			case 3://̹�����������ƶ�
				for(int i=0;i<50;i++)
				{
					if(x>0)//����̹���ڹ̶���Χ���ƶ�,�����߽�
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
			if(times%2==0)//�ж��Ƿ���Ҫ���ӵ�����µ��ӵ�
			{
				if(this.isLive)
				{
					if(shots.size()<7)//�ӵ����٣���Ҫ���
					{
									
                                	Shot shot=null;
									
									switch(this.direct)//�жϷ��򣬴�����Ӧ�ķ����ϵ�̹�˵��ӵ�,Ȼ����MyTankGame�л��Ƴ��ӵ�
									{
									
									case 0://����
										shot=new Shot(this.x+20,this.y,0);//��������ϣ���(x+10,y)��Ϊ�ӵ��ĳ�ʼλ�ô��ݵ��´�����shot��
										this.shots.add(shot);
										break;
									case 1://����
										shot=new Shot(this.x+60,this.y+20,1);
										this.shots.add(shot);
										break;
									case 2://����
										shot=new Shot(this.x+20,this.y+60,2);
										this.shots.add(shot);
										break;
									case 3://����
										shot=new Shot(this.x,this.y+20,3);
										this.shots.add(shot);
										break;
									}
								   //�����ӵ��߳�
						           Thread thread=new Thread(shot);
						           thread.start();
			                  }
						}
				}
			
			
			//��̹���������һ���µķ���
		    this.direct=(int)(Math.random()*4);//Math.random()����һ��0-1���������*4֮��õ�һ��0-3���������
		    
		    //�жϵ���̹���Ƿ�����
		    if(this.isLive==false)
		    {
		    	//�õ���̹���߳̽�����������̹���������߳�û�н�������ռ��CPU��Դ��������̹����Panel����ʾ������������ʬ�̡߳�
		    	break;
		    }
		    
		    //�ж��ӵ��Ƿ�����
		    if(shots.size()<1)
		    {
		    	
		    }
		}
	}
}

