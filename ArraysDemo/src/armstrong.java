public class armstrong {
	public static void main(String[] args) {
	int temp;	
	int num = 153;
    temp = num;
    int x =0 , sum = 0;
//     while(tempt >0) {
//    	 Tempt = tempt/10;
//    	 x++;
//     }
     while(num>0) {
    	 x = num %10;
    	 num = num/10;
    	 sum = sum+x*x*x;
     }
     if(temp==sum){ 	
     System.out.println("this is amstromg number");
     }else{
    	 System.out.println("not a number");
     }
	}
}

