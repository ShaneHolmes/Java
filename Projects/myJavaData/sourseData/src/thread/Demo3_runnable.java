package thread;

public class Demo3_runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ע������
		Dog dog=new Dog();
		Thread t=new Thread(dog);
		t.start();
	}

}
class Dog implements Runnable//��Runnableʱ��ʵ�ֽӿ�
{
	int i=0;
	//��дrun����
	public void run()
	{
		while(true)
	   {
		//����һ�룬���ʮ��֮������߳�
		//1000��ʾ1000����
		//ÿ������ʱ�������blocked״̬
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