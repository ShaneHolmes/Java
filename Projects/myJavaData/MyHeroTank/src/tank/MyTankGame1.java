/*
 * ����:ʵ��̹����Ϸ
 * 1.����̹��
 * 2.�ҵ�̹�˿������������ƶ�
 */
package tank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame1 extends JFrame{

	//����������
	MyPanel mypanel=null;
	
	//���캯��
	public MyTankGame1()
	{
		//����������
		mypanel=new MyPanel();
		
		//������
		this.add(mypanel);
		
		//ע�����
		this.addKeyListener(mypanel);
		
		//�����߳�
		Thread t=new Thread(mypanel);
		t.start();
		
		//���ô�������
		this.setTitle("̹�˵۹�");
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


//����һ�����Լ������,�����Ϊһ���̣߳�����ˢ����壬������ʾ���ӵ����˶��켣�������߳�֮��Ӧ�� MyTankGame1�������߳�
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//����һ�����Լ���̹��
	Hero hero=null;
	
	//��������ͼƬ������ʵ�ֱ�ըЧ��
	Image image1=null;
	Image image2=null;
	Image image3=null;
	
	//����ը������
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	//������˵�̹����
	Vector<EnermyTank> enermytanks=new Vector<EnermyTank>();
	
	int enermytanksize=6;//�������̹������
	
	//���캯��
	public MyPanel()
	{
		hero=new Hero(800,500);
		
		//��ʼ��ͼƬ
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/b3.gif"));
		
		//��ʼ���˵�̹��
		for(int i=0;i<enermytanksize;i++)
		{
			EnermyTank enermytank=new EnermyTank((i+1)*200,0);//����һ�����˵�̹��
			enermytank.setColor(0);
			enermytank.setDirect(2);
			enermytanks.add(enermytank);//��enermytank��ӵ�����Vector ����enermytanks��ȥ
		
			//�����˵�̹�����һ���ӵ�
			Shot shot=new Shot(enermytank.x+20,enermytank.y+60,2);
			enermytank.shots.add(shot);
			Thread thread1=new Thread(shot);
			thread1.start();
			
		    //��������̹�˵��߳�
			Thread thread=new Thread(enermytank);
			thread.start();
		}
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 1600, 1000);//��������
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
			//�����Լ���̹��
		    this.drawTank(hero.getX(),hero.getY(),g,this.hero.direct,1);
		}
		
	    
		//��shots��ȡ��ÿһ���ӵ�����������ӵ�
		for(int i=0;i<hero.shots.size();i++)
		{
			Shot myshot=hero.shots.get(i);
		    //�����ӵ�,����һ���ӵ�
		    if(myshot!=null&&myshot.isLive==true)//������f��֮��Ż����ӵ���һ��ʼû���µ�ʱ��hero.shot==null����ʱ �����ӵ����׳��쳣;�ӵ����߽�֮���ٻ���
		    {
			g.draw3DRect(myshot.x,myshot.y, 1, 1, false);
		    }
		    
		    if(myshot.isLive==false)//Vector<>������ӵ��Ѿ������������Vector���Ƴ�
		    {
		    	hero.shots.remove(myshot);//Ҫ������������ӵ��Ƴ�������ʹ��i����
		    }
		}
		
		//����ը��
		for(int i=0;i<bombs.size();i++)
		{
			//ȡ��ը��
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
			//��bomb����ֵ����
			bomb.lifeDown();
			//���ը������ֵΪ0���Ž�ը����Vector��ȥ��
			if(bomb.life==0)
			{
				bombs.remove(bomb);
			}
		}
		
		
		
		
		
		
		//�������˵�̹��,�������ӵ�
		for(int i=0;i<enermytanks.size();i++)//������i<enermytanks.size()����Ϊ��һ��̹�˴����Vector�������enermytanks.size()==enermytanksize-1��ֻ��Ҫ����
		{
			EnermyTank enermytank=enermytanks.get(i);
			if(enermytank.isLive)
			{
				this.drawTank(enermytanks.get(i).getX(),enermytanks.get(i).getY(),g,enermytanks.get(i).getDirect(),0);
			    for(int j=0;j<enermytank.shots.size();j++)
			    {
			    	//ȡ���ӵ�
			    	Shot enermyshot=enermytank.shots.get(j);
			    	//�����ӵ�
			    	if(enermyshot.isLive)
			    	{
			    		g.draw3DRect(enermyshot.x, enermyshot.y, 1, 1, false);
			    	}
			    	else
			    	{
			    		//�������̹�˵��ӵ��������ʹ�Vector��ȥ��
			    		enermytank.shots.remove(enermyshot);
			    	}
			    }
			}
			
		}
	}
	
	
	
	
	
	/*
	 * дһ�������������ж��ӵ��Ƿ����̹��*/
	public void hitTank(Shot shot,Tank tank)//����Ϊ�ӵ��Լ�̹�ˣ���ȡ���ǵ����꣬�����ӵ��Ƿ���̹�����귶Χ֮�����ж��Ƿ����̹��
	{
		//����̹�˵ķ���ͬ������̹������λ���Լ��䷶Χ�Ĳ�ͬ��������ж�������ĵ�ǰ̹�˵�λ��
		switch(tank.direct)
		{
		//̹�˷������ϻ�������
		case 0:
		case 2:
			if(shot.x>tank.x&&shot.x<tank.x+40&&shot.y>tank.y&&shot.y<tank.y+60)//�ӵ���̹�������Χ֮�ڣ���˵������̹��
			{
				//�ӵ�����
				shot.isLive=false;
				//̹������
				tank.isLive=false;
				//����һ��ը��,����Vrctor
				Bomb bomb=new Bomb(tank.x,tank.y);
				bombs.add(bomb);
		
			}
			//̹�˷��������������
		case 1:
		case 3:
			if(shot.x>tank.x&&shot.x<tank.x+60&&shot.y>tank.y&&shot.y<tank.y+40)//�ӵ���̹�������Χ֮�ڣ���˵������̹��
			{
				//�ӵ�����
				shot.isLive=false;
				//̹������
				tank.isLive=false;			
				//����һ��ը��,����Vrctor
				Bomb bomb=new Bomb(tank.x,tank.y);
				bombs.add(bomb);	
			}
		}
	}

	/*
	 * дһ���������ж��ҵ��ӵ��Ƿ���е��˵�̹��*/
	public void hitEnermyTank()
	{
		//�ж��Ƿ����
		for(int i=0;i<hero.shots.size();i++)
		{
			//ȡ���ӵ�
			Shot myshot=hero.shots.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myshot.isLive)
			{
				//ȡ��ÿ��̹������Ƚϣ��������ӵ��Ƿ���̹�˵ķ�Χ֮�ڣ�����ǣ���˵������
				{
					for(int j=0;j<enermytanks.size();j++)//ע����j++
					{
						//����ȡ��̹��
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
	 * дһ���������жϵ��˵��ӵ��Ƿ�����ҵ�̹��*/
	public void hitMyHero()
	{
		//ȡ��ÿһ�����˵�̹��
		for(int i=0;i<this.enermytanks.size();i++)
		{
			//ȡ��̹��
			EnermyTank enermytank=enermytanks.get(i);
			//Ȼ��ȡ���õ���̹�˵�ÿһ���ӵ�
			for(int j=0;j<enermytank.shots.size();j++)
			{
				//ȡ���ӵ�
				Shot enermyshot=enermytank.shots.get(j);
				
				if(hero.isLive)
				{
					this.hitTank(enermyshot, hero);
				}
			}
		}
	}
	
	
	
	//����̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int tanktype)
	{
		//�ж���ʲô���͵�̹��
		switch(tanktype)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		
		}
		//�ж���ʲô����
		switch(direct)
		{
		case 0://����
			//�������ϵ�̹��
			//��һ����������ߵľ���
			g.fill3DRect(x, y, 10, 60, false);
			//�ڶ����������ұߵľ���
			g.fill3DRect(x+30, y,10, 60, false);
			//�������������м����
			g.fill3DRect(x+10, y+10, 20, 40, false);
			//���Ĳ�������Բ��
			g.fillOval(x+10, y+20, 20, 20);
			//���岽��������
			g.drawLine(x+20, y+30, x+20, y);
			break;
		case 1://����
			//�������ҵ�̹��
			//��һ������������ľ���
			g.fill3DRect(x, y, 60, 10, false);
			//�ڶ�������������ľ���
			g.fill3DRect(x, y+30,60, 10, false);
			//�������������м����
			g.fill3DRect(x+10, y+10, 40, 20, false);
			//���Ĳ�������Բ��
			g.fillOval(x+20, y+10, 20, 20);
			//���岽��������
			g.drawLine(x+30, y+20, x+60, y+20);
			break;
		case 2://����
			//�������ϵ�̹��
			//��һ����������ߵľ���
			g.fill3DRect(x, y, 10, 60, false);
			//�ڶ����������ұߵľ���
			g.fill3DRect(x+30, y,10, 60, false);
			//�������������м����
			g.fill3DRect(x+10, y+10, 20, 40, false);
			//���Ĳ�������Բ��
			g.fillOval(x+10, y+20, 20, 20);
			//���岽��������
			g.drawLine(x+20, y+30, x+20, y+60);
			break;
		case 3://����
			//���������̹��
			//��һ������������ľ���
			g.fill3DRect(x, y, 60, 10, false);
			//�ڶ�������������ľ���
			g.fill3DRect(x, y+30,60, 10, false);
			//�������������м����
			g.fill3DRect(x+10, y+10, 40, 20, false);
			//���Ĳ�������Բ��
			g.fillOval(x+20, y+10, 20, 20);
			//���岽��������
			g.drawLine(x, y+20, x+30, y+20);
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//�����´���LEFT��ʾ����UP��ʾ���ϣ�DOWN��ʾ���£�RIGHT��ʾ����
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			//�����ҵ�̹�˵ķ���
			this.hero.setDirect(0);//���¼������÷���֮����ػ溯��repaint()����Ƴ�ת��֮���̹��
			//�����ҵ�̹�������ƶ�
			this.hero.moveUp();//�ı�����ֵ��֮����ػ溯��repaint()���������仯֮���̹��
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			//����
			this.hero.setDirect(1);
			//�����ҵ�̹�������ƶ�
			this.hero.moveRight();
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//����
			this.hero.setDirect(2);
			//�����ҵ�̹�������ƶ�
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			//����
			this.hero.setDirect(3);
			//�����ҵ�̹�������ƶ�
			this.hero.moveLeft();
		}
		
		
		//�ж�����Ƿ���F������
		if(e.getKeyCode()==KeyEvent.VK_F)
		{
			if(this.hero.shots.size()<=100)
			{
			this.hero.shotEnermy();//����shotEnermy()�������ú�����hero���ж���
		    }
		}
		
		//�������»��ƴ���
		this.repaint();
		
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//ÿ��100����ȥ�ػ��ҵ����MyPanel
		while(true)
		{
			try {
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
		    //�ж��Ƿ���е���̹��
			this.hitEnermyTank();
			//�ж��Ƿ�����ҵ�̹��
			this.hitMyHero();
						
			//�ػ�
			this.repaint();
		}
	}
}

