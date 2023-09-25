import java.util.*;
//Vector - it is called as dynamically growing array
//public class Tester {
//	public static void main(String[] args) {
//		
//		Vector<Integer> v = new Vector<>();
//		v.add(10);
//		v.add(20);
//		v.add(30);
//		v.add(40);
//		v.add(50);
//		
//		System.out.println(v); // using toString
//		
//		for(Integer val:v)
//			System.out.print(val+" "); // using for-each loop
//		
//		System.out.println();
//		
//		Iterator<Integer> itr = v.iterator(); // using iterator
//		while(itr.hasNext()) {
//			System.out.print(itr.next()+" ");
//		}
//		
//		System.out.print(v.get(1));
//		System.out.println(v.);
//		
//	}
//		
//
//
//}
public class Tester {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println(list); // using toString
		
		for(Integer val:list)
			System.out.print(val+" "); // using for-each loop
		
		System.out.println();
		
		Iterator<Integer> itr = list.iterator(); // using iterator
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		System.out.print(list.get(1));
		
	}
		


}

