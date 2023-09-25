import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
	int employeeid;
	String name;
	double salary;
	
	public Employee() {
		
	}
	
	public Employee(int employeeid, String name, double salary) {
		this.employeeid = employeeid;
		this.name = name;
		this.salary = salary;
	}
	
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee id");
		employeeid = sc.nextInt();
//		System.out.println(employeeid+" ");
		System.out.println("Employee Name");
		name = sc.next();
		System.out.println("Employee salary");
//		System.out.println(name+" ");
		salary=sc.nextInt();	
			
	}
}
public class Tester {

	public static void main(String[] args) {
		int choice= 0;
		Employee e1= new Employee();
		e1.accept();
		ArrayList<Employee> e = new ArrayList<>();
		e.add(e1);
		System.out.println(e.get(0).name);
		for (int i=0; i<e.size();i++) {
			System.out.println(e.get(i).employeeid+" "+e.get(i).name+" "+e.get(i).salary);
		}
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.Add a record");
			System.out.println("2.Display record");
			System.out.println("3.Update");
			System.out.println("4.Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
			e1.accept();
			e.add(e1);
			break;
			case 2:
			System.out.println("Display details of account");
			for(int i =0;i<e.size();i++) {
			 System.out.println(e.get(i).employeeid+" ");
			}
			}
		}

	}

}
