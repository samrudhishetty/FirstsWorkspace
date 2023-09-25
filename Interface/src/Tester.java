interface printable{
	public void printDetails();
}

class Cricket implements printable {
	private String name;
	private int runs;
	
	public Cricket() {
		name="rohit";
		runs=0;
	}
	public Cricket(String n ,int r) {
		this.name=n;
		this.runs=r;
		
		}
	public void printDetails() {
		System.out.println(name +" "+runs);
	}
	
	}
class Football implements printable {
	private String name;
	private int goals;
	
	public Football() {
		name="Messi";
		goals=0;
	}
	public Football(String nn ,int g) {
		name=nn;
		goals=g;
		
		}
	public void printDetails() {
		System.out.println(name+" "+ goals );
	}
	
	}

public class Tester {

	public static void main(String[] args) {
		Cricket c = new Cricket("Rohit",100);
		c.printDetails();
		Football f = new Football("Messi",3);
		f.printDetails();
		

	}

}
