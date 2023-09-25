//VarArgsn - variable Argument list
public class Objects {
	public static int add(int ...a) {//variable argument shoukd be last parameter
		int sum =0;      //those three dots are called ellipses 
		for(int i =0;i<a.length;i++)
			sum=sum+a[i];
			
		return sum;
	}


	public static void main(String[] args) {
		System.out.println(add("addition",1,2,3,4));
	
}

}
