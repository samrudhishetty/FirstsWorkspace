package in.mindcraft;

public class SalesPerson extends WageEmployee {
	private int sales;
	private int comm;
	
	public SalesPerson() {//default constructor
		sales=0;
		comm=0;
	}
	public SalesPerson(int id,String n ,int d,int m,int y,int h,int r,int s,int c) {
		// why we are using super beacuse the employee class object are private thats why we are using super 
		super(id,n,d,m,y,r,h); 
		sales=s;
		comm=c;
		
	}
	public int CalcSalary(){
		return super.CalcSalary()+sales*comm;
}
	public void show() {
		super.show();
		System.out.println(sales);
		System.out.println(comm);
		super.CalcSalary();
		
	}

}
