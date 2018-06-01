package wdx.exercise.bankSystem;

/**
 * @author Shane Holmes
 */
public class BankSystem {

	/**
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		BankAccount cashAccount=new BankAccount("CashAccount",1000.0f);
		for (int i = 0; i < 6; i++) {
			cashAccount.addToBankAccount(200);
			Thread.sleep(1000);
		}
		System.out.println("After CashAccount add six times:");
		Thread.sleep(1000);
		cashAccount.printTransactionMessage();
		Thread.sleep(1000);
		cashAccount.drawBankAccount(300);
		cashAccount.drawBankAccount(500.0f);
		System.out.println("After CashAccount draw two times:");
		Thread.sleep(1000);
		cashAccount.printTransactionMessage();
		
		BankAccount creditAccount=new BankAccount("CreditAccount",1000.0f);
		for (int i = 0; i < 6; i++) {
			creditAccount.addToBankAccount(500);
			Thread.sleep(1000);
		}
		System.out.println("After CreditAccount add six times:");
		Thread.sleep(1000);
		creditAccount.printTransactionMessage();
		Thread.sleep(1000);
		creditAccount.drawBankAccount(1000);
		creditAccount.drawBankAccount(500.0f);
		System.out.println("After CreditAccount draw two times:");
		Thread.sleep(1000);
		creditAccount.printTransactionMessage();
		Thread.sleep(1000);
		System.out.println("Till to now,the number of BankAccount have been created are:"+creditAccount.accountNum);
	}
}
