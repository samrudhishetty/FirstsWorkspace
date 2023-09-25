abstract class Polygon{
	public abstract double calcArea();
	public abstract double calcPeri();
	
}

class Circle extends Polygon{
	private int radius;
	
	public Circle() {
		radius=1;
	}
	public Circle(int r) {
		radius=r;
	}
	public double calcArea() {
		return 3.142f*radius*radius;
	}
	public double calcPeri() {
		return 2*3.142*radius;
		
	}
}
class Rectangle extends Polygon{
	private int len , brd ;
	
	public Rectangle() {
		len=brd=1;
	}
	public Rectangle(int l , int b) {
		len = l;
		brd= b;
		}
	public double calcArea() {
		return len*brd;
	}
	public double calcPeri() {
		return 2*(len+brd);
		}
		
}
class Square extends Rectangle{
	
	public Square() {
		}
	public Square(int s) {
		super(s,s);
	}
	public double calcArea() {
		return super.calcArea();
	}
	public double calcPeri() {
		return super.calcPeri();
	}
}
public class Tester {

	public static void main(String[] args) {
		
		Circle c = new Circle(1);
		System.out.println("perimeter of circle is " +c.calcPeri());
		Rectangle r = new Rectangle(2,2);
		System.out.println("Area of rectangle is " + c.calcArea());
		Polygon p = new Circle(5);
		System.out.println(p.calcArea());
			

	}

}
