package thread;


import thread.testThread;

public class Demo1_thread extends Thread
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new testThread().start();//����һ���µ��߳�
		new testThread().start();//����һ���µ��߳�
		new testThread().start();//����һ���µ��߳�
		new testThread().start();//����һ���µ��߳�
	}

}
class testThread extends Thread
{
	int tickets=100;
	public void run()
	{
		while(tickets>0)
		{
			System.out.println(Thread.currentThread().getName()+" is saiing tickets "+tickets--);
		}
	}
}
