package in.mindcraft;

public class WageEmployee extends Employee{ // this is inheritance employee is : 
//	parent class - base class , super class
//	wage employee: child class , subclass, derived class
	
	private int hours;
	private int rate;
	
	public WageEmployee() {//default constructor
		hours=0;
		rate=0;
	}
	public WageEmployee(int id,String n ,int d,int m,int y,int h,int r) {
		// why we are using super because the employee class object are private thats why we are using super 
		super(id,n,d,m,y); 
		hours=h;
		rate=r;
		
	}
	public void show() {
		super.show();
		System.out.println(hours);
		System.out.println(rate);
		
	}
	public int CalcSalary(){
			return hours*rate;
}
	

}
