
class Stack1 <G>{
	private int size ;
	private int top;
	private  G []arr;
	
	@SuppressWarnings("unchecked") 
	public Stack1() {
		size = 5;
		top = -1;
//		arr = new int [size];
		arr=(G[])new Object[size];
	}
	
	public boolean isFull() {
		return top==size-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	public void display() {
		for(int i=0;i <=top; i++) {
			System.out.println(arr[i]+" ");
		}
	}
	public Stack1(int s ) {
		size = 5;
		top = -1;
		arr=(G[])new Object[size];
	}
	public void push(G val) throws Exception {
		if(!isFull())
			 arr[++top]=val;
		else 
			throw new Exception("overflow");//the value will go first then increment from -1 to 0 
	}
	public G pop() throws Exception { //the value will go then decrement will happen
		if(!isEmpty())
		 return arr[top--];
		else 
			throw new Exception("stack is underflow");
	}
}
public class Tester1{

	public static void main(String[] args) {
		
		Stack1<Integer> s1= new Stack1<>(10); 
		try {
			s1.push(12);
			s1.push(24);
			s1.push(38);
			s1.push(3);
			s1.display();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		Stack1<String> s2= new Stack1<>(10);
		try {
			s2.push("info");
			s2.push("tcs");
			s2.push("mindcraft");
			s2.push("capegi");
			s2.display();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
	}

}

