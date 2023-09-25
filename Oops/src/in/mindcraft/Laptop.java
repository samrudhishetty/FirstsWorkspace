
public class Laptop {// object
	private int id;
	private String make;
	private double cost;  
	private static int cnt;
	
	public Laptop() {
		id = 100;
		make ="apple";
		cost=70500;
		cnt++;
	}
	
	public Laptop(int id,String make,double cost) { 
		this.cost=cost;
		this.id=id;
		this.make=make;
		cnt++;
	}
	
	public  static void showcnt() { // only static variable can call static 
		System.out.println("no of obejcts "+cnt);
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getMake() {
//		return make;
//	}
//
//	public void setMake(String make) {
//		this.make = make;
//	}
//
//	public double getCost() {
//		return cost;
//	}
//
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
	public void show() {
		System.out.println(id+" "+make+" "+cost);
}
}