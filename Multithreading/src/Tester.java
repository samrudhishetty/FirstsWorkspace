//class FirstThread extends Thread{
//	public void run() {
//		for(int i = 0;i<100;i++) {
//			System.out.println("hi...");
//		try {
//			Thread.sleep(30);
//		}catch(Exception e) {
//		}
//	}
//}
//}
//
//class SecondThread extends Thread{
//	public void run() {
//		for(int i = 0;i<100;i++) {
//			System.out.println("hello...");
//		try {
//			Thread.sleep(30);
//		}catch(Exception e) {
//	}
//}
//	}
//	
//}
//	
//
//public class Tester {
//
//	public static void main(String[] args) {
//		FirstThread ft = new FirstThread();
//		SecondThread st = new SecondThread();
//		ft.start();
//		st.start();
//		
//
//	}
//
//}
class MyThreads implements Runnable{
	private Thread t1,t2;
	
	public MyThreads() {
		t1 =new Thread(this,"first");
		t2=new Thread(this,"second");
		t1.start();
		t2.start();
	}
	
	public void run() {
		for(int i = 0;i<100;i++) {
			if(Thread.currentThread()==t1)
				System.out.println("hiii....");
			else if (Thread.currentThread()==t2)
				System.out.println("hello");
		}
	}
	
}
public class Tester{
	public static void main(String[] args) {
		MyThreads m = new MyThreads();
	}
}