import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		
//	int[] a = new int[]{4,3,5,6};
//	int[] b = {9,0,8,7};
//	int[]c = new int[3];
//	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("enter the 3 number");
//	for (int i = 0;i<c.length;i++)
//		c[i]=sc.nextInt();
//	
//	for (int i = 0;i<c.length;i++)
//		System.out.print(c[i]+" ");
		
		// write a element to find out maximum and minimum value
//		array without sorting the element
		int i;
		int[]a = new int[3];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the 3 number");
		for(i =0;i<a.length;i++)
		   a[i]=sc.nextInt();
		
		int max = a[0];
		int min = a[0];
		for(i = 1;i<a.length;i++) {
		 if(a[i]>max) {
			 max=a[i];
		}else if(a[i]<min){
			min=a[i];
			}
		}
		System.out.println("maximum value "+max);
		System.out.println("min value"+min);
		
		
    
	}

}
