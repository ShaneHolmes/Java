package wdx.exercise.checkingAccount;

/**
 * @author Shane Holmes
 */
public class CheckingAccount {

	 static class BankAccount {
		private int balance;

		public BankAccount(int balance) {
			this.balance=balance;
		}
		
		public BankAccount() {
		}

		public void initBankCcount (int balance)  {
			try {
				if (balance<0) {
					throw new IllegalArgumentException();
				}else {
					this.balance=balance;
					System.out.println("The balance after initBankAccount: "+this.balance);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("throws IllegalArgumentException");
				e.printStackTrace();
			}
		}
		
		public void addToBankCcount (int amount)  {
			try {
				if (amount<0) {
					throw new IllegalArgumentException();
				}else {
					this.balance+=amount;
					System.out.println("The balance after addToBankAccount: "+this.balance);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("throws IllegalArgumentException");
				e.printStackTrace();
			}
		}
		public void drawBankCcount (int amount)  {
			try {
				if (this.balance-amount<0) {
					throw new IllegalArgumentException();
				}else {
					this.balance-=amount;
					System.out.println("The balance after drawBankAccount: "+this.balance);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("throws IllegalArgumentException");
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankAccount bankAccount=new BankAccount();
		//bankAccount.initBankCcount(-100);
		bankAccount.initBankCcount(100);
		//bankAccount.addToBankCcount(-20);
		bankAccount.addToBankCcount(20);
		bankAccount.drawBankCcount(200);
		//bankAccount.drawBankCcount(100);
	}

}
