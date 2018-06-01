package thread;

public class Demo2_thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//创建一个cat 对象
		Cat cat=new Cat();
		cat.start();//启动线程
		
		
	}

}

class Cat extends Thread//用Thread时继承Thread
{
	int i=0;
	//重写run函数
	public void run()
	{
		while(true)
	   {
		//休眠一秒，输出十次之后结束线程
		//1000表示1000毫秒
		//每次休眠时都会进入blocked状态
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		i+=1;
		System.out.println("thread"+i);
		
		if(i==10)
		{
			break;
		}
	    }
	
		
	}
}