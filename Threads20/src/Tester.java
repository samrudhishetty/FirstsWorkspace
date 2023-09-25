import java.util.Scanner;

class MyThread implements Runnable{
	private int num ; 
	private Thread t1,t2;
	public MyThread (int num) {
		this.num=num;
	    t1 =new Thread(this,"first");
		t2=new Thread(this,"second");
		t1.start();
		t2.start();
	}
	
	public void run() {
		for(int i =1 ; i<10 ;i++) {
			if(Thread.currentThread()==t1)
				System.out.println("Increment number "+(num+i));
			else if (Thread.currentThread()==t2)
				System.out.println("Mutiplication table"+(num*i));
		}
	}
	
}

public class Tester {

	public static void main(String[] args) {
	int num ;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	num = sc.nextInt();
	MyThread n = new MyThread(num);
			}

}
