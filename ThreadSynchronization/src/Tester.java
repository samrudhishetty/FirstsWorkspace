class Account{
	private int balance;
	
	public Account() {
		balance = 10000;
	}
	
	public synchronized void  deposite(int amount) {
		System.out.println("balance before deposite " +balance);
		balance=balance+amount;
		System.out.println("Balance after deposite "+ balance);
		
	}
	public synchronized void  withdraw(int amount) {
		System.out.println("balance before Withdraw " +balance);
		balance=balance-amount;
		System.out.println("Balance after withdraw "+ balance);
		
	}
	
}
class AccountUser extends Thread{
	String name, tot;
	Account account ;
	int amount;
	
	public AccountUser(String name, Account account, String tot,int amount) {
		
		this.name = name;
		this.tot = tot;
		this.account = account;
		this.amount = amount;
	}
	public void run() {
		if(tot.equals("deposite"))
			account.deposite(amount);
		else if(tot.equals("withdraw"))
			account.withdraw(amount);
	}
	
}
public class Tester {

	public static void main(String[] args) {
		
		Account account = new Account();
		AccountUser user1 = new AccountUser("abc",account,"deposite",5000);
		AccountUser user2 = new AccountUser("pqr",account,"withdraw",2000);

		user1.start();
		user2.start();
	}

}
