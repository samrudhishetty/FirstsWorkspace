//public class Tester {
//	
//	public static double divide(int num , int deno ) throws Exception{
//		if (deno == 0) 
//			throw new Exception("denomenator is zero");
//		return (double)num/deno;
//	}
//	
////	public static void fn1() throws InterruptedException{
////       fn2();
////	}
////	public static void fn2() throws InterruptedException{
////		System.out.println("fn2...");
////		Thread.sleep(100);
////	}
//
//	public static void main(String[] args) {
////		try {
////			fn1(); // fn2 can be called 
////		}catch(Exception e ) {
////			e.printStackTrace();
////		}
//		
//		try {
//			System.out.println(divide(12,0));
//		}
//		catch(Exception e ) {
////			e.printStackTrace();  // this will throw expection and print in stack 
//			System.out.println(e);  // this will only throw the message 
//		}
//		
//
//	}
//
//}
class overload 
{
        int x;
        double y;
		public int a;
      void add(int a , int b) 
  {
         x = a + b;
                    }
    void add(double c , double d)
        {
            y = c + d;
        }

    overload() 
   {
            this.x = 0;
            this.y = 0;
     }        
        }    

class Tester{
	
        public static void main(String args[]) {
        	
            overload obj = new overload();   
            int a = 2;
            double b = 3.2;
            obj.add(a, a);
            obj.add(b, b);
            System.out.println(obj.x + " " + obj.a);  
                    }
}

