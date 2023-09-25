class Employee{
	private int employeeid;
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(int employeeid, String name, double salary) {
		this.employeeid = employeeid;
		this.name = name;
		this.salary = salary;
	}

	protected double getSalary() {
		return salary;
	}

	protected void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void show() {
		System.out.println(employeeid+" "+name+" "+salary);
	}

}


class Manager extends Employee{
    
    public Manager() {
    	
    }
   
    public Manager(int employeeid, String name, double sal) {
		super(employeeid, name, sal);
		
    }
    
 
    double sal = getSalary();
    
    double allowance = (0.08 * sal) + (0.12 * sal) + (0.04 * sal);
     
    public double calsalaryManager() {
    	double grossSalary = sal + allowance;
    	double netSalary = grossSalary - (0.125*sal);
		return netSalary;
    	
    }
    
}
class MarketingExecutive extends Employee {
	private int km;
	private double telephone_allowance = 2000;


	public MarketingExecutive(int empid, String name, double salary, int km) {
		super(empid, name, salary);
		this.km = km;

}

	double sal = getSalary();
	double allowances = (5 * km) + (telephone_allowance);


	public double calSalaryExecutive() {
		double netSalary = sal + allowances;
		return netSalary;
	}


}


public class Tester {
	
		public static void printObjects(Employee e) {
			e.show();
		}
		public static void main(String args[]) {
			
		Manager e1 = new Manager(101,"sam",10000);
		printObjects(e1);
		System.out.println("salary of manager is "+e1.calsalaryManager());
		MarketingExecutive m1= new MarketingExecutive(102, "sam", 10000, 10);
		System.out.println("salary of executive is " +m1.calSalaryExecutive());
	}
}


