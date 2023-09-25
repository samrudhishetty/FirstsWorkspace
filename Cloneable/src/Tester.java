class Vehicle implements Cloneable // if you dont add extend then it will strict you to clone 
{
	private String vehNumber;
	private String vehName;
	private int vehPrice;
	
	public Vehicle() {
		
	}
	public Vehicle(String vehNumber, String vehName, int vehPrice) {
		super();
		this.vehNumber = vehNumber;
		this.vehName = vehName;
		this.vehPrice = vehPrice;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	 public void show() {
		 System.out.println(vehNumber+" "+vehName+" "+vehPrice);
	 }
	
	
}
public class Tester {
	public static void main(String[] args) throws CloneNotSupportedException {
	Vehicle v = new Vehicle("MH04S94563","honda",231416);
	Vehicle v2=(Vehicle)v.clone();
	v.show();
	v2.show();
	}
}
