package com.threadTest;
/**
 * 线程同步测试例子
 * @author ShaneHolmes
 * Date:2018.5.9
 */
/**
 * 在一个名为SynchronizedThread的类中，有Bank类，Bank类中：
 * private int account=100；
 * 有线程同步的方法save（）；该方法用synchronized修饰，表明是线程同步的方法。
 * 要想对存钱save进行同步操作还可以在方法内部给要进行线程同步的代码块用synchronized关键字
 * 显式声明，例如Bank中的save1();
 *  NewThread类实现runnable接口，重写run方法。当.start()一个线程的时候，会执行run方法。
 *  useThread() 方法创建Bank对象，传递给NewThread类，在NewThread类中进行存钱的同步线程操作
 *  创建不同线程对象，并启动线程看线程是否同步
 * @author Shane Holmes
 *
 */
public class SynchronizedThread {

    class Bank {
        private int account = 100;
        public int getAccount() {
            return account;
        }
        /**
         * 用同步方法实现
         *  @param money
         */
        public  void save(int money) {
            account += money;
        }
        /**
         * 用同步代码块实现
         * 
         * @param money
         */
        public void save1(int money) {
            synchronized (this) {
                account += money;
            }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;
        public NewThread(Bank bank) {
            this.bank = bank;
        }
        @Override
        public void  run() {
            synchronized(this) {
            	for (int i = 0; i < 10; i++) {
            		 bank.save1(10);
                     System.out.println(i + "账户余额为：" + bank.getAccount());
                 }
            }
         }
    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);//以new_thread为参数，创建Thread线程
        thread1.start();//启动线程，执行NewThread类中被重写的run()方法
        System.out.println("线程2");
        //应对同一个new_thread对象启动不同的线程 ，线程的同步所涉及的资源应是同一个
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        st.useThread();
    }

}
