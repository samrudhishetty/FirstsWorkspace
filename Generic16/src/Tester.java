import java.util.*;

class Student{
	private int rollno;
	private String name;
	private double percentage;
	private Set<String> skillset;
	
	
	public Student() {
		
	}
	
	public Student(int rollno, String name, double percentage) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
		this.skillset=skillset;
	}
	
	
}
class Utility{
	private List<Student> list; // student will extract all object from class student

	public Utility(List<Student> list) {
		super();
		this.list = list;
	}
	Scanner sc = new Scanner(System.in);
	public void createList() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
		for (int i = 0; i < numStudents; i++)
		System.out.println("roll no ");
		 int rollno = sc.nextInt();
		System.out.println("name of Student");
		String name=sc.next();
		System.out.println("Percentage");
		double percentage = sc.nextDouble();
		System.out.print("Skills : ");
        String skillsInput = scanner.nextLine();
			
	}
	public void printList() {
		
	}
	@Override
	public String toString() {
		return "Utility [list=" + list + ", sc=" + sc + "]";
	}
	
}
public class Tester {

	public static void main(String[] args) {
		
		Student student = new Student(rollno+""+name+"" + percentage+" "+ skillset);
        list.add((T) student); // Type casting to T
	

	}

}
