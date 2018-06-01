package thread;

public class Demo4_mutiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student1 st1=new Student1(10);//创建类
		Student2 st2=new Student2(10);
		Thread t1=new Thread(st1);//创建线程，线程t1承载着st1
		Thread t2=new Thread(st2);
		//两个线程并行，交替运行
		t1.start();//启动线程
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
	public void run() {//重写run函数
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			times++;
			System.out.println("我是一个线程，正再输出HELLO WORLD!");
			if(times==n)
				break;
		}
	}
	
}

class Student2 implements Runnable//类实现线程接口
{
	int n=0;//1+2+...+n 
	int res=0;//加的结果
	int times=0;//次数
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
			res+=(++times);//times先自增，res加上自增之后的times
			System.out.println("当前结果是："+res);
			if(times==n)
			{
				System.out.println("最后的结果是："+res);
				break;
			}
		}
	}
}