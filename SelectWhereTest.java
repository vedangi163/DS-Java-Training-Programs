import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereTest {
	public static void main(String[] args) throws EmpNotFoundException {
		
		
		try 
		{
			System.out.println("");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("driver registered");
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			Statement statement = con.createStatement();
			System.out.println("statement created");
			
			System.out.println("Enter employee id: ");
			Scanner sc = new Scanner(System.in);
			int empId = sc.nextInt();
			
			ResultSet rs = statement.executeQuery("select * from employee where empno = "+empId);
			
			if(rs.next())
			{
				System.out.println("Emp no: "+rs.getInt(1));
				System.out.println("Emp name: "+rs.getString(2));
				System.out.println("Emp salary: "+rs.getInt(3));
				System.out.println("----------------------");
			}
			else
			{
				throw new EmpNotFoundException("Employee is not present with eployee id "+empId);
			}
			rs.close();
			statement.close();
			con.close();
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
	}
}
