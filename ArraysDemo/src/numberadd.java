import java.util.Scanner;
public class numberadd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the n");
		int num= sc.nextInt();
		int sum = 0;
		for(int i = 1;i <=num;i++) {
			sum = sum +i;
		}
		System.out.println("number of n numbers " +sum);
	}

}
