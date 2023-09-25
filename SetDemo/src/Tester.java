import java.util.*;

class Laptop implements Comparable<Laptop>{// object
	private int id;
	private String make;
	private double cost;  

	
	public Laptop() {
		id = 100;
		make ="apple";
		cost=70500;
	}
	
	public Laptop(int id,String make,double cost) { 
		this.cost=cost;
		this.id=id;
		this.make=make;
		
	}
	public void show() {
		System.out.println(id+" "+make+" "+cost);
}
	
@Override
	public String toString() {
		return "Laptop [id=" + id + ", make=" + make + ", cost=" + cost + "]\n";
	}


//@Override
//public int hashCode() {
//	return Objects.hash(cost, id, make);
//}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Laptop other = (Laptop) obj;
	return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && id == other.id
			&& Objects.equals(make, other.make);
}

@Override
public int compareTo(Laptop o) { // this is compaarable use in ssame class when source code is avaible
	if(this.cost<o.cost)
		return -1;
	else if (this.cost>o.cost)
		return 1;
	else
		return 0;
}

protected int getId() {
	return id;
}


}
class LaptopComparator implements Comparator<Laptop>{ // if you dont have source code then you can crrate sepearate class and compare object

	@Override
	public int compare(Laptop o1, Laptop o2) { // jiska comapre karna hai usska getter create in laptop class 
		if(o1.getId()<o2.getId())
			return -1;
		else if (o1.getId()>o2.getId())
			return 1;
		else
			return 0;
	}
	
}
public class Tester {
	public static void main(String[] args) {
		Set<Laptop> set = new TreeSet <>();
		set.add(new Laptop(101,"dell",50000));
		set.add(new Laptop(103,"deedl",500600));
		set.add(new Laptop(104,"delddl",540000));
		set.add(new Laptop(102,"leno",500400));
		set.add(new Laptop(105,"window",530000));
		
		System.out.println(set);
		
		List<Laptop> list = new ArrayList <>();
		list.add(new Laptop(101,"dell",50000));
		list.add(new Laptop(103,"deedl",500600));
		list.add(new Laptop(104,"delddl",540000));
		list.add(new Laptop(102,"leno",500400));
		list.add(new Laptop(105,"window",530000));
		//list which we want to sort and criteria of comparator in collection 
		Collections.sort(list,new LaptopComparator());
		System.out.println(list);
		
	}
	
////		Set<Integer> set = new HashSet<>();
////		Set<Integer> set = new LinkedHashSet<>();
//		Set<Integer> set = new TreeSet <>();
//	    set.add(12);
//	    set.add(10);
//	    set.add(5);
//	    set.add(45);
//	    set.add(12);
//	    System.out.println(set);
	    
		
	}


