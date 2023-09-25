import java.util.*;
public class Tester {

	public static void main(String[] args) {
//		Map<Integer,String> map=new HashMap<>();
//		Map<Integer,String> map=new LinkedHashMap<>();  
		Map<Integer,String> map=new TreeMap<>();   // sort according to key
		map.put(345," roro");
		map.put(45," rohan");
		map.put(5," raju");


		System.out.println(map);
		
		Set<Integer> keys = map.keySet(); // this will print the key value
		System.out.println(keys);
        
		for(Integer key:keys) {
			System.out.println(map.get(key));
			
		}
		
//		if(map.containsKey("roro")) {
//			Integer a = map.get("roro");
//			System.out.println(a);
//		}
	}

}
