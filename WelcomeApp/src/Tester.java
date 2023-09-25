import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		
		//ctrl space is to autocomplete
		// ctrl click is to swtich to definition
//		System.out.println("enter two values");
//		int a , b;
//		Scanner sc= new Scanner(System.in);
//		a=sc.nextInt();
//		b=sc.nextInt();
//		int c = a +b;
//		System.out.println("addition is "+c);
		
		
		// swap to two numbers 
		System.out.println("enter two values");
		int a , b;
		Scanner sc= new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		int c ;
		c=a;
		a=b;
		b=c;
//		or
//		a=a+b;
//		b=a-b;
//		a=a-b;
		
		
		System.out.println(a+" " +b);
		
		
	}

}
