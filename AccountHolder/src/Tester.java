import java.util.Scanner;
class Accountholder
{
	private int accountnumber;
	private String accountholdername;
	private double accountbalance;
	
	
	public Accountholder(int accountnumber,String accountholdername,double accountbalance) {
		this.accountbalance=accountbalance;
		this.accountholdername=accountholdername;
		this.accountnumber=accountnumber;
	}
	
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	
	public void deposit(double depositAmt ) {
		accountbalance = accountbalance + depositAmt;
		}
	public void withdraw(double withdrawamt) {

				accountbalance = accountbalance-withdrawamt;
	}
	public void show() {
		System.out.println(accountnumber+" "+accountholdername+" "+accountbalance);
	}
	
}


public class Tester {

	public static void main(String[] args) {
		int choice,cnt=0 , acno;
		Accountholder []arr =new Accountholder[10];
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.Add a record");
			System.out.println("2.show all record");
			System.out.println("3.deposite");
			System.out.println("4.withdraw");
			System.out.println("5.show balancee");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter accountnumber,name and balance :");
				arr[cnt++]=new Accountholder(sc.nextInt(),sc.next(),sc.nextDouble());
				break;
			case 2://to show all the records so will will count the objects 
				for(int i = 0;i<cnt;i++)
					arr[i].show();
				break;
			case 3:
				System.out.println("enter the account number : ");
				acno=sc.nextInt();
				for(int i =0;i<cnt;i++) {
					if(arr[i].getAccountnumber()==acno) {
						System.out.println("enter the amount to be deposidted :");
						arr[i].deposit(sc.nextDouble());
					}
				}
				break;
			case 4:
				System.out.println("enter account number :");
				acno=sc.nextInt();
				for(int i =0;i<cnt;i++) {
					if(arr[i].getAccountnumber()==acno) {
						System.out.println("enter the amout to be withdraw :");
						arr[i].withdraw(sc.nextDouble());
					}
		}
				break;
			
			case 5 :
				System.exit(0);
		}
		
		}
	}

}
