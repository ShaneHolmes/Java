package com.threadTest;
/**
 * �߳�ͬ����������
 * @author ShaneHolmes
 * Date:2018.5.9
 */
/**
 * ��һ����ΪSynchronizedThread�����У���Bank�࣬Bank���У�
 * private int account=100��
 * ���߳�ͬ���ķ���save�������÷�����synchronized���Σ��������߳�ͬ���ķ�����
 * Ҫ��Դ�Ǯsave����ͬ�������������ڷ����ڲ���Ҫ�����߳�ͬ���Ĵ������synchronized�ؼ���
 * ��ʽ����������Bank�е�save1();
 *  NewThread��ʵ��runnable�ӿڣ���дrun��������.start()һ���̵߳�ʱ�򣬻�ִ��run������
 *  useThread() ��������Bank���󣬴��ݸ�NewThread�࣬��NewThread���н��д�Ǯ��ͬ���̲߳���
 *  ������ͬ�̶߳��󣬲������߳̿��߳��Ƿ�ͬ��
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
         * ��ͬ������ʵ��
         *  @param money
         */
        public  void save(int money) {
            account += money;
        }
        /**
         * ��ͬ�������ʵ��
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
                     System.out.println(i + "�˻����Ϊ��" + bank.getAccount());
                 }
            }
         }
    }

    /**
     * �����̣߳������ڲ���
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("�߳�1");
        Thread thread1 = new Thread(new_thread);//��new_threadΪ����������Thread�߳�
        thread1.start();//�����̣߳�ִ��NewThread���б���д��run()����
        System.out.println("�߳�2");
        //Ӧ��ͬһ��new_thread����������ͬ���߳� ���̵߳�ͬ�����漰����ԴӦ��ͬһ��
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        st.useThread();
    }

}
