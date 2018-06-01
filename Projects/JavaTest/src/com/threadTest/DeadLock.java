package com.threadTest;

public class DeadLock {
	//�˿�
	class Customer{
	    public synchronized void say(Waiter w){
	        System.out.println("�˿�:˵�ȷ����ٸ���");
	        w.doService();
	    }
	    public synchronized void doService(){
	        System.out.println("ͬ���ȸ��������ܷ���");
	    }
	}
	
	class Waiter{
	    public synchronized void say(Customer c){
	        System.out.println("����Ա˵���ȸ��ѣ��ٷ���");
	        c.doService();
	    }
	    public synchronized void doService(){
	        System.out.println("ͬ���ȷ������շ�");
	    }
	}
	
	//�����߳�
	class DeadThread implements Runnable{
	    Customer c =new Customer();
	    Waiter w = new Waiter();
	    public DeadThread(){
	        new Thread(this).start();//ִ�л���� c.say(w); 
	        w.say(c);
	        /**
	         * ��� c.say(w); ��ִ�У�����c�ᱻ������������� w.doService �����ڸ÷�������ͬ������
	         * ��� ���� w�ᱻ������
	         * ���Ե� w.say(c); ���õ�ʱ�����ڶ��� w���������ʶ��ȴ����������������� 
             * �������ͬʱִ�У�c.say(w)����ס c ��w.say(c) ����ס w ����� ����c �޷�ʹ�� say(w)�е�w������
             * w�޷�ʹ��say��c���е�c���󣬴Ӷ��������� 
             * ��������Ĳ�������һ�����ʵġ�
	         */
	    }
	    @Override
	    public void run() {
	        c.say(w);
	    }
	}
	
	public static void main(String[] args) {
		DeadLock dl=new DeadLock();
	    DeadThread dt=dl.new DeadThread();
	 }
}
