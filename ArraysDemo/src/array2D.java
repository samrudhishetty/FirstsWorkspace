import java.util.Scanner;
public class array2D {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[][]a = {{1,2,3},{1,2,4},{4,5,6}};
//		int[][] b = {{1,4,2,3},{1,2,4},{5,6}}; // jagged element becuase diffent row and col
//		7t[][] d = new int[3][]; // you have rows but col is not decided 
//		d[0]= new int [4]; // this is how u can intialize the no of col
//		d[1]= new int [3];
//		d[2]= new int [2];
//		System.out.println("enter elements for array d");
//		
//		for(int i = 0;i<d.length;i++) {
//			for(int j = 0; j<d[i].length;j++) { //this is for col
//				d[i][j]=sc.nextInt();
//			}
//		}
//		for(int []temp:d) { // thsi is to print using fir each loop
//			for(int val:temp) {
//				System.out.print(val+" ");
//			}
//			System.out.println();
		
//		Tranpose array
		
		
		int[][] a = new int [3][3];
		int[][] b = new int [3][3];
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the matrix");
		
		for(int i = 0;i<a.length;i++) {
			for(int j = 0; j<a[i].length;j++) { //this is for col
				a[i][j]=sc.nextInt();
			}
		}
		for(int i = 0;i<a.length;i++) {
			for(int j = 0; j<a[i].length;j++) { //this is for col
				b[j][i]=a[i][j];
			}
		}
		for(int []temp1:b) {
			for(int val:temp1){
				System.out.print(val+" ");
			}
			System.out.println();
		}

	}

}
