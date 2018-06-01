package wdx.exercise.bankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BankAccount {
	private String accountName;
	private float  balance;
	static int accountNum=0;//静态数据，多少account被创建了 
	List<String> list=new ArrayList<String>(6);

	public BankAccount(String accountName,Float  balance) {
		this.accountName=accountName;
		this.balance=balance;
		accountNum+=1;
	}
	
	public BankAccount() {
		accountNum+=1;
	}
	public  void setAccountName(String accountName) {
		this.accountName=accountName;
	}
	public  void  addToBankAccount(float balance) {
		this.balance+=balance;
		String transactionMessage=this.getCurrentTime();
		transactionMessage=transactionMessage+this.accountName+" Operation:AddToAccount "+" AddAmount:"+balance+" Balance:"+this.balance;
		if (list.size()<6) {
			list.add(transactionMessage);
		} else {
			list.remove(0);
			list.add(transactionMessage);
		}
	}
	public  void  drawBankAccount(float balance) {
		this.balance-=balance;
		String transactionMessage=this.getCurrentTime();
		transactionMessage=transactionMessage+this.accountName+" Operation:DrawAccount "+" DrawAmount:"+balance+" Balance:"+this.balance;
		if (list.size()<6) {
			list.add(transactionMessage);
		} else {
			list.remove(0);
			list.add(transactionMessage);
		}
	}
	private String getCurrentTime() {
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		String datetime = tempDate.format(new java.util.Date()); 
		return datetime;
	}
	public void printTransactionMessage() {
		for (int i = 0; i <this.list.size(); i++) {
			System.out.println(this.list.get(i));			
		}
	}
}
