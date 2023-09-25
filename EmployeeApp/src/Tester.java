import in.mindcraft.Employee;
import in.mindcraft.SalesPerson;
import in.mindcraft.WageEmployee;

public class Tester {
	public static void main(String[] args)
	{
//		Employee e1 = new Employee();// this will call the constructor default wala
//		e1.show();
//		System.out.println();
//		Employee e2 = new Employee(222,"raja",10,10,1996);// this will call the contructor with paramater
//		e2.show();
		
//		WageEmployee we = new WageEmployee(123,"purr",12,9,1990,14,45);
//		we.show();
		
		SalesPerson sale = new SalesPerson(123,"purr",12,9,2001,12,45,100,123);
		sale.show();
		System.out.println("calculate the salary "+sale.CalcSalary());
		
	}
}
