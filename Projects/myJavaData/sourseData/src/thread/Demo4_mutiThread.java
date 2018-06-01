package thread;

public class Demo4_mutiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student1 st1=new Student1(10);//������
		Student2 st2=new Student2(10);
		Thread t1=new Thread(st1);//�����̣߳��߳�t1������st1
		Thread t2=new Thread(st2);
		//�����̲߳��У���������
		t1.start();//�����߳�
		t2.start();
	}

}


class Student1 implements Runnable
{
	int n=0;
	int times=0;
	public Student1(int n)
	{
		this.n=n;
	}

	@Override
	public void run() {//��дrun����
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			times++;
			System.out.println("����һ���̣߳��������HELLO WORLD!");
			if(times==n)
				break;
		}
	}
	
}

class Student2 implements Runnable//��ʵ���߳̽ӿ�
{
	int n=0;//1+2+...+n 
	int res=0;//�ӵĽ��
	int times=0;//����
	public Student2(int n)
	{
		this.n=n;
	}
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			res+=(++times);//times��������res��������֮���times
			System.out.println("��ǰ����ǣ�"+res);
			if(times==n)
			{
				System.out.println("���Ľ���ǣ�"+res);
				break;
			}
		}
	}
}