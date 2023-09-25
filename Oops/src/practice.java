class Pen{//we will define properties of pen inside this
		String color;
		String type; //gel or ballpoint
		
		public void write() {
			System.out.println("writing something");
		}
		
		
}

public class practice {

	public static void main(String[] args) {
		Pen pen1= new Pen();
		pen1.color = "blue";
		pen1.type="gel";
		
		pen1.write();

	}

}
