package thread;

public class Demo3_runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//注意启动
		Dog dog=new Dog();
		Thread t=new Thread(dog);
		t.start();
	}

}
class Dog implements Runnable//用Runnable时，实现接口
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