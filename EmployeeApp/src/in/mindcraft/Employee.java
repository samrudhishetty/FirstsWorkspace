package in.mindcraft;

public class Employee {
	private int empid;
	private String name;
	private Date dob;
	
	public Employee() { //new employee while creating itb was call defaut constructor
		empid=101;
		name="abc";
		dob=new Date(); // default constructor
	}
	public Employee(int id,String n ,int d,int m,int y) {
		empid=id;
		name=n;
		dob=new Date(d,m,y);
		}
	public void show() {
		System.out.println(empid);
		System.out.println(name);
		dob.show();
		
	}
}
