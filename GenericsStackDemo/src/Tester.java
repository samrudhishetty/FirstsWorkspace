class Stack{
	private int size ;
	private int top;
	private int []arr;
	
	public Stack() {
		size = 5;
		top = -1;
		arr = new int [size];
	}
	
	public boolean isFull() {
		return top==size-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	public void display() {
		for(int i=0;i <=top; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public Stack(int s ) {
		size = 5;
		top = -1;
		arr = new int [size];
	}
	public int push(int val) throws Exception {
		if(!isFull())
			return arr[++top]=val;
		else 
			throw new Exception("overflow");//the value will go first then increment from -1 to 0 
	}
	public int pop() throws Exception { //the value will go then decrement will happen
		if(!isEmpty())
		 return arr[top--];
		else 
			throw new Exception("stack is underflow");
	}
}
public class Tester {

	public static void main(String[] args) {
		
		Stack s1= new Stack(10); 
		try {
			s1.push(12);
			s1.push(24);
			s1.push(38);
			s1.push(3);
			s1.push(8);
			System.out.println(s1.pop());
			System.out.println(s1.pop());
			System.out.println(s1.pop());
			s1.display();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
	}

}
