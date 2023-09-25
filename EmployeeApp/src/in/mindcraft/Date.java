package in.mindcraft;
// useability you cannot keep ctreating from stcract everytime you craete application 
//so we use conatainemnt and inheritance
public class Date {
  private int dd,mm,yy;
  
  public Date() {//deflaut constuctor
	  dd=1;
	  mm=1;
	  yy=2000;
  }
  public Date(int d , int m,int y) {
	  // parametersized constructor
	  dd=d;
	  mm=m;
	  yy=y;
  }
  public void show() {
	  System.out.println(dd+"/"+mm+"/"+yy);
  }
}
