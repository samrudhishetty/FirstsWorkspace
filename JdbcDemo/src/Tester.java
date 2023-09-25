import java.sql.*;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id make cost of laptop");
		int lid = sc.nextInt();
		String make = sc.next();
		double cost = sc.nextDouble();		
		//establish the connection from database
		 // to take from user 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test_schema","root","root");
		PreparedStatement pstmt =conn.prepareStatement("Insert into laptop values(?,?,?)");
		pstmt.setInt(1, lid);
		pstmt.setString(2, make);
		pstmt.setDouble(3, cost);
		
		boolean status=pstmt.execute();	
//		Statement stmt=conn.createStatement();
//		boolean  status=  stmt.execute("Insert into Laptop values(101,'abc',35000)");
		if(!status)
		{
			System.out.println("row inserted succesfully ");
		}
		// close the connection 
		conn.close();
		
		
	}

}
